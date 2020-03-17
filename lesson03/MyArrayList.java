package ru.gb.jtwo.lc.hw;

import java.util.*;

public class MyArrayList {

    //1.1 Найти список слов, из которых состоит текст (дубликаты не считать);
    private static HashSet<String> wordList(String[] arr){
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(arr));
        return hashSet;
    }

    //1.2 Посчитать сколько раз встречается каждое слово (использовать HashMap);
    private static HashMap<String, Integer> hashMap(String[] arr) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : arr){
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1); //присвоим значения в зависимости от кол-ва повторяющихся слов
        }
//        System.out.println(hashMap.get("мне")); // посмотрим значение в массиве ключа "мне", результат: 2
//        System.out.println(hashMap.entrySet()); // посмотрим содержимое hashMap( key, value)
//        System.out.println(hashMap.containsKey("порой")); // проверяет наличие объекта, выводит true или false
//        System.out.println(hashMap.size()); // размер hashMap
        return hashMap;
    }

    public static void main(String[] args) {
        // 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
        List<String> list = new ArrayList<>(Arrays.asList(
                "Весьма", "порой", "мешает", "мне", "заснуть",
                "волнующая", ",", "как", "ни", "поверни",
                ",", "открывшаяся", "мне", "внезапно", "суть",
                "какой-нибудь", "немыслимой", "фигни", "..."));  // создал ArrayList с текстом
        String[] arr = new String[list.size()];
        list.toArray(arr);
        System.out.println(Arrays.toString(arr)); // потренировался в преобразовании ArrayList в массив строк

        // 1.1 Найти список слов, из которых состоит текст (дубликаты не считать);
        System.out.println(wordList(arr));

        // 1.2 Посчитать сколько раз встречается каждое слово (использовать HashMap);
        System.out.println(hashMap(arr));

        // 2 Написать простой класс PhoneBook(внутри использовать HashMap):
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", new Person("84952223355", "ivanov@mail.ru"));
        phoneBook.add("Петров", new Person("84959995588", "petrov@mail.ru"));
        phoneBook.add("Сидоров", new Person("84999999999", "sidorov@mail.ru"));

        System.out.println(phoneBook.entrySet());
        System.out.println(phoneBook.get("Иванов"));
    }
}
