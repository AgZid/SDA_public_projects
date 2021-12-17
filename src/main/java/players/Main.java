package players;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Player playerJohn = new Player("John", 1500, Experience.NEWBIE);
        Player playerTim = new Player("Tim", 2000, Experience.NEWBIE);
        Player playerBob = new Player("Bob", 4000, Experience.INTERMEDIATE);
        Player playerSam = new Player("Sam", 5000, Experience.INTERMEDIATE);
        Player playerLebron = new Player("Lebron", 30000, Experience.PROFESSIONAL);
        Player playerCurry = new Player("Curry", 35000, Experience.PROFESSIONAL);

        Coach coachSteve = new Coach("Steve",Countries.US);
        Coach coachSarunas = new Coach("Sarunas",Countries.LITHUANIA);
        Coach coachEdvinas = new Coach("Edvinas",Countries.POLAND);

        List<Player> playerList1 = new ArrayList<>();
        playerList1.add(playerBob);
        playerList1.add(playerCurry);

        List<Player> playerList2 = new ArrayList<>();
        playerList2.add(playerTim);
        playerList2.add(playerSam);

        List<Player> playerList3 = new ArrayList<>();
        playerList3.add(playerJohn);
        playerList3.add(playerLebron);

        Team zalgiris = new Team(playerList1, coachEdvinas, "Zalgiris", Countries.LITHUANIA);
        System.out.println(zalgiris.toString());

        Team neptunas = new Team(playerList2, coachSteve, "Neptunas", Countries.POLAND);
        System.out.println(neptunas.toString());

        Team lietkabelis = new Team(playerList3, coachSarunas, "Lietkabelis", Countries.SPAIN);
        System.out.println(lietkabelis.toString());

    }
}
