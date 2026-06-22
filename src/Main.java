import java.util.*;

public class Main {

    public static void removeWeakStudents(Set<Student> students) {
        students.removeIf(s -> s.getAverageGrade() < 3);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println("  " + s.getName());
            }
        }
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Иван Иванов", "ИТ-11", 1, Arrays.asList(5, 4, 5, 4)));
        students.add(new Student("Мария Петрова", "ИТ-11", 1, Arrays.asList(2, 2, 2, 2)));
        students.add(new Student("Алексей Сидоров", "ИТ-12", 2, Arrays.asList(4, 3, 4, 5)));
        students.add(new Student("Ольга Козлова", "ИТ-12", 2, Arrays.asList(2, 3, 2, 2)));
        students.add(new Student("Дмитрий Новиков", "ИТ-13", 3, Arrays.asList(5, 5, 4, 5)));

        System.out.println();
        students.forEach(System.out::println);

        removeWeakStudents(students);
        System.out.println();
        students.forEach(System.out::println);

        promoteStudents(students);
        System.out.println();
        students.forEach(System.out::println);

        System.out.println();
        printStudents(students, 2);
        printStudents(students, 3);
        printStudents(students, 4);
    }
}