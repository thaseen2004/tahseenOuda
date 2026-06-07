package firstProject.example.tahseenOuda.repository;

import firstProject.example.tahseenOuda.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}