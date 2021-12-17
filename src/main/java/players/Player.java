package players;

public class Player {
    private String name;
    private int salary;
    private Experience experience;

    public Player(String name, int salary, Experience experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

    public void doSkillMove() {
        System.out.println("Shoots  points");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
