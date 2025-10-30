//Implements keyword is used when a class wants to implement an interface
/*Class: Employee implements Associate which means that the Employee class will define what work means from
the Associate interface*/

public class Employee implements Associate {
    //Attributes
    String name;


    //Constructor
    public Employee(String name) {
        this.name = name;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }

    //Work method from Associate interface - behavior of the method is defined
    public void work() {
        System.out.println("Employee works");
    }

}
