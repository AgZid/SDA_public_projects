package plane;

public class Coach extends Person{
    private boolean isAngry;
    private String coachingStrategy;

    public Coach(String firstName, String lastName, Integer age, double salary, boolean isAngry, String coachingStrategy) {
        super(firstName, lastName, age, salary);
        this.isAngry = isAngry;
        this.coachingStrategy = coachingStrategy;
    }

    public void setFistName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public void coachPlayers() {
        System.out.println("Coaching palyers using strategy " + coachingStrategy);
    }

    public boolean isAngry() {
        return isAngry;
    }

    public void setAngry(boolean angry) {
        isAngry = angry;
    }

    public String getCoachingStrategy() {
        return coachingStrategy;
    }

    public void setCoachingStrategy(String coachingStrategy) {
        this.coachingStrategy = coachingStrategy;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "isAngry=" + isAngry +
                ", coachingStrategy='" + coachingStrategy + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
