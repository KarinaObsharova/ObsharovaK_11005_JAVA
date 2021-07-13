import models.Course;
import models.Student;
import models.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
  Optional<Course> findById(Integer id);
  void save(Course course, Teacher teacher);
  void update(Course course);
  Optional<Teacher> findByIdTeacher(Integer id);



}
