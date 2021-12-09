package gasStation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GasStationMainTest {

   static GasStationMain gasStationMain;
   static ArrayList<Gas> gasArrayList = new ArrayList<>();

    @BeforeAll
    public static void executeBeforeAll() {

        gasArrayList.add(new Gas("Kuras_1",1.10));
        gasArrayList.add(new Gas("Kuras_2",1));

        gasStationMain = new GasStationMain(gasArrayList);
    }

    @Test
    void TestIsIncorrectGasType_validNumber() {
        assertThat(gasStationMain.isIncorrectGasType(1)).isFalse();
        assertThat(gasStationMain.isIncorrectGasType(gasArrayList.size())).isFalse();
    }

    @Test
    void TestIsIncorrectGasType_invalidNumber() {
        assertThat(gasStationMain.isIncorrectGasType(0)).isTrue();
        assertThat(gasStationMain.isIncorrectGasType(gasArrayList.size()+1)).isTrue();
    }

    @Test
    void isCorrectGasStationNumber_validNumber() {
        assertThat(gasStationMain.isCorrectGasStationNumber(1)).isTrue();
        assertThat(gasStationMain.isCorrectGasStationNumber(10)).isTrue();
    }

    @Test
    void isCorrectGasStationNumber_invalidNumber() {
        assertThat(gasStationMain.isCorrectGasStationNumber(0)).isFalse();
        assertThat(gasStationMain.isCorrectGasStationNumber(11)).isFalse();
    }

    @Test
    void isAmountGTZero_validNumber() {
        assertThat(gasStationMain.isAmountGTZero(0.01)).isTrue();
    }

    @Test
    void isAmountGTZero_invalidNumber() {
        assertThat(gasStationMain.isAmountGTZero(0)).isFalse();
    }

    @Test
    void calculatePrice() {
        assertThat(gasStationMain.calculatePrice(1.15, 10.105)).isEqualTo(11.62);
    }
}