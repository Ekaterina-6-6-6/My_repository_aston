package org.example;

public class Park {

    class Attraction {
        private String name;
        private String workingTime;
        private double price;

        public Attraction(String name, String workingTime, double price) {
            this.name = name;
            this.workingTime = workingTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingTime);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println();
        }
    }

    public void printInfo() {
        Park park = this;

        Attraction ferrisWheel =
                park.new Attraction(
                        "Колесо обозрения",
                        "10:00 - 22:00",
                        500);

        Attraction rollerCoaster =
                park.new Attraction(
                        "Американские горки",
                        "11:00 - 21:00",
                        800);

        Attraction panicRoom =
                park.new Attraction(
                        "Комната страха",
                        "12:00 - 23:00",
                        600);

        ferrisWheel.printInfo();
        rollerCoaster.printInfo();
        panicRoom.printInfo();
    }
}