package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
  private List<Student> studentlist;

  public StudentList() {  // должно быть public StudentList() {
    studentlist = new ArrayList<>();
  }

  public void addStudent(Student student) {
    if (student != null) {
      studentlist.add(student);
    }
  }

  public List<Student> getStudentsByCity(String city) {
    return studentlist.stream()
        .filter(s -> s.city().equals(city))
        .toList();
  }
}