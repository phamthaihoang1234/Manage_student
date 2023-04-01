package com.example.manage_student_lap_ia.services;


import com.example.manage_student_lap_ia.entities.Student;
import com.example.manage_student_lap_ia.entities.Subject;
import com.example.manage_student_lap_ia.entities.UserNotFoundException;
import com.example.manage_student_lap_ia.repositories.StudentRepository;
import com.example.manage_student_lap_ia.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentRepository stuRepo;

    @Autowired
    private SubjectRepository subRepo;




    public List<Student> listAll() {
        return stuRepo.getAllActive();
    }

    public void save(Student student) {
        stuRepo.save(student);
    }

    public Student get(Integer id) throws UserNotFoundException {
        Optional<Student> result = stuRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundException  {
        Long count = stuRepo.countStudentById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any users with ID " + id);
        }
        stuRepo.deleteById(id);;

    }

    public void deleteSubject(Integer idSub , Integer idStu) throws UserNotFoundException {

        Student s = stuRepo.findById(idStu).get();


        List<Subject> subjectList = subRepo.findSubjectsByStudentId(idStu);
        System.out.println("so luong subject khi chua xoa"+ subjectList.size());

        for (int i = 0; i< subjectList.size(); i++){
          if(subjectList.get(i).getId() == idSub){
              s.getSubjects().remove(subjectList.get(i));
          }
      }
        stuRepo.save(s);
        System.out.println("so luong subject sau khi xoa ơ service la"+ subjectList.size());
    }

}
