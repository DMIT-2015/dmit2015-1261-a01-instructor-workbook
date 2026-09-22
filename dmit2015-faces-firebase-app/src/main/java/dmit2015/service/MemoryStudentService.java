package dmit2015.service;

import dmit2015.model.Student;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named("memoryStudentService")
@ApplicationScoped
public class MemoryStudentService implements StudentService{

    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    void init() {
        // Generate 32 students
        var faker = new Faker();
        for (int count = 1; count <= 32; count++) {
            Student currentStudent = Student.of(faker);
            createStudent(currentStudent);
        }

    }

    @Override
    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student updateStudent(Student student) {
        return student;
    }

    @Override
    public void deleteStudentById(String id) {
        Optional<Student> maybeStudent = getStudentById(id);
        if (maybeStudent.isPresent()) {
            Student existingStudent = maybeStudent.orElseThrow();
            students.remove(existingStudent);
        }
    }
}
