import models.Lesson;

import java.util.Optional;

public interface LessonRepository {
    Optional<Lesson> findById(Integer id);

    void save(Lesson lesson, Integer CoursesID);

    void update(Lesson lesson);

    Optional<Lesson> findByName(String name);
}
