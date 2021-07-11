import models.Lesson;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class LessonRepositoryJDBCTemplateImpl implements LessonRepository{

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;


    public LessonRepositoryJDBCTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //language=SQL
    private static final String  SELECT_FIND_BY_ID = "select * from course c where id = ? order by id ";


}
