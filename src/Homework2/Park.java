package Homework2;

public class Park {

    private String parkName;
    private String city;

    public static class Attraction {
        private String attractionName;
        private String workingHours;
        private double ticketPrice;

        public Attraction(String attractionName, String workingHours, double ticketPrice) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.ticketPrice = ticketPrice;
        }

        public void printAttractionInfo() {
            System.out.println("  Аттракцион:  " + attractionName);
            System.out.println("  Время работы: " + workingHours);
            System.out.println("  Цена билета:  " + ticketPrice + " руб.");
            System.out.println("  ---------------");
        }
    }

    public Park(String parkName, String city) {
        this.parkName = parkName;
        this.city = city;
    }

    public void printParkInfo() {
        System.out.println("=== Парк: " + parkName + " (г. " + city + ") ===");
    }
}