package plane;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

    protected String firstName;
    protected  String lastName;
    protected Integer age;
    protected double salary;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void introduceYourself() {
        System.out.println("Hello, my name is " + firstName);
        System.out.println("My last name is " + lastName);
        System.out.println("My age is " + age);
        System.out.println("I earn " + salary);
    }
}
