public class Homework {

    public static void main(String[] args){
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isSumInRange(5, 8));
        printPos(9);
        System.out.println(isNegative(7));
        printString("Привет", 5);
        System.out.println(isLeapYear(2026));

        // ==================== ЗАДАНИЕ 10 ====================
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == 0) {
                binaryArray[i] = 1;
            } else {
                binaryArray[i] = 0;
            }
        }
        for (int num : binaryArray) System.out.print(num + " ");
        System.out.println();

        // ==================== ЗАДАНИЕ 11 ====================
        int[] hundredArray = new int[100];
        for (int i = 0; i < hundredArray.length; i++) {
            hundredArray[i] = i + 1;
        }
        for (int num : hundredArray) System.out.print(num + " ");
        System.out.println();

        // ==================== ЗАДАНИЕ 12 ====================
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6) {
                numbers[i] = numbers[i] * 2;
            }
        }
        for (int num : numbers) System.out.print(num + " ");
        System.out.println();

        // ==================== ЗАДАНИЕ 13 ====================
        int size = 4;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        for (int[] row : matrix) {
            for (int cell : row) System.out.print(cell + " ");
            System.out.println();
        }
        int[] myArray = createArray(5, 7);
        for (int num : myArray) System.out.print(num + " ");
        System.out.println();
    }


    // ==================== ЗАДАНИЕ 1 ====================
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // ==================== ЗАДАНИЕ 2 ====================
    public static void checkSumSign() {
        int a = 10;
        int b = -3;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // ==================== ЗАДАНИЕ 3 ====================
    public static void printColor() {
        int value = 50;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    // ==================== ЗАДАНИЕ 4 ====================
    public static void compareNumbers() {
        int a = 37;
        int b = 99;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }

    // ==================== ЗАДАНИЕ 5 ====================
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // ==================== ЗАДАНИЕ 6 ====================
    public static void printPos(int number) {
        if (number >= 0) {
            System.out.println(number + " - положительное");
        } else {
            System.out.println(number + " - отрицательное");
        }
    }
    // ==================== ЗАДАНИЕ 7 ====================
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // ==================== ЗАДАНИЕ 8 ====================
    public static void printString(String text, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(text);
        }
    }
    // ==================== ЗАДАНИЕ 9 ====================
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
    // ==================== ЗАДАНИЕ 14 ====================
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}