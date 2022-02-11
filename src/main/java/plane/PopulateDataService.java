package plane;

import java.util.ArrayList;
import java.util.List;

public class PopulateDataService {

    public static List<AirPlane> prepareData() {
        List<AirPlane> airplanes = new ArrayList<>();

        Player kevin = new Player("Kevin", "Durant", 33, 1000.00, 12, "USA", SkillMove.THREE_POINT_SHOOTER);
        Player kobe = new Player("Kobe", "Bryant", 34, 1200.00, 14, "Poland", SkillMove.MID_RANGE_SHOOTER);
        Player lebron = new Player("Lebron", "James", 28, 900.00, 9, "Lithuania", SkillMove.DUNKER);
        List<Player> zalgirisPlayers = new ArrayList<>();
        zalgirisPlayers.add(kevin);
        zalgirisPlayers.add(kobe);
        zalgirisPlayers.add(lebron);
        Coach coachSarunas = new Coach("Sarunas", "Jasikevicius", 45, 3500.00, Boolean.TRUE, "Defense");
        Team teamZalgiris1 = new Team("Zalgiris", "Lithuania", zalgirisPlayers, coachSarunas);

        Player james = new Player("James", "Harden", 29, 1500.00, 7, "USA", SkillMove.BLOCKER);
        Player luka = new Player("Luka", "Doncic", 21, 500.00, 3, "Slovenia", SkillMove.THREE_POINT_SHOOTER);
        Player blake = new Player("Blake", "Griffin", 25, 2000.00, 18, "USA", SkillMove.PLAYMAKER);
        Coach coachZjelko = new Coach("Zjelko", "Obradovic", 65, 15000.00, Boolean.FALSE, "Offense");
        List<Player> armaniPlayers = new ArrayList<>();
        armaniPlayers.add(james);
        armaniPlayers.add(luka);
        armaniPlayers.add(blake);

        Team teamAramni = new Team("Armani", "Italy", armaniPlayers, coachZjelko);
        List<Team> teamAramniKomandos = new ArrayList<>();
        teamAramniKomandos.add(teamAramni);

        List<Team> teamZalgirioKomandos = new ArrayList<>();
        teamZalgirioKomandos.add(teamZalgiris1);

        AirPlane ryanairPlane = new AirPlane("Ryanair", 300, teamZalgirioKomandos, 1200);
        AirPlane wizairPlan = new AirPlane("Wizair", 150, teamAramniKomandos, 950);

        airplanes.add(ryanairPlane);
        airplanes.add(wizairPlan);

        return airplanes;
    }
}