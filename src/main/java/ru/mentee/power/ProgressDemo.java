package ru.mentee.power;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProgressDemo {
  public static void main(String[] args) {
    MenteeProgress progress = new MenteeProgress(
        "Иван",
        1,
        7
    );
    System.out.println(progress.summary());
    if (progress.readyForSprint()) {
      System.out.println("Status: sprint ready");
    } else {
      System.out.println("Status: backlog first");
    }
    System.out.println("Текущая ветка: feature/DVT-4");
  }
}