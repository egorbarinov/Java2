package ru.gb.jtwo.lc.hw;

/*Написать простой класс PhoneBook(внутри использовать HashMap):
	  - В качестве ключа использовать фамилию
	  - В каждой записи всего два поля: phone, e-mail
	  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили
	  ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии. Следует учесть,
	  что под одной фамилией может быть несколько записей.
	  Итого должно получиться 3 класса Main, PhoneBook, Person.
 **/

import java.util.*;

public class PhoneBook { // et<Entry<String, ArrayList<Person>>>
    private HashMap<String, ArrayList<Person>> phoneBook;


    PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public Set<Map.Entry<String, ArrayList<Person>>> entrySet() {

        for (int i = 0; i < phoneBook.size(); i++)
            return phoneBook.entrySet();
        return null;
    }

    public ArrayList<Person> add (String name, Person person) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(person);
        return this.phoneBook.put(name, list);
    }

    public String get (String name) {
        String temp = null;
        for (HashMap.Entry<String, ArrayList<Person>> hashMap : phoneBook.entrySet()) {
            if (hashMap.getKey().equals(name)) {
                temp = hashMap.getValue().toString();
            }
        }
        return name + " - " + temp;
    }
}
