package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
  private List<Student> studentlist;  // нарушение: snake_case

  public StudentList() {  // должно быть public StudentList() {
    studentlist = new ArrayList<>();
  }

  // нарушение: имя метода
  public void addStudent(Student student) {  // должно быть addStudent
    if (student != null) { // нарушение: нет пробела после if
      studentlist.add(student);
    }
  }

  // нарушение: длинная строка имя метода (>120 символов)
  public List<Student> getStudentsByCity(String city) {
    return studentlist.stream()
        .filter(s -> s.city().equals(city))
        .toList();
  }
}