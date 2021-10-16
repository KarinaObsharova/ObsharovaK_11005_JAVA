package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AccountsRepositoryJdbcImpl implements AccountsRepository{

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id";

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into account(first_name, last_name, login, password) " +
            "values (?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_CONTAINS_PASSWORD_LOGIN = "select * from account where login = ? and password = ?";


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountsRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<User> accountRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String login = row.getString("login");
        String password = row.getString("password");

         return new User(id, firstName, lastName, login, password);
    };

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, accountRowMapper);
    }

    @Override
    public void save(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, new String[]{"id"});

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getLoginUser());
            statement.setString(4, user.getPasswordUser());

            return statement;
        }, keyHolder);
        Integer userID = keyHolder.getKey().intValue();
        user.setId(userID);
    }

    @Override
    public boolean contains(String login, String password) {
        List<User> listUser = jdbcTemplate.query(SQL_SELECT_CONTAINS_PASSWORD_LOGIN, accountRowMapper, login, password);
        return !listUser.isEmpty();
    }
}
