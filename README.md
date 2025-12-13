Quick Start: как запустить задачи run, build, test через Gradle Tool Window – (Tasks → application → run), (Tasks → build → build), (Tasks → verification → test) и Run Anything (Ctrl + Ctrl) – ввести (gradle run) или (gradle test).
Packages: короткое объяснение, зачем нужен пакет ru.mentee.power - предотвратить хаос и дать структуру, чтобы не было конфликта при импорте.
Таблица переменных/полей: menteeName – имя студента, sprintNumber – номер спринта, plannedHoursPerWeek - запланированные часы, правило readyForSprint() - метод без аргументов, который возвращает логическое значение (true или false).
public record MenteeProgress(String menteeName, int sprintNumber, int plannedHoursPerWeek)- это класс record где хранятся данные: имя стажера, номер сринта, запланированные часы.
MenteeProgress - String menteeName, int sprintNumber, int plannedHoursPerWeek
https://mentee-power.xl.ru/learn/eZTCGC3TuEW8P6jDvNRFZw/theory

## Правило веток (Branching Strategy)

В проекте используется стратегия ветвления, основанная на ветках `feature`.
*   `master` — основная ветка для стабильного кода.
*   `feature/DVT-X` — ветка для разработки задачи с идентификатором DVT-3.


## Git локальный цикл: шаги и команды

1.  Внести изменения в код.
2.  `git add <файлы>` — добавить изменения в индекс.
3.  `git commit -m "сообщение"` — зафиксировать изменения.
4.  `git push` — отправить в удалённый репозиторий.