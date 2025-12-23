package ru.mentee.power;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MenteeProgressTest {

  @Test
  void shouldFormatCorrectlyWhenProgressCreated() {
    MenteeProgress progress = new MenteeProgress("Иван", 1, 7);

    String result = progress.summary();

    assertThat(result).isEqualTo("Sprint 1 → Иван: planned 7 h");
  }

  @Test
  void readyForSprintShouldReturnTrueWhenFourHours() {
    MenteeProgress progress = new MenteeProgress("Иван", 1, 4);

    assertThat(progress.readyForSprint()).isTrue();
  }

  @Test
  void shouldReturnFalseWhenOneHour() {
    MenteeProgress progress = new MenteeProgress("Иван", 1, 1);

    assertThat(progress.readyForSprint()).isFalse();
  }

  @Test
  void readyForSprintShouldReturnTrueWhenExactlyThreeHours() {
    MenteeProgress progress = new MenteeProgress("Иван", 1, 3);
    assertThat(progress.readyForSprint()).isTrue();
  }
}