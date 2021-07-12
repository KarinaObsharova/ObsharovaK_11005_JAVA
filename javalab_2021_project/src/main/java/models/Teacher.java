package models;

import java.util.List;

public class Teacher {
    private Integer id;
    private String firstName;
    private String lastName;
    private String experience;
    private Course course;


    public Teacher(Integer id, String firstName, String lastName, String experience) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
    }
    public Teacher( String firstName, String lastName, String experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", experience='" + experience + '\'' +
                /*", course=" + course.getName() +*/
                '}';
    }
}
