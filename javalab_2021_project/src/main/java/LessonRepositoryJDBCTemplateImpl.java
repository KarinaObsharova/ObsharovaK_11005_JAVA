import models.Course;
import models.Lesson;
import models.Student;
import models.Teacher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LessonRepositoryJDBCTemplateImpl implements LessonRepository {

    private JdbcTemplate jdbcTemplate;

    private CourseRepository courseRepository;


    public LessonRepositoryJDBCTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.courseRepository = new CourseRepositoryJDBCTemplateImpl(dataSource);
    }


    //language=SQL
    private static final String SELECT_FIND_BY_ID = "select * from lesson where id = ? order by id";

    //language=SQL
    private static final String SELECT_ID_COURSES = "select course_id from lesson_courses_relation where lesson_id = ? ";


    //language=SQL
    private static final String SQL_INSERT_LESSON = "insert into lesson(name, day_week, time) " +
            "values (?, ?, ?)";

    //language=sql
    private static final String UPDATE_COURSE =
            "update course set name = ?, date_start = ?, data_end = ? where id = ?";


    // дано айди курса присвоить урок к курсу
    //language=SQL
    private static final String SELECT_LESSON_AND_COURSES = "insert into lesson_courses_relation(lesson_id, course_id) " +
            "values (?,?)";

    //language=SQL
    private static final String UPDATE_LESSON = "update lesson set name = ?, day_week = ?, time = ? where id = ?";

    //language=SQL
    private static final String SELECT_FIND_BY_NAME = "select * from lesson where name = ?";

    private final RowMapper<Teacher> teacherRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String experience = row.getString("experience");


        return new Teacher(id, firstName, lastName, experience);

    };

    private final RowMapper<Course> courseRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String name = row.getString("name");
        String dateStart = row.getString("date_start");
        String dateEnd = row.getString("data_end");


        Course course = new Course(id, name, dateStart, dateEnd);


        return course;

    };
    private final ResultSetExtractor<Lesson> lessonResultSetExtractor = rs -> {
        rs.next();
        return new Lesson(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("day_week"),
                rs.getString("time"));
    };

    private final RowMapper<Student> studentRowMapper = (row, rowNumber) -> {
        Integer id = row.getInt("id");
        String name = row.getString("first_name");
        String lastName = row.getString("last_name");
        String groupNumber = row.getString("number_group");

        return new Student(id, name, lastName, groupNumber);
    };
    RowMapper<Integer> coursesIdMapper = (rs, row) -> rs.getInt("course_id");


    @Override
    public Optional<Lesson> findById(Integer id) {
        Lesson lesson;
        try {
            lesson = jdbcTemplate.query(SELECT_FIND_BY_ID, lessonResultSetExtractor, id);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
        assert lesson != null;
        lesson.setCourse(new ArrayList<>());
        List<Integer> list = jdbcTemplate.query(SELECT_ID_COURSES, coursesIdMapper, id);
        list.forEach(x -> lesson.getCourse().add(courseRepository.findById(x).orElseThrow(IllegalArgumentException::new)));
        return Optional.of(lesson);

    }

    // урок присваевается уже существующему курсу
    @Override
    public void save(Lesson lesson, Integer idCourses) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_LESSON, new String[]{"id"});

            statement.setString(1, lesson.getName());
            statement.setString(2, lesson.getDayWeek());
            statement.setString(3, lesson.getTime());

            return statement;
        }, keyHolder);

        Integer lessonID = Objects.requireNonNull(keyHolder.getKey()).intValue();
        lesson.setId(lessonID);

        jdbcTemplate.update(SELECT_LESSON_AND_COURSES, lessonID, idCourses);
    }


    @Override
    public void update(Lesson lesson) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(UPDATE_LESSON);

                    statement.setString(1, lesson.getName());
                    statement.setString(2, lesson.getDayWeek());
                    statement.setString(3, lesson.getTime());
                    statement.setInt(4, lesson.getId());
                    return statement;
                }
        );

    }

    @Override
    public Optional<Lesson> findByName(String name) {
        Lesson lesson;
        try {
            lesson = jdbcTemplate.query(SELECT_FIND_BY_NAME, lessonResultSetExtractor, name);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
        assert lesson != null;
        lesson.setCourse(new ArrayList<>());
        List<Integer> list = jdbcTemplate.query(SELECT_ID_COURSES, coursesIdMapper, lesson.getId());
        list.forEach(x -> lesson.getCourse().add(courseRepository.findById(x).orElseThrow(IllegalArgumentException::new)));
        return Optional.of(lesson);

    }
}

