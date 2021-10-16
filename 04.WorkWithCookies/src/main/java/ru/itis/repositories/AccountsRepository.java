package ru.itis.repositories;

import ru.itis.models.User;
import java.util.List;

public interface AccountsRepository {
    List<User> findAll();
    void save(User user);
    boolean contains(String password, String login);
}
