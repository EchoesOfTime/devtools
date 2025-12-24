package ru.mentee.power;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.assertThat;

class ProgressDemoTest {

  @Test
  void mainMethodShouldPrintExpectedOutput() {
    // Захватываем вывод в консоль
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    try {
      // Вызываем main метод
      ProgressDemo.main(new String[]{});

      // Проверяем вывод
      String output = outputStream.toString();
      assertThat(output).contains("Sprint 1 → Иван: planned 7 h");
      assertThat(output).contains("Status: sprint ready");
      assertThat(output).contains("Текущая ветка: feature/DVT-4");
    } finally {
      System.setOut(originalOut);
    }
  }
}