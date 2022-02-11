package plane;

public class Player extends Person{

    private int experience;
    private String nationality;
    private SkillMove skillMove;

    public int getExperience() {
        return experience;
    }

    public String getNationality() {
        return nationality;
    }

    public SkillMove getSkillMove() {
        return skillMove;
    }

    public Player(String firstName, String lastName, Integer age,
                  double salary, int experience, String nationality, SkillMove skillMove) {
        super(firstName, lastName, age, salary);
        this.experience = experience;
        this.nationality = nationality;
        this.skillMove = skillMove;
    }

    public void doSkillMove() {
        System.out.println("I am doing my skill move " + skillMove);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", experience=" + experience +
                ", nationality='" + nationality + '\'' +
                ", skillMove=" + skillMove +
                '}';
    }
}
