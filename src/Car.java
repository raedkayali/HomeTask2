import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.Year;

public class Car {
    int id;
    String make;
    String model;
    int year;
    String color;
    int price;
    String registrationNumber;

    public Car(int id, String make, String model, int year, String color, int price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public static ArrayList<Car> getCarsByBrand(ArrayList<Car> cars, String brand) {
        ArrayList<Car> carsByBrand = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.make.equals(brand)) {
                carsByBrand.add(car);
            }
        }

        return carsByBrand;
    }
    public static ArrayList<Car> getCarsByModelAndYears(ArrayList<Car> cars, String model, int years) {
        ArrayList<Car> carsByModelAndYears = new ArrayList<Car>();
        Year currentYear = Year.now();
        int year = currentYear.getValue();
        for (Car car : cars) {
            if (car.model.equals(model) && (year - car.year) > years) {
                carsByModelAndYears.add(car);
            }
        }

        return carsByModelAndYears;
    }
    public static ArrayList<Car> getCarsByYearAndPrice(ArrayList<Car> cars, int year, int price) {
        ArrayList<Car> carsByYearAndPrice = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.year == year && car.price > price) {
                carsByYearAndPrice.add(car);
            }
        }

        return carsByYearAndPrice;
    }

    public String toString() {
        return this.id + " " + this.make + " " + this.model + " " + this.year + " " + this.color + " " + this.price + " " + this.registrationNumber;
    }
    public static void saveCarsToFile(ArrayList<Car> cars, String fileName) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Car car : cars) {
                writer.write(car.toString());
                writer.newLine(); 
            }
            writer.close();
            System.out.println("Array has been saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Car car1 = new Car(1, "BMW", "X5", 2015, "Black", 20000, "AA1234BB");
        Car car2 = new Car(2, "BMW", "X6", 2016, "White", 30000, "AA1235BB");
        Car car3 = new Car(3, "BMW", "X7", 2017, "Red", 40000, "AA1236BB");
        Car car4 = new Car(4, "BMW", "X8", 2018, "Blue", 50000, "AA1237BB");
        Car car5 = new Car(5, "BMW", "X5", 2019, "Green", 60000, "AA1238BB");
        Car car6 = new Car(6, "BMW", "X10", 2020, "Yellow", 70000, "AA1239BB");
        Car car7 = new Car(7,"Audi", "A5", 2015, "Black", 30000, "AA1234BB");
        Car car8 = new Car(8,"Audi", "A6", 2016, "White", 30000, "AA1235BB");
        Car car9 = new Car(9,"Audi", "A7", 2017, "Red", 40000, "AA1236BB");
        Car car10 = new Car(10,"Audi", "A8", 2018, "Blue", 50000, "AA1237BB");

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);
        cars.add(car10);

        ArrayList<Car> carsByBrand = Car.getCarsByBrand(cars, "Audi");

        saveCarsToFile(carsByBrand, "carsByBrand.txt");

        ArrayList<Car> carsByModelAndYears = Car.getCarsByModelAndYears(cars, "X5", 5);

        saveCarsToFile(carsByModelAndYears, "carsByModelAndYears.txt");
        
        ArrayList<Car> carsByYearAndPrice = Car.getCarsByYearAndPrice(cars, 2015, 20000);

        saveCarsToFile(carsByYearAndPrice, "carsByYearAndPrice.txt");

    }
}
