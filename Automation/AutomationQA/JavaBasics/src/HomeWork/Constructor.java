package HomeWork;

import java.util.Scanner;

class Teacher{
    String name;
    int salary;

    Teacher(String name,int salary){
        System.out.println("Parameterized constructor has been invoked");
        this.name=name;
        this.salary=salary;
    }

    Teacher(Teacher t){
        System.out.println("Copy constructor has been invoked");
        this.name=t.name;
        this.salary=t.salary;
    }

    void printInfo(){
        System.out.println("Name of the teacher: "+name);
        System.out.println("Salary: Rs "+salary);
    }
}

public class Constructor {

     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         boolean running = true;
         String name;
         int salary;

         while (running) {
             System.out.println("Enter teacher's name: ");
             name = scanner.nextLine();

             System.out.println("Enter teacher's salary: ");
             salary = scanner.nextInt();

             Teacher t1 = new Teacher(name, salary);
             t1.printInfo();

             scanner.nextLine();

             while (!name.equals("y") && !name.equals("n")) {

                 System.out.println("Do you want to continue?(y/n) ");
                 name = scanner.nextLine();

                 if  (name.equals("y")) {
                     continue;
                 }
                 else if (name.equals("n")) {
                     running = false;
                 }
                 else  {
                     System.out.println("Invalid input");
                 }
             }
         }

         System.out.println("Thank you for using our service.....");

     }
}
