package gasStation;

import java.util.ArrayList;
import java.util.Scanner;

public class GasStationMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Gas> gasArrayList = new ArrayList<>();

        Gas gas95 = new Gas("Benzinas 95", 1.50);
        Gas gas98 = new Gas("Benzinas 98", 1.70);
        Gas gasDyzelis = new Gas("Dyzelis", 1.30);

        gasArrayList.add(gas95);
        gasArrayList.add(gas98);
        gasArrayList.add(gasDyzelis);

        int userInput = 0;

        while (userInput < 1 || userInput > 3) {
            System.out.println(String.format("Sveiki, pasirinkite dagalų tipą; \n 1 - %s %f EUR, \n 2 - %s %f EUR , " +
                            "\n 3 - %s %f EUR",gas95.getType(), gas95.getPrice(), gas98.getType(),  gas98.getPrice(),
                    gasDyzelis.getType(), gasDyzelis.getPrice()));
            userInput = scanner.nextInt();
            if (userInput < 1 && userInput > 3) {
                System.out.println("Neteisingas pasirinkimas");
            }
        }

        System.out.println("Įveskite kolonėlės numerį:");
        int gasColonNumber = scanner.nextInt();
        System.out.println("Įveskite kuro kiekį:");
        double gasAmuont = scanner.nextDouble();

        double price = calculatePrice(gasArrayList.get(userInput - 1).getPrice(),gasAmuont );
        System.out.println("Čekis:");
        System.out.println("Kolonėlė " + gasColonNumber);
        System.out.println("Kuras " + gasArrayList.get(userInput - 1).getType());
        System.out.println("Kaina " + price);

    }

    private static double calculatePrice(double price, double amount) {
        return price * amount;
    }

}
