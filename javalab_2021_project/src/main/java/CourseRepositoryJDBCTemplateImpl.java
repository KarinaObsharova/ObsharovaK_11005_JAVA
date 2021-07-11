import models.Course;
import models.Student;
import models.Teacher;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CourseRepositoryJDBCTemplateImpl implements CourseRepository{

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;


    public CourseRepositoryJDBCTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String  SELECT_FIND_BY_ID = "select * from course where id = ? order by id";

    //language=SQL
    private static final String  SELECT_FIND_BY_ID_TEACHER = "select * from teacher where id = ? order by id";


    //language=SQL
    private static final String  SELECT_FIND_ALL = "select * from course c order by id";

    //language=SQL
    private static final String  SELECT_ALL_STUDENTS = "select * from student s, students_courses_relation sc where sc.course_id = ? and cs.student_id = s.id";



    private final RowMapper<Teacher> teacherRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String experience = row.getString("experience");


        Teacher teacher =  new Teacher(id, firstName,  lastName, experience);
        return teacher;

    };

    private final RowMapper<Course> courseRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String name = row.getString("name");
        String dateStart = row.getString("date_start");
        String dateEnd = row.getString("data_end");
        Teacher teacher = findByIdTeacher(row.getInt("teacher_id")).get();
        List<Student> students = findAllStudents(row.getInt("id"));

        Course course = new Course(id, name, dateStart, dateEnd, teacher);
        course.setStudentList(students);

        return course;

    };

    private final RowMapper<Student> studentRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String name = row.getString("first_name");
        String lastName = row.getString("last_name");
        String groupNumber = row.getString("number_group");

        Student student = new Student(id, name, lastName, groupNumber);
        return student;
    };




    @Override
    public Optional<Course> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SELECT_FIND_BY_ID, courseRowMapper,id));
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }

    }

    @Override
        public Optional<Teacher> findByIdTeacher(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SELECT_FIND_BY_ID_TEACHER, teacherRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }



    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query(SELECT_FIND_ALL, courseRowMapper);
    }

    @Override
    public List<Student> findAllStudents(Integer id) {
        return jdbcTemplate.query(SELECT_ALL_STUDENTS, studentRowMapper, id);
    }


}
