import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;


public class PasswordBlackListJDBCImpl implements PasswordBlackList{
    private JdbcTemplate jdbcTemplate;

    public PasswordBlackListJDBCImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from password_black_list where password = ?";

    private final RowMapper<String> stringRowMapper = (row, rowNumber) -> {
        String str = row.getString("password");
        return str;
    };

    @Override
    public boolean contains(String password) {
              List<String> listPassword = jdbcTemplate.query(SQL_SELECT_ALL, stringRowMapper, password);
        return !listPassword.isEmpty();



    }
}
