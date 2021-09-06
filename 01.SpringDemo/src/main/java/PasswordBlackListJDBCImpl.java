import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PasswordBlackListJDBCImpl implements PasswordBlackList{
    private JdbcTemplate jdbcTemplate;

    public PasswordBlackListJDBCImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from password_black_list where password = ?";

    @Override
    public boolean contains(String password) {
        Integer cnt = jdbcTemplate.queryForObject(SQL_SELECT_ALL, Integer.class, password);
        return cnt == null;



    }
}
