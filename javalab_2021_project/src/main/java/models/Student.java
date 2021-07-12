package models;

public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String numberGroup;
    private Course course;

    public Student(Integer id, String firstName, String lastName, String numberGroup) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberGroup = numberGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberGroup='" + numberGroup + '\'' +
                '}';
    }
}
