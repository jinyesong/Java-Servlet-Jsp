package com.nhnacademy.studentmanagement.listener;

import com.nhnacademy.studentmanagement.Gender;
import com.nhnacademy.studentmanagement.repository.MapStudentRepository;
import com.nhnacademy.studentmanagement.Student;
import com.nhnacademy.studentmanagement.repository.StudentRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class WebApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();

        for(int i=1; i<=10; i++){
            Student student = new Student();
            student.setId("student"+i);
            student.setName("아카데미"+i);
            student.setGender(Gender.F);
            student.setAge((int)(Math.random()*9)+20);
            student.setCreatedAt(LocalDateTime.now());
            studentRepository.save(student);
        }
        context.setAttribute("studentRepository", studentRepository);
    }
}
