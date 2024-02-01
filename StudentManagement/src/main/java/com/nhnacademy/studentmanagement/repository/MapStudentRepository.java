package com.nhnacademy.studentmanagement.repository;

import com.nhnacademy.studentmanagement.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MapStudentRepository implements StudentRepository {
    private Map<String, Student> studentMap = new ConcurrentHashMap<>();

    @Override
    public void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        studentMap.replace(student.getId(), student);
    }

    @Override
    public void deleteById(String id) {
        studentMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        log.debug("comecome");
        return studentMap.get(id);
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>(studentMap.values());
        return students;
    }

    @Override
    public boolean existById(String id) {
        return studentMap.containsKey(id);
    }
}
