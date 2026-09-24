package com.example.springBootProject.service;

import com.example.springBootProject.dtos.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private static List<StudentDTO> students= new ArrayList<>();
    private int id=1;

    public void add(StudentDTO studentDTO) {
        StudentDTO student = new StudentDTO();

        student.setId(id++);
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());

        students.add(student);

    }

    public List<StudentDTO> getAllStudent() {
        return students;
    }

    public StudentDTO getById(int id) {
        for (StudentDTO student : students) {
            if (student.getId()==id) {
                return student;
            }
        }

        return null;
    }


    // UPDATE
    public boolean update(Integer id, StudentDTO studentDTO) {

        for (StudentDTO student : students) {

            if (student.getId()==(id)) {

                student.setName(studentDTO.getName());
                student.setAge(studentDTO.getAge());

                return true;
            }
        }

        return false;
    }

    // DELETE
    public boolean delete(Integer id) {

        for (StudentDTO student : students) {

            if (student.getId()==(id)) {
                students.remove(student);
                return true;
            }
        }

        return false;
    }





}
