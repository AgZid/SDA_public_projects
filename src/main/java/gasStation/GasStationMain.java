package gasStation;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class GasStationMain {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Gas> gasArrayList;

    int numberOfGasStations = 10;

    private static final Logger LOGGER = Logger.getLogger(GasStationMain.class);

    public GasStationMain(ArrayList<Gas> gasArrayList) {
        this.gasArrayList = gasArrayList;
    }

    public static void main(String[] args) throws FileNotFoundException {

        GasStationMain gasStationMain = new GasStationMain(new GasServices().readFile());
        gasStationMain.printCheque(gasStationMain.selectGasType(), gasStationMain.selectGasStationNumber(),
                gasStationMain.selectGasAmount());
    }

    public Gas selectGasType() {
        return gasArrayList.get(readGasType() - 1);

    }

    public int readGasType() {
        int gasType = 0;

        while (isIncorrectGasType(gasType)) {

            System.out.println("Sveiki, pasirinkite dagalų tipą");
            int n = 1;

            for (Gas gas : gasArrayList) {
                System.out.println("Tipas " + n + ": " + gas.getType() + " kaina: " + gas.getPrice());
                n++;
            }

            gasType = scanner.nextInt();
            if (isIncorrectGasType(gasType)) {
                System.out.println("Neteisingas pasirinkimas");
            }
        }
        return gasType;
    }

    public boolean isIncorrectGasType(int gasType) {
        LOGGER.info("Checking gas type " + gasType);
        return (gasType < 1 || gasType > gasArrayList.size());
    }

    public int selectGasStationNumber() {
        System.out.println("Įveskite kolonėlės numerį:");
        int gasStationNumber = scanner.nextInt();

        while (!isCorrectGasStationNumber(gasStationNumber)) {
            System.out.println("Klaida, neteingas kolonėlės numeris \n Nurodykite kalonėlės numerį:");
            gasStationNumber = scanner.nextInt();
        }

        return gasStationNumber;
    }

    public boolean isCorrectGasStationNumber(int gasStationNumber) {
        LOGGER.info("Checking gas station number " + gasStationNumber);
        return (gasStationNumber >= 1 && gasStationNumber <= numberOfGasStations);
    }

    public double selectGasAmount() {
        System.out.println("Įveskite kuro kiekį:");
        double gasAmount = scanner.nextDouble();

        while (!isAmountGTZero(gasAmount)) {
            System.out.println("Klaida, kuro kiekis turi būti didesnis už 0 \n Nurodykite kuro kiekį");
            gasAmount = scanner.nextDouble();
        }

        return gasAmount;
    }

    public boolean isAmountGTZero(double gasAmount) {
        LOGGER.info("Checking gas amount " + gasAmount);
        return (gasAmount > 0);
    }

    public double calculatePrice(double price, double amount) {
        LOGGER.info("Counting price " + price + " for amount " + amount);
        return (double) Math.round(price * amount * 100) / 100;
    }

    public void printCheque(Gas gasType, int gasStationNumber, double gasAmount) {
        System.out.println("*****************************************");
        System.out.println("Čekis:");
        System.out.println("Kolonėlė " + gasStationNumber);
        System.out.println("Kuras " + gasType.getType());
        System.out.println("Suma " + calculatePrice(gasType.getPrice(), gasAmount) + " EUR");
        System.out.println("*****************************************");
        System.out.println("Aptarnavimo laikas: " + LocalDateTime.now());
        System.out.println("*****************************************");

    }
}
