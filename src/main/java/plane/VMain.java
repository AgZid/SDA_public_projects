//package advanceCodingExercise1;
//
//import java.util.List;
//
//public class VMain {
//
//
//
//        public static void main(String[] args) {
//            List<AirPlane> airPlanes = PopulateDataService.prepareData();
//
//            findCoachByLastName("Jasikevicius", airPlanes);
//            findAngryCoach(airPlanes);
//            findTeamNameLongerThen(airPlanes, 6);
//            findPlaneFasterThen(airPlanes, 1000);
//            findTeamWithBiggestPlayerCount(airPlanes);
//            findTeamWithMostExperience(airPlanes);
//            findMostExpensivePlayerInTeam("Zalgiris", airPlanes);
//            printAllPlayersFromGivenCountry("USA", airPlanes);
//            deleteAllPlayerBySkillMove(SkillMove.THREE_POINT_SHOOTER, airPlanes);
//            changeCoachPlaces(airPlanes, "Jasikevicius", "Obradovic");
//            System.out.println(airPlanes);
//
//
//        }
//
//
//        public static void findCoachByLastName(String coachName, List<AirPlane> airPlanes) {
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    if (team.getCoach() != null && team.getCoach().getLastName().equals(coachName)) {
//                        System.out.println(airPlane.getCompanyName());
//                    }
//                }
//            }
//        }
//
//        public static void findAngryCoach(List<AirPlane> airPlanes) {
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    if (team.getCoach().isAngry()) {
//                        System.out.println("Piktas treneris: " + team.getCoach().getLastName());
//                    }
//                }
//            }
//        }
//
//
//        public static void findTeamNameLongerThen(List<AirPlane> airPlanes, int longerThen) {
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    if (team.getName().length() > longerThen) {
//                        System.out.println("Komandos pavadinimas ilgesnis negu " + longerThen + " raide yra " + team.getName());
//                    }
//                }
//            }
//        }
//
//        public static void findPlaneFasterThen(List<AirPlane> airPlanes, int speed) {
//            for (AirPlane airPlane : airPlanes) {
//                if (airPlane.getSpeed() > speed) {
//                    System.out.println("Lektuvo pavaadinimas kuirs greitesnis negu " + speed + " yra " + airPlane.getCompanyName());
//                }
//            }
//        }
//
//        public static void findTeamWithBiggestPlayerCount(List<AirPlane> airPlanes) {
//            String biggestTeam = "";
//            for (AirPlane airPlane : airPlanes) {
//                int biggestPlayerCount = 0;
//                for (Team team : airPlane.getTeams()) {
//                    if (team.getPlayers().size() > biggestPlayerCount) {
//                        biggestPlayerCount = team.getPlayers().size();
//                        biggestTeam = team.getName();
//                    }
//                }
//            }
//            System.out.println("Daugiausia zaideju yra " + biggestTeam + " komandoje");
//        }
//
//        public static void findTeamWithMostExperience(List<AirPlane> airPlanes) {
//            String teamName = "";
//            int experience = 0;
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    int tempExperience = 0;
//                    for (Player player : team.getPlayers()) {
//                        tempExperience += player.getExperience();
//                    }
//                    if (tempExperience > experience) {
//                        experience = tempExperience;
//                        teamName = team.getName();
//                    }
//                }
//            }
//            System.out.println("Komanada su didziausia patirtimi " + teamName + " turi patirties: " + experience);
//        }
//
//        public static void findMostExpensivePlayerInTeam(String teamName, List<AirPlane> airPlanes) {
//            String playerMostExpensive = "";
//            double salary = 0;
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    if (team.getName().equals(teamName)) {
//                        for (Player player : team.getPlayers()) {
//                            if (player.getSalary() > salary) {
//                                salary = player.getSalary();
//                                playerMostExpensive = player.getLastName();
//                            }
//                        }
//                    }
//                }
//            }
//            System.out.println("Most Expensive player is: " + playerMostExpensive + " su alga " + salary);
//        }
//
//        public static void printAllPlayersFromGivenCountry(String country, List<AirPlane> airPlanes) {
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    for (Player player : team.getPlayers()) {
//                        if (player.getNationality().equals(country)) {
//                            System.out.println(player);
//                        }
//                    }
//                }
//            }
//        }
//
//        public static void deleteAllPlayerBySkillMove(SkillMove skillMove, List<AirPlane> airPlanes) {
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    for (int i = 0; i < team.getPlayers().size(); i++) {
//                        if (team.getPlayers().get(i).getSkillMove() == skillMove) {
//                            System.out.println("Zaidejas " + team.getPlayers().get(i).getLastName() + " istrintas");
//                            team.getPlayers().remove(team.getPlayers().get(i));
//                            i--;
//                        }
//                    }
//                }
//            }
//        }
//
//        public static void changeCoachPlaces(List<AirPlane> airPlanes, String coach1, String coach2) {
//            Coach firstCoach = null;
//            Coach secondCoach = null;
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    if (team.getCoach().getLastName().equals(coach1)) {
//                        firstCoach = team.getCoach();
//                    }
//                    if (team.getCoach().getLastName().equals(coach2)) {
//                        secondCoach = team.getCoach();
//                    }
//                }
//            }
//            for (AirPlane airPlane : airPlanes) {
//                for (Team team : airPlane.getTeams()) {
//                    if (team.getCoach().getLastName().equals(coach1)) {
//                        team.setCoach(secondCoach);
//                    }
//                    if (team.getCoach().getLastName().equals(coach2)) {
//                        team.setCoach(firstCoach);
//                    }
//                }
//            }
//        }
//
//}
