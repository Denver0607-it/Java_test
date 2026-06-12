package Homework2;

public class Main {

    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599.99, true);

        productsArray[1] = new Product("iPhone 16 Pro", "15.09.2024",
                "Apple Inc.", "USA", 4999.00, false);

        productsArray[2] = new Product("Sony WH-1000XM6", "10.03.2025",
                "Sony Group", "Japan", 349.99, true);

        productsArray[3] = new Product("MacBook Pro M4", "05.11.2024",
                "Apple Inc.", "USA", 7499.00, false);

        productsArray[4] = new Product("Xiaomi 15 Ultra", "20.01.2025",
                "Xiaomi Corp.", "China", 1299.99, true);

        for (Product product : productsArray) {
            product.printInfo();
        }
        // ======== ЗАДАНИЕ 3 ========
        Park park = new Park("ПКиО Гагарина", "Самара");
        park.printParkInfo();

        Park.Attraction a1 = new Park.Attraction("Колесо обозрения", "09:00-21:00", 250.0);
        Park.Attraction a2 = new Park.Attraction("Американские горки", "10:00-20:00", 400.0);
        Park.Attraction a3 = new Park.Attraction("Карусель", "09:00-22:00", 150.0);

        a1.printAttractionInfo();
        a2.printAttractionInfo();
        a3.printAttractionInfo();
    }

        }
