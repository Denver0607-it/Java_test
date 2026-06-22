public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+7-900-111-22-33");
        phoneBook.add("Петров", "+7-900-444-55-66");
        phoneBook.add("Иванов", "+7-900-777-88-99");
        phoneBook.add("Сидоров", "+7-900-000-11-22");

        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Козлов");
    }
}