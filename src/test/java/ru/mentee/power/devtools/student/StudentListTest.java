package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentListTest {

  @Test
  void addStudentAddsStudentToList() {
    StudentList list = new StudentList();
    Student student = new Student("Иван", "Москва");

    list.addStudent(student);
    List<Student> result = list.getStudentsByCity("Москва");

    assertEquals(1, result.size());
    assertEquals(student, result.get(0));
  }

  @Test
  void addStudentDoesNotAddNull() {
    StudentList list = new StudentList();

    list.addStudent(null);
    List<Student> result = list.getStudentsByCity("Москва");

    assertTrue(result.isEmpty());
  }

  @Test
  void getStudentsByCityReturnsEmptyListForUnknownCity() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Иван", "Москва"));

    List<Student> result = list.getStudentsByCity("Санкт-Петербург");

    assertTrue(result.isEmpty());
  }

  @Test
  void getStudentsByCityReturnsMultipleStudents() {
    StudentList list = new StudentList();
    Student student1 = new Student("Иван", "Москва");
    Student student2 = new Student("Мария", "Москва");

    list.addStudent(student1);
    list.addStudent(student2);

    List<Student> result = list.getStudentsByCity("Москва");

    assertEquals(2, result.size());
    assertTrue(result.contains(student1));
    assertTrue(result.contains(student2));
  }

  @Test
  void constructorCreatesEmptyList() {
    StudentList list = new StudentList();
    List<Student> result = list.getStudentsByCity("ЛюбойГород");
    assertTrue(result.isEmpty());
  }

  @Test
  void getStudentsByCityWithEmptyList() {
    StudentList list = new StudentList();
    List<Student> result = list.getStudentsByCity("Москва");
    assertTrue(result.isEmpty());
  }

  @Test
  void getStudentsByCityWithStudentHavingNullCity() {
    StudentList list = new StudentList();
    Student student = new Student("Иван", null);
    list.addStudent(student);

    // Это вызовет NPE внутри фильтра!
    assertThrows(NullPointerException.class, () -> {
      list.getStudentsByCity("Москва");
    });
  }

  @Test
  void getStudentsByCityWithEmptyStringCity() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Иван", ""));
    list.addStudent(new Student("Петр", "Москва"));

    List<Student> result = list.getStudentsByCity("");
    assertEquals(1, result.size());
    assertEquals("Иван", result.get(0).name());
  }
}