package ru.mentee.power.devtools.progress;

public class ProgressTracker {
    public String calculateTotalProgress(Mentee[] mentees) {
        if (mentees == null || mentees.length == 0) // 1 массив mentees пустой (null) или в нём нет элементов (length == 0)
        {
            return "Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков";
        }

        // 2. Инициализировать аккумуляторы: totalCompleted = 0, totalTotal = 0, index = 0
        int totalCompleted = 0; // количество пройденных уроков
        int totalTotal = 0;  // количество всех уроков
        int index = 0;  // номер текущего ученика в массиве 1-3

        // 4. На каждой итерации: totalCompleted += mentees[index].completedLessons(), totalTotal += mentees[index].totalLessons(), index++
        while (index < mentees.length) {   // 3. Использовать цикл while (index < mentees.length) для перебора массива
            totalCompleted += mentees[index].completedLessons();
            totalTotal += mentees[index].totalLessons();
            index++;
        }

        // 5. Вычислить оставшиеся: totalRemaining = totalTotal - totalCompleted (remaining)
        int remaining = totalTotal - totalCompleted;

        // 6. Вернуть строку формата: "Суммарно: пройдено X из Y уроков, осталось Z уроков"
        return "Суммарно: пройдено " + totalCompleted+ " из " + totalTotal + " уроков, осталось " + remaining + " уроков";

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