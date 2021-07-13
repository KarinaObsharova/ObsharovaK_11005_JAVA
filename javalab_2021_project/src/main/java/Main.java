import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import models.Course;
import models.Lesson;
import models.Teacher;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src//main//resources//application.properties"));

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(properties.getProperty("db.driver"));
        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setUsername(properties.getProperty("db.user"));
        config.setPassword(properties.getProperty("db.password"));


        DataSource dataSource = new HikariDataSource(config);
        CourseRepository courseRepository = new CourseRepositoryJDBCTemplateImpl(dataSource);

        System.out.println(courseRepository.findById(1));

        Teacher teacher = new Teacher("Александр", "Лицкеевич", "7");
        Course course = new Course("JAVA", "example", "example");
        courseRepository.save(course, teacher);

        Course courseMathematics = courseRepository.findById(3).orElse(new Course());
        courseMathematics.setName("Mathematics");
        courseMathematics.setDateStart("1.09.21");
        courseMathematics.setDateEnd("29.05.21");
        courseRepository.update(courseMathematics);

        System.out.println(courseRepository.findByName("JavaLab"));

        LessonRepository lessonRepository = new LessonRepositoryJDBCTemplateImpl(dataSource);
        System.out.println(lessonRepository.findById(1));

        Lesson lesson = new Lesson("Function", "Monday", "13:00");
        lessonRepository.save(lesson, 3);

        Lesson lesson1 = lessonRepository.findById(1).orElse(new Lesson());
        lesson1.setName("Matrices");
        lesson1.setDayWeek("Monday");
        lesson1.setTime("8:00");
        lessonRepository.update(lesson1);

        System.out.println(lessonRepository.findByName("Matrices"));


    }


}
