package kitchen;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            init();
        } catch (FileNotFoundException e) {
            System.out.println("Бизнес провалился");
        }
    }


    private static void init() throws FileNotFoundException {
        FileUtils fileUtils = new FileUtils();
        String allData = fileUtils.read("input.txt");
        String[] dataParts = allData.split("#####");
        System.out.println(dataParts[0]);
        System.out.println("////////////////////////////");
        System.out.println(dataParts[1]);
    }

    private static void initKitchen(String cookersData, String menuData) {
        String[] splitedCookerData = cookersData.split("\n");
        String day = splitedCookerData[1];
        Map<String, Day> days = new HashMap<>();
        Map<String, List<Cooker>> cookersBySpecialization = initCookers(splitedCookerData);

/*        List<Cooker> cookers = new ArrayList<>();
        for (int i = 2; i < splitedCookerData.length; i++) {
            if (splitedCookerData[i].contains(":")) {
                String[] cookerData = splitedCookerData[i].split(":");
                cookers.add(new Cooker(
                        cookerData[0].split(" ")[0],
                        cookerData[0].split(" ")[1],
                        cookerData[1]));
            } else {
                Map<String, List<Cooker>> cookersBySpecialization = new HashMap<>();
                for (Cooker cooker : cookers) {
                    if (cookersBySpecialization.containsKey(cooker.getSpecialization())) {
                        cookersBySpecialization.get(cooker.getSpecialization()).add(cooker);
                    } else {
                        cookersBySpecialization.put(cooker.getSpecialization(), List.of(cooker));
                    }
                }
                days.put(day, new Day(cookersBySpecialization));
            }*/
        }
        new Kitchen(days);
    }

    private static Map<String, List<Cooker>> initCookers(String[] splitedCookerData) {
        Map<String, List<Cooker>> cookersBySpecialization = new HashMap<>();
        List<Cooker> cookers = new ArrayList<>();
        for (int i = 2; i < splitedCookerData.length; i++) {
            if (splitedCookerData[i].contains(":")) {
                String[] cookerData = splitedCookerData[i].split(":");
                cookers.add(new Cooker(
                        cookerData[0].split(" ")[0],
                        cookerData[0].split(" ")[1],
                        cookerData[1]));
            } else {
                for (Cooker cooker : cookers) {
                    if (cookersBySpecialization.containsKey(cooker.getSpecialization())) {
                        cookersBySpecialization.get(cooker.getSpecialization()).add(cooker);
                    } else {
                        cookersBySpecialization.put(cooker.getSpecialization(), List.of(cooker));
                    }
                }
//                days.put(day, new Day(cookersBySpecialization));
            }
            return cookersBySpecialization;
        }

        private static void initMenuPoints(String[] splitedCookerData) {

        }

    }
