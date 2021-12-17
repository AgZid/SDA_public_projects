package players;

import java.util.List;

public class Team {
    private List<Player> playerList;
    private Coach coach;
    private String name;
    private Countries country;

    public Team(List<Player> playerList, Coach coach, String name, Countries country) {
        this.playerList = playerList;
        this.coach = coach;
        this.name = name;
        this.country = country;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Team{" +
                "playerList=" + playerList +
                ", coach=" + coach +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
