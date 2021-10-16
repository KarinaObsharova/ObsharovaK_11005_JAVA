package ru.itis.models;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String LoginUser;
    private String passwordUser;

    public User(Integer id, String firstName, String lastName, String loginUser, String passwordUser) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        LoginUser = loginUser;
        this.passwordUser = passwordUser;
    }

    public User(String firstName, String lastName, String loginUser, String passwordUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        LoginUser = loginUser;
        this.passwordUser = passwordUser;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLoginUser() {
        return LoginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
