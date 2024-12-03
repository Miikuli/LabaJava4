import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Сравнимый студент
        Student student_1 = new Student("Вася", 2, 3, 4);
        Student student_2 = new Student("Петя",  3);
        Student student_3 = new Student("Максим", 5, 4, 5, 5);
        System.out.println("Студенты: ");
        System.out.println(student_2);
        System.out.println(student_1);
        System.out.println(printCompare(student_2.compare(student_1)));
        System.out.println("Студенты: ");
        System.out.println(student_2);
        System.out.println(student_3);
        System.out.println(printCompare(student_2.compare(student_3)));
        System.out.println("Студенты: ");
        System.out.println(student_3);
        System.out.println(student_2);
        System.out.println(printCompare(student_3.compare(student_2)));
        System.out.println();

        //Начало отсчета
        Box<Point> pointBox = new Box<>(null);
        BoxMasks.addPointToBox(pointBox, 1, 2, 3);
        Point pointFromBox = pointBox.getBox();
        System.out.println("Точка из коробки: " + pointFromBox);
        System.out.println("В коробке есть что-то: " + pointBox.isFull());

        Box<Point2> point2Box = new Box<>(null);
        BoxMasks.addPointToBox(point2Box, -4, 5.5, 60);
        Point2 point2FromBox = point2Box.getBox();
        System.out.println("Точка из коробки: " + point2FromBox);
        System.out.println("В коробке есть что-то: " + point2Box.isFull());
        System.out.println();

        //Функция
        List<String> list_1 = List.of("qwerty", "asdfg", "zx");
        System.out.println("Исходные строки: " + list_1);
        List<Integer> res_1 = FunctionApply.apply(list_1, String::length);
        System.out.println("Длины строк: " + res_1);

        List<Integer> list_2 = List.of(1, -3, 7);
        System.out.println("Исходные числа: " + list_2);
        List<Integer> res_2 = FunctionApply.apply(list_2, Math::abs);
        System.out.println("Модули: " + res_2);

        List<int[]> list_3 = List.of(new int[]{0, 1, 2}, new int[]{-1, -5}, new int[]{4, -9, 1000, -10});
        System.out.println("Исходные массивы: ");
        for (int[] array : list_3) {
            System.out.print("[ ");
            for (int i : array) System.out.print(i + " ");
            System.out.print("] \n");
        }
        List<Integer> res_3 = FunctionApply.apply(list_3, arr -> {
            int max = arr[0];
            for (int i : arr) if (i > max) max = i;
            return max;
        });
        System.out.println("Максимальные значения: " + res_3);
        System.out.println();

        //Фильтр
        System.out.println("Исходные строки: " + list_1);
        List<String> res_4 = FilterTest.test(list_1, str -> str.length() < 3);
        System.out.println("Cтроки c длиной меньше 3: " + res_4);

        System.out.println("Исходные числа: " + list_2);
        List<Integer> res_5 = FilterTest.test(list_2, x -> x > 0);
        System.out.println("Положительные числа: " + res_5);

        List<int[]> res_6 = FilterTest.test(list_3, array -> {
            for (int i : array) if (i > 0) return false;
            return true;
        });

        System.out.println("Исходные массивы: ");
        for (int[] array : list_3) {
            System.out.print("[ ");
            for (int i : array) System.out.print(i + " ");
            System.out.print("] \n");
        }
        System.out.print("Массивы с только отрицательными элементами: ");
        for (int[] array : res_6) {
            System.out.print("[ ");
            for (int i : array) System.out.print(i + " ");
            System.out.print("] ");
        }
        System.out.println();

        //Сокращение
        System.out.println("Исходные строки: " + list_1);
        String res_7 = Reduction.reduce(list_1, "", String::concat);
        System.out.println("Объединенная строка: " + res_7);

        System.out.println("Исходные числа: " + list_2);
        Integer res_8 = Reduction.reduce(list_2, 0, Integer::sum);
        System.out.println("Сумма: " + res_8);

        List<List<Integer>> list_4 = List.of(List.of(0, 1, 2), List.of(-1, -5), List.of(4, -9, 1000));

        List<Integer> sizes = FunctionApply.apply(list_4, List::size);

        Integer res_9 = Reduction.reduce(sizes, 0, Integer::sum);
        System.out.println("Общее количество элементов: " + res_9);
        System.out.println();

        //Коллекционирование
        System.out.println("Исходные числа" + list_2);
        List<Integer> positiveNumbers = Collecting.collect(list_2, ArrayList::new, num -> num > 0);
        List<Integer> negativeNumbers = Collecting.collect(list_2, ArrayList::new, num -> num < 0);
        System.out.println("Положительные числа: " + positiveNumbers);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        List<String> list_5 = List.of("qwerty", "asdfg", "zx", "qw");
        System.out.println("Исходные строки: " + list_5);
        Map<Integer, List<String>> res_10 = list_5.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Подсписки строк с одинаковой длиной: " + res_10);
        List<String> list_6 = List.of("qwerty", "asdfg", "qwerty", "qw");
        System.out.println("Исходные строки: " + list_6);
        Collection<String> res_11 = Collecting.collect(list_6, HashSet::new, str -> true);
        System.out.println("Подсписки с уникальными объектами: " + res_11);
    }


    public static String printCompare(int result) {
        String stringRes = "Средний балл первого студента ";
        if (result == -1) stringRes += "ниже балла";
        else if (result == 0) stringRes += "равен баллу";
        else stringRes += "выше балла";
        stringRes += " второго студента.";
        return stringRes;
    }
}