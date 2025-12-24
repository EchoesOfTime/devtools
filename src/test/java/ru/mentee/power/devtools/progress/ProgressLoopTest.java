package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {

  @Test
  @DisplayName("Должен корректно вычислить суммарный прогресс когда передан массив mentee")
  void shouldCalculateTotalProgressWhenMultipleMentees() {
    // given
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    // when
    String result = tracker.calculateTotalProgress(mentees);

    // then
    assertThat(result)
        .contains("пройдено 25 из 36 уроков")
        .contains("осталось 11 уроков");
  }

  @Test
  @DisplayName("Должен корректно обработать массив когда все mentee завершили курс")
  void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
    // given
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 12, 12),
        new Mentee("Мария", "СПб", "Fullstack", 12, 12)
    };

    // when
    String result = tracker.calculateTotalProgress(mentees);

    // then
    assertThat(result)
        .contains("пройдено 24 из 24 уроков")
        .contains("осталось 0 уроков");
  }

  @Test
  @DisplayName("Должен вернуть сообщение о нулевом прогрессе при null массиве")
  void shouldHandleNullMenteesArray() {
    // given
    ProgressTracker tracker = new ProgressTracker();

    // when
    String result = tracker.calculateTotalProgress(null);

    // then
    assertThat(result).isEqualTo("Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков");
  }

  @Test
  @DisplayName("Должен вернуть сообщение о нулевом прогрессе при пустом массиве")
  void shouldHandleEmptyMenteesArray() {
    // given
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = new Mentee[0];

    // when
    String result = tracker.calculateTotalProgress(mentees);

    // then
    assertThat(result).isEqualTo("Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков");
  }

  @Test
  @DisplayName("Должен корректно обработать одного mentee")
  void shouldCalculateForSingleMentee() {
    // given
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 3, 10)
    };

    // when
    String result = tracker.calculateTotalProgress(mentees);

    // then
    assertThat(result).isEqualTo("Суммарно: пройдено 3 из 10 уроков, осталось 7 уроков");
  }

  @Test
  @DisplayName("Должен обработать mentee с 0 пройденных уроков")
  void shouldHandleMenteeWithZeroProgress() {
    // given
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 0, 10),
        new Mentee("Мария", "СПб", "Fullstack", 0, 8)
    };

    // when
    String result = tracker.calculateTotalProgress(mentees);

    // then
    assertThat(result).isEqualTo("Суммарно: пройдено 0 из 18 уроков, осталось 18 уроков");
  }

  @Test
  @DisplayName("Main метод должен запускаться без ошибок")
  void mainMethodShouldRunWithoutErrors() throws Exception {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    try {
      ProgressTracker.main(new String[]{});
      String output = outputStream.toString();
      assertThat(output).contains("пройдено 25 из 36 уроков");
      assertThat(output).contains("осталось 11 уроков");
    } finally {
      System.setOut(originalOut);
    }
  }
}