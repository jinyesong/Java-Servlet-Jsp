package com.nhnacademy.studentmanagement;

import com.nhnacademy.studentmanagement.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view.do")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        StudentRepository studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo id null check
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");

        if(id == null){
            resp.sendError(400);
        }
        //Student student = new Student(id, name, Gender.valueOf(gender), Integer.parseInt(age));
        Student student = new Student();
        student.setId(id);

        //todo student 조회
        req.setAttribute("student",student);

        //todo /student/view.jsp <-- forward
        RequestDispatcher rd = req.getRequestDispatcher("/student/view.jsp");
        rd.forward(req, resp);
    }
}
