package gasStation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GasServices {

    private final String GAS_RESOURCE = "src/main/resources/GasList.csv";

    public ArrayList<Gas> readFile() throws FileNotFoundException {
        ArrayList<Gas> gasArrayList = new ArrayList<>();

        try (BufferedReader gasFile = new BufferedReader(new FileReader(GAS_RESOURCE))) {
            String singleLine;

            while((singleLine = gasFile.readLine()) != null) {
                String[] line = singleLine.split(",");
                gasArrayList.add(new Gas(line[0], Double.parseDouble(line[1])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return gasArrayList;
    }
}
