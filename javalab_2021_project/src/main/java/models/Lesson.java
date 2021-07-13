package models;

import java.util.List;

public class Lesson {
    private Integer id;
    private String name;
    private String dayWeek;
    private String time;

    private List<Course> course;

    public Lesson(String name, String dayWeek, String time) {
        this.name = name;
        this.dayWeek = dayWeek;
        this.time = time;
    }

    public Lesson() {
    }

    public Lesson(Integer id, String name, String dayWeek, String time) {
        this.id = id;
        this.name = name;
        this.dayWeek = dayWeek;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<Course> getCourse() {
        return course;
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


    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", dayWeek='" + dayWeek + '\'' +
                ", time='" + time + '\'' +
                ", course=" + course +
                '}';
    }
}
