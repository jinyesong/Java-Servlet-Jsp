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
import java.util.Objects;

@Slf4j
@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view.do")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
        log.debug("init good");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo id null check
        String id = req.getParameter("id");
        log.debug("id getparameter good: " + id);

        if(Objects.isNull(id)) {
            resp.sendError(400, "id is null");
            log.debug("id가 없음");
        }

        //todo student 조회
        Student student = studentRepository.getStudentById(id);
        log.debug("get student: "+ student);
        req.setAttribute("student", student);

        //todo /student/view.jsp <-- forward
        RequestDispatcher rd = req.getRequestDispatcher("/student/view.jsp");
        rd.forward(req, resp);
    }
}
