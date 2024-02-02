package com.nhnacademy.studentmanagement;

import com.nhnacademy.studentmanagement.repository.StudentRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update.do")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("id");
        Student student = studentRepository.getStudentById(studentId);
        req.setAttribute("student", student);

//        RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
//        rd.forward(req, resp);
        req.setAttribute("view", "/student/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");

        if(Objects.isNull(id)) {
            resp.sendError(400, "id is needed");
        }
        if(Objects.isNull(name)) {
            resp.sendError(400, "student name is needed");
        }
        if(Objects.isNull(gender)) {
            resp.sendError(400, "student gender is needed");
        }
        if(Objects.isNull(req.getParameter("studentAge"))) {
            resp.sendError(400, "student age is needed");
        }
        int student_age = 0;
        try {
            student_age = Integer.parseInt(age);
        }catch (Exception e) {
            resp.sendError(400, "student age must be integer");
        }

        Student student = new Student(id, name, Gender.valueOf(gender), student_age);
        studentRepository.update(student);

        //todo /student/view?id=student1 <-- redirect
        //resp.sendRedirect("/student/view.do?id="+id);
        req.setAttribute("view", "redirect:/student/view.do?id="+id);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }
}
