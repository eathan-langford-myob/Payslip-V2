package User;

public class User {
    private String firstName;
    private String lastName;
    private int salary;
    private int superRate;

    public User(String firstName, String lastName, int salary, int superRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.superRate = superRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getSuperRate() {
        return superRate;
    }
}
