package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.repositories.AccountsRepository;

@Component
public class SignInService {
    private final AccountsRepository accountsRepository;

@Autowired
    public SignInService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public boolean singIn(String login, String password){
        return accountsRepository.contains(login, password);
    }
}
