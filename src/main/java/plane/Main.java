package plane;

import java.util.List;

/**
 * 1. Surasti lektuva, kuriame skrenda Jasikevicius
 * 2. Surasti visus trenerius, kurie yra pikti :)
 * 3. Surasti lektuve esancias komandas, kuriu pavadinimai ilgesni nei 5 raides.
 * 4. Surasti lektuva, kurio greitis didesnis nei 1000
 * 5. Surasti komanda, kuri turi daugiau zaideju.
 * 6. Surasti komanda, kuri turi daugiau patirties (sumuoti zaideju patirtis)
 * 7. Surasti brangiausia komandos zaideja.
 * 8. Surasti visus zaidejus is visu komandu, kurie yra is USA
 * 9. Isrinkti is visu komandu zaidejus, kurie turi THREE_POINT_SHOOTER igudi
 * 10. Apkeisti komandu trenerius.
 */

public class Main {

    public static void main(String[] args) throws Throwable {

        List<AirPlane> airPlanes = PopulateDataService.prepareData();
//        for (AirPlane airPlane : airPlanes) {
//            System.out.println(airPlane.getTeam());
//        }

        for (AirPlane airPlane : airPlanes) {
            System.out.println("Lektuvas: " + airPlane.getCompanyName());
            System.out.println("Vietu skaicius: " + airPlane.getSeatCount());
            System.out.println("Greitis: " + airPlane.getSpeed());
            System.out.println("________________");
           // System.out.println("Komanda: " + airPlane.getTeam().getName() + " Salis: " + airPlane.getTeam().getCountry());
           // System.out.println("Treneris: " + airPlane.getTeam().getCoach().getLastName());
            System.out.println("________________");
//            for (Player player : airPlane.getTeam().getPlayers()) {
//                System.out.println(player);
//            }
            System.out.println();
        }

        SearchServices searchServices = new SearchServices(airPlanes);

        System.out.println("1. Lektuva, kuriame skrenda Jasikevicius:");
        searchServices.searchPlaneWithSpecificPlayer("Jasikevicius");
        System.out.println("2. Visi treneriai, kurie yra pikti:");
        searchServices.searchAngryCoaches();
        System.out.println("3. Lektuve esancios komandos, kuriu pavadinimai ilgesni nei 5 raides:");
        searchServices.searchTeamsLongerThanXLetters(5);
        System.out.println("4. Lektuvas, kurio greitis didesnis nei 1000:");
        searchServices.searchAirPlaneFasterThanX(1000);
        System.out.println("5. Komanda, kuri turi daugiau zaideju:");
        searchServices.searchBiggestTeam();
        System.out.println("6. Komanda, kuri turi daugiau patirties (sumuoti zaideju patirtis):");
        searchServices.searchTeamWithBestExperience();
        System.out.println("7. Brangiausias komandos zaidejas:");
        searchServices.searchMostExpansiveTeamPlayer("Armani");
        System.out.println("8. Surasti visus zaidejus is visu komandu, kurie yra is USA");
        searchServices.searchPlayersFromSpesificCountry("USA");
        System.out.println("9. Zaidejai, kurie turi THREE_POINT_SHOOTER igudi:");
        searchServices.searchPlayersHavingTHREE_POINT_SHOOTER(SkillMove.THREE_POINT_SHOOTER);
        System.out.println("10. Komandu treneriu apkeistimas:");
        searchServices.changeCoaches("Armani", "Zalgiris");



    }

}
