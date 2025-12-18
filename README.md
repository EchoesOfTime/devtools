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

## Сценарий ручной проверки DVT-6

### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

### Отладка через Debug
1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

### Что делать при ошибках
- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)