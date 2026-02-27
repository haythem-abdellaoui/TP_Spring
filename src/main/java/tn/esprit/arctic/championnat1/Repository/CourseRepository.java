package tn.esprit.arctic.championnat1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.arctic.championnat1.Entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
