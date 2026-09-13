package Day2;

//class Bus {
//    String color;
//    String brand;
//
//    public void isVehicle(){
//        System.out.println("This is a type of vehicle");
//    }
//
//    public void printColor(){
//        System.out.println("Color is " + this.color);
//    }
//
//    public void printBrand(){
//        System.out.println("Brand is " + this.brand);
//    }
//    Bus(){
//        System.out.println("This is no args constructor");
//    }
//
//    Bus(String color, String brand){
//        System.out.println("Parameterized constructor has been called..");
//        this.color = color;
//        this.brand = brand;
//    }
//}

class Bike {
    String color;
    String brand;

    public void isVehicle(){
        System.out.println("This is a type of vehicle, the bikee");
    }

    public void printColor(){
        System.out.println("Color is " + this.color);
    }

    public void printBrand(){
        System.out.println("Brand is " + this.brand);
    }

    Bike(String color, String brand){
        this.color = color;
        this.brand = brand;
    }

    Bike(Bike b){
        System.out.println("Copy constructor has been called..");
        this.color = b.color;
        this.brand = b.brand;
    }
}

public class Vehicle {
    public static void main(String[] args){

//        Bus b1 = new Bus();
//        Bus b2 = new Bus("Yellow","BYD");
//
////        b1.color = "Yellow";
////        b1.type = "School Type";
////        b1.brand = "Normal";
//
//        b2.isVehicle();
//        b2.printColor();
//        b2.printBrand();

        Bike bike1 = new Bike("Red","Bullet");

        Bike bike2 = new Bike(bike1);
        bike2.printColor();
        bike2.printBrand();

    }
}
