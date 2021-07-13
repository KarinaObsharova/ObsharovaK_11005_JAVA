import models.Course;
import models.Teacher;
import java.util.Optional;

public interface CourseRepository {
  Optional<Course> findById(Integer id);
  void save(Course course, Teacher teacher);
  void update(Course course);
  Optional<Course> findByName(String name);



}
