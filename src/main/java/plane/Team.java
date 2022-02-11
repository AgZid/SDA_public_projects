package plane;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Team {
    private String name;
    private String country;

    private List<Player> players;
    private Coach coach;
}
