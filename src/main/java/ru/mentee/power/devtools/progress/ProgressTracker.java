package ru.mentee.power.devtools.progress;

public class ProgressTracker {
  public String calculateTotalProgress(Mentee[] mentees) {
    if (mentees == null || mentees.length == 0) {
      return "Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков";
    }

    int totalCompleted = 0;
    int totalTotal = 0;
    int index = 0;

    while (index < mentees.length) {
      totalCompleted += mentees[index].completedLessons();
      totalTotal += mentees[index].totalLessons();
      index++;
    }

    int remaining = totalTotal - totalCompleted;

    return "Суммарно: пройдено " + totalCompleted + " из "
        + totalTotal + " уроков, осталось " + remaining + " уроков";
  }

  public static void main(String[] args) {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };
    String progress = tracker.calculateTotalProgress(mentees);
    System.out.println(progress);
  }
}