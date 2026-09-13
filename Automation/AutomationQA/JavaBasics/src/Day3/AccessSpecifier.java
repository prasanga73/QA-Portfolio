package Day3;

class Teacher{
    private String name;
    private int salary;

    public Teacher(){
        System.out.println("Teacher Class Constructor invoked");
    }

    void setNameSalary(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    String getName(){
        return(this.name);
    }

    int getSalary(){
        return(this.salary);
    }
}

public class AccessSpecifier {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        teacher.setNameSalary("Ram",20000);

        System.out.println("Teacher's name: " + teacher.getName());
        System.out.println("Teacher's salary: " + teacher.getSalary());
    }
}
