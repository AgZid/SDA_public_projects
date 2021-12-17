package players;

public class Coach {
    private String name;
    private Countries countries;

    public Coach(String name, Countries countries) {
        this.name = name;
        this.countries = countries;
    }

    public void shouting() {
        System.out.println("Shouting...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Countries getNationality() {
        return countries;
    }

    public void setNationality(Countries countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", countries=" + countries +
                '}';
    }
}
