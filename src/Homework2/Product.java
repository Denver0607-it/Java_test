package Homework2;
public class Product {

    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean isBooked;

    public Product(String name, String productionDate, String manufacturer,
                   String country, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }

    public void printInfo() {
        System.out.println("=== Информация о товаре ===");
        System.out.println("Название:          " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель:     " + manufacturer);
        System.out.println("Страна:            " + country);
        System.out.println("Цена:              " + price + " USD");
        System.out.println("Забронирован:      " + (isBooked ? "Да" : "Нет"));
        System.out.println("==========================");
    }
}
