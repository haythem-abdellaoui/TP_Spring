package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Repository.CourseRepository;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {
    
    private CourseRepository courseRepository;
    


}
