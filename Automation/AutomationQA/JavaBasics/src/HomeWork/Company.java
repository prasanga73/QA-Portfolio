package HomeWork;

class Employee {
    protected String name;
    protected int id;
    protected double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void work() {
        System.out.println(name + " is working");
    }

    void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: Rs " + salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Developer extends Employee {
    private String language;

    Developer(String name, int id, double salary, String language) {
        super(name, id, salary);
        this.language = language;
    }

    @Override
    void work() {
        System.out.println(name + " is coding in " + language);
    }

    @Override
    double calculateBonus() {
        return super.calculateBonus() + 500;
    }
}


public class Company {
    public static void main(String[] args) {
        Employee[] employees = {
                new Developer("Stephen Sanchez", 101, 75000, "Java"),
                new Employee("Taylor Swift", 102, 50000)
        };

        for (Employee emp : employees) {
            emp.work();
            System.out.println("Bonus: Rs " + emp.calculateBonus());
            emp.displayInfo();
            System.out.println();
        }
    }
}