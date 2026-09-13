package Day3;

abstract class Animal{
    abstract void eat();

    Animal(){
        System.out.println("Animal class constructor invoked");
    }

    void sleep(){
        System.out.println("Animal class sleep method invoked");
    }
}

class Horse extends Animal{
    public void eat(){
        System.out.println("Abstract class Animal method eat() implemented");
    }

    public void run(){
        System.out.println("Horse is running");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Animal animal = new Horse();
        animal.eat();
        animal.sleep();
    }
}
