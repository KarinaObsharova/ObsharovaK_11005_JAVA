import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import models.Course;
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
        /*System.out.println(courseRepository.findAllStudents(4));*/
        /*System.out.println(courseRepository.findAll());*/
       /* Teacher teacher = new Teacher( "Александр", "Лицкеевич", "7");
        Course course = new Course("JAVA", "example", "example");
        courseRepository.save(course, teacher);*/
      /*  Course courseMathematics = courseRepository.findById(3).orElse(new Course());
        courseMathematics.setName("Mathematics");
       courseMathematics.setDateStart("1.09.21");
       courseMathematics.setDateEnd("29.05.21");

        courseRepository.update(courseMathematics);*/
        System.out.println(courseRepository.findByIdTeacher(1));





    }


}
