import java.util.function.*;
import java.util.*;
class Employee
{
    private String firstName;
    private String lastName;
    private double salary;

    public Employee (String firstName, String lastName, double salary)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public double getSalary()
    {
        return this.salary;
    }

    @Override
    public String toString()
    {
        return this.firstName + " " + this.lastName + ", " + this.salary;
    }
}

public class Mapping {

    public static void main(String[] args){

        ArrayList<Employee> employees = new ArrayList<>(List.of(
                new Employee("Nuray", "Namazova", 10000),
                new Employee("Konul", "Abbasova", 9000),
                new Employee("Goychak", "Badalova", 8000),
                new Employee("Gunel", "Alishova", 5000)
        ));


        Function<Employee,String> formatCard = (e) -> ( "Name: " + e.getFirstName() + " " +
                e.getLastName() + " - Salary: $" + e.getSalary());

        Function<Employee, Double> salaryPicker = Employee::getSalary;

        for (Employee e : employees) {
            System.out.println(formatCard.apply(e));
            System.out.println("Salary: $" + salaryPicker.apply(e));

        }

    }


}
