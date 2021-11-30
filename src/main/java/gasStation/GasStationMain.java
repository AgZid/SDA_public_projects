package gasStation;

import java.util.ArrayList;
import java.util.Scanner;

public class GasStationMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Gas> gasArrayList = new ArrayList<>();

        gasArrayList.add(new Gas("Benzinas 95", 1.50));
        gasArrayList.add(new Gas("Benzinas 98", 1.70));
        gasArrayList.add(new Gas("Dyzelis", 1.30));

        int userInput = 0;

        while (userInput < 1 || userInput > 3) {
            System.out.println(String.format("Sveiki, pasirinkite dagalų tipą; \n 1 - %s kaina %f EUR, \n 2 - %s kaina %f EUR , \n 3 - %s kaina %f EUR\n",
                    gasArrayList.get(0).getType(), gasArrayList.get(0).getPrice(),
                    gasArrayList.get(1).getType(), gasArrayList.get(1).getPrice(),
                    gasArrayList.get(2).getType(), gasArrayList.get(2).getPrice()));

            userInput = scanner.nextInt();
            if (userInput < 1 && userInput > 3) {
                System.out.println("Neteisingas pasirinkimas");
            }
        }

        System.out.println("Įveskite kolonėlės numerį:");
        int gasColonNumber = scanner.nextInt();
        System.out.println("Įveskite kuro kiekį:");
        double gasAmuont = scanner.nextDouble();

        System.out.println("Čekis:");
        System.out.println("Kolonėlė " + gasColonNumber);
        System.out.println("Kuras " + gasArrayList.get(userInput - 1).getType());
        System.out.println("Kaina " + calculatePrice(gasArrayList.get(userInput - 1).getPrice(), gasAmuont));
    }

    private static double calculatePrice(double price, double amount) {
        return price * amount;
    }

}
