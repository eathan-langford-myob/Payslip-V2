package User;

public class User {
    private String firstName;
    private String lastName;
    private int salary;
    private int superRate;
    private String startDate;
    private String endDate;

    public User(String firstName, String lastName, String salary, String superRate, String startDate, String endDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = Integer.parseInt(salary);
        this.superRate = Integer.parseInt(superRate);
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
