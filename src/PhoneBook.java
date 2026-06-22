import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phone) {
        book.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
    }

    public void get(String surname) {
        if (!book.containsKey(surname)) {
            System.out.println("Фамилия \"" + surname + "\" не найдена.");
            return;
        }
        List<String> phones = book.get(surname);
        System.out.println("Телефоны для \"" + surname + "\": " + phones);
    }
}


