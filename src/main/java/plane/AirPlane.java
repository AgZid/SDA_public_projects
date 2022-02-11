package plane;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AirPlane {

    private String companyName;
    private int seatCount;
    private List<Team> team;
    private int speed;
}
