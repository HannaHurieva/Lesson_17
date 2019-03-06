package kitchen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day {



    private String name;

    public Day(String name) {
        this.name = name;
    }

//    private Map<String, List<Cooker>> cookersBySpecialization = new HashMap<>();

//    private Map<MenuPoint, String> specializationByMenuPoint;

//    public Day(Map<String, List<Cooker>> cookersBySpecialization) {
//        this.cookersBySpecialization = cookersBySpecialization;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
