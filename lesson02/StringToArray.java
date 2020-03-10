package ru.gb.jtwo.lb.hw;

public class StringToArray {

    public static int size;

    // 5. Написать собственные классы исключений для каждого из случаев
    private static class LengthOfStringExceptions extends RuntimeException  {
        LengthOfStringExceptions (String message) {
            super("exceeded the length of the string! " + message);
        }
    }

    private static class ColumnSizeExceptions extends RuntimeException  {
        ColumnSizeExceptions (String message) {
            super("column size exceeded! " + message);
        }
    }

    private static class NotNumberFormatExceptions extends RuntimeException  {
        NotNumberFormatExceptions(String message) {
            super("one of the values is not a number! "  + message);
        }
    }

    public static void main(String[] args) {

        // 1.
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] array;
        size = 4;
        array = stringToArray(s, size);
        System.out.println(array[3].length); //  результат = 4, это длина столбца строки массива [3]
        System.out.println(array[2][0]); // посмотрим, что лежит в строке массива [2] в [0] позиции, результат должен быить равен 5
        printToSquare(array); // выводим на экран строковые значения из двумерного массива String[][] array

         // 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.

        // s = "10 3 1 2\n2 d 2 2\n5 6 7 1\n300 3 1 0"; // one of the values is not a number! one of the values: d
        //s = "10 3 1 2 20 \n2 3 2 2\n5 6 7 1\n300 3 1 0"; // column size exceeded! column size: 5
        s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0\n4"; //exceeded the length of the string! length of string: 5
        array = stringToArray(s, size);
        printToSquare(array);

        // 2.
        System.out.println(StringToIntArrays(array)); // результат 174

    }

    private static void printToSquare(String[][] array) {  // метод для вывода в консоль двумерного массива
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
    // Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];

    private static String[][] stringToArray(String string, int n) {
        // переводим в массив по \n
        String[][] str = new String[n][n];
        String[] tempArr = string.split("\n");
        if (tempArr.length != n)
        {
            throw new LengthOfStringExceptions("length of string: " + tempArr.length);
        }
        // переводим каждую строку в массив по " "
        for (int i = 0; i < tempArr.length; i++) {
            str[i] = tempArr[i].split(" ");
            if (str[i].length != n) {
                throw new ColumnSizeExceptions("column size: " + str[i].length);
            }
        }
        return str;
    }

    // 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;

    private static int StringToIntArrays(String[][] str){
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                try {
                    sum += Integer.parseInt(str[i][j]);
                } catch (NumberFormatException e) {
                    throw new NotNumberFormatExceptions("one of the values: " + str[i][j]);
                }
            }
        }
        return sum / 2;
    }
}
