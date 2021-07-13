import models.Course;
import models.Student;
import models.Teacher;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CourseRepositoryJDBCTemplateImpl implements CourseRepository{


    private DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;


    public CourseRepositoryJDBCTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String  SELECT_FIND_BY_ID = "select * from course where id = ? order by id";

    //language=SQL
    private static final String  SELECT_FIND_BY_ID_TEACHER = "select * from teacher where id = ? order by id";


    //language=SQL
    private static final String  SELECT_FIND_ALL = "select * from course c order by id";

// айди. учителей и студентов
    //language=SQL
    private static final String  SELECT_ALL_STUDENTS = "select  *" +
                                                       " from student s inner join students_courses_relation sc" +
                                                       " on  sc.stud_id = s.id " +
                                                       " where sc.course_id = ?";

    //language=SQL
    private static final String  SELECT_ALL_TEACHER = "select  *" +
            " from teacher t inner join teacher_courses_relation tc on tc.teacher_id = t.id " +
            " where tc.course_id = ?";

    //language=SQL
    private static final String SQL_INSERT_COURSE = "insert into course(name, date_start, data_end) " +
            "values (?, ?, ?)";

    //language=SQL
    private static final String SQL_INSERT_TEACHER = "insert into teacher(first_name, last_name, experience) " +
            "values (?, ?, ?)";

    //language=SQL
    private static final String SQL_TEACHER_COURSES_RELATION = "insert into teacher_courses_relation(teacher_id, course_id) " +
            "values (?,?)";

    //language=sql
    private static final String UPDATE_COURSE =
            "update course set name = ?, date_start = ?, data_end = ? where id = ?";

    //language=sql
    private static final String UPDATE_TEACHER = "update teacher set first_name = ?, last_name = ?, experience = ? where id = ?";







    private final RowMapper<Teacher> teacherRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String experience = row.getString("experience");


        return new Teacher(id, firstName,  lastName, experience);

    };

    private final RowMapper<Course> courseRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String name = row.getString("name");
        String dateStart = row.getString("date_start");
        String dateEnd = row.getString("data_end");


        Course course = new Course(id, name, dateStart, dateEnd);


        return course;

    };
    private final ResultSetExtractor<Course> courseResultSetExtractor = rs -> {
        rs.next();
       return new Course(rs.getInt("id"),
               rs.getString("name"),
               rs.getString("date_start"),
               rs.getString("data_end"));
    };
    private final ResultSetExtractor<Student> studentResultSetExtractor = rs -> {
        rs.next();
        return new Student(rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("number_group"));
    };
    private final ResultSetExtractor<Teacher> teacherResultSetExtractor = rs -> {
        rs.next();
        return new Teacher(rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("experience"));
    };

    private final RowMapper<Student> studentRowMapper = (row, rowNumber) -> {
        Integer id = row.getInt("id");
        String name = row.getString("first_name");
        String lastName = row.getString("last_name");
        String groupNumber = row.getString("number_group");

        return new Student(id, name, lastName, groupNumber);
    };




    @Override
    public Optional<Course> findById(Integer id) {
        Course course;
        try {
            course = jdbcTemplate.query(SELECT_FIND_BY_ID, courseResultSetExtractor,id);
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
        assert course != null;
        course.setStudentList(jdbcTemplate.query(SELECT_ALL_STUDENTS,
                studentRowMapper, id));
        course.setTeacherList(jdbcTemplate.query(SELECT_ALL_TEACHER,
                teacherRowMapper, id));
        return Optional.of(course);

    }

    @Override
    public void save(Course course, Teacher teacher){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_COURSE, new String[] {"id"});

            statement.setString(1, course.getName());
            statement.setString(2, course.getDateStart());
            statement.setString(3, course.getDateEnd());

            return statement;
        }, keyHolder);
        Integer courseID = keyHolder.getKey().intValue();
        course.setId(courseID);

            jdbcTemplate.update(connection -> {
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT_TEACHER, new String[]{"id"});

                statement.setString(1, teacher.getFirst_name());
                statement.setString(2, teacher.getLast_name());
                statement.setString(3, teacher.getExperience());
                return statement;
            }, keyHolder);

            Integer teacherID = keyHolder.getKey().intValue();
            teacher.setId(teacherID);
            jdbcTemplate.update(SQL_TEACHER_COURSES_RELATION, teacherID, courseID);
    }

    @Override
    public void update(Course course) {

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(UPDATE_COURSE);

                    statement.setString(1, course.getName());
                    statement.setString(2, course.getDateStart());
                    statement.setString(3, course.getDateEnd());
                    statement.setInt(4, course.getId());
                    return statement;
                }
          );
        }


    @Override
        public Optional<Teacher> findByIdTeacher(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_ALL_TEACHER, teacherRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


}
