package models;

public class Lesson {
    private String name;
    private String dayWeek;
    private String time;
    private Course course;

    public Lesson(String name, String dayWeek, String time) {
        this.name = name;
        this.dayWeek = dayWeek;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", dayWeek='" + dayWeek + '\'' +
                ", time='" + time + '\'' +
                ", course=" + course.getName() +
                '}';
    }
}
