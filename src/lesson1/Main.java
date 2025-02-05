package lesson1;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Ленивая инициализация.
    private static Random getRandom() {
        return RandomHolder.INSTANCE;
    }

    // Создать объект Random и привязать к INSTANCE.
    private static class RandomHolder {
        private static final Random INSTANCE = new Random();
    }

    // Вывод разделителя.
    public static void drawLine() {
        System.out.println("------------------------------------------------");
    }

    // Проверка, является ли число четным.
    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }

    // Генерация случайного числа.
    public static int generateRandomNumber() {
        return getRandom().nextInt(10); // Случайное число от 0 до 9
    }

    // Расчет среднего арифметического.
    public static double calculateAverageArray(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }

    // Генерация случайного массива.
    public static int[] generateRandomArray() {
        int[] randomArray = new int[10];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = getRandom().nextInt(100); // Случайное число от 0 до 99
        }
        Arrays.sort(randomArray);
        return randomArray;
    }

    // Вывод минимального и максимального элементов массива.
    public static void printMinAndMaxElementArray(int[] numbers) {
        int min = Arrays.stream(numbers).min().orElse(0);
        int max = Arrays.stream(numbers).max().orElse(0);
        System.out.println("Минимальное значение массива: " + min);
        System.out.println("Максимальное значение массива: " + max);
    }

    // Вывод таблицы умножения.
    public static void printMultiplicationTable() {
        System.out.println("Таблица умножения:");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    // Метод для выполнения основных операций
    public static void calculate() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите первое число:");
            double firstNumber = scanner.nextDouble();

            System.out.println("Введите второе число:");
            double secondNumber = scanner.nextDouble();

            System.out.println("Введите оператор (+, -, *, /):");
            String operator = scanner.next();
            
            double result;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    System.out.println("Результат: " + firstNumber + " + " + secondNumber + " = " + result);
                    break;

                case "-":
                    result = firstNumber - secondNumber;
                    System.out.println("Результат: " + firstNumber + " - " + secondNumber + " = " + result);
                    break;

                case "*":
                    result = firstNumber * secondNumber;
                    System.out.println("Результат: " + firstNumber + " * " + secondNumber + " = " + result);
                    break;

                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                        System.out.println("Результат: " + firstNumber + " / " + secondNumber + " = " + result);
                    } else {
                        System.out.println("Ошибка! Деление на ноль невозможно.");
                    }
                    break;

                default:
                    System.out.println("Ошибка! Некорректный оператор.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка! Введите корректные числа.");
        }
    }

    public static void main(String[] args) {

        // Задание 1: Проверка четности случайного числа
        drawLine();
        int randomNumber = generateRandomNumber();
        System.out.println(MessageFormat.format(
                "Число {0} {1}",
                randomNumber,
                isNumberEven(randomNumber) ? "чётное" : "нечётное"));

        // Задание 2: Работа со случайным массивом
        drawLine();
        int[] randomArray = generateRandomArray();
        System.out.println(MessageFormat.format(
                "Среднее арифметическое массива {0}: {1}",
                Arrays.toString(randomArray),
                calculateAverageArray(randomArray)));

        // Задание 3: Минимальный и максимальный элементы массива
        drawLine();
        printMinAndMaxElementArray(randomArray);

        // Задание 4: Таблица умножения
        drawLine();
        printMultiplicationTable();

        // Завершение
        drawLine();

        calculate();
    }
}