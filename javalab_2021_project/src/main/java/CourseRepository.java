import models.Course;
import models.Student;
import models.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
  Optional<Course> findById(Integer id);
  /*List<Course> findAll();*/
  void save(Course course);


}
