package kitchen;

import java.io.FileNotFoundException;
import java.util.*;

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
        Map<String, Set<String>> cookersDataMap = initDataByDay(cookersData);
        Map<String, Set<String>> menuDataMap = initDataByDay(menuData);
        Map<String, Day> days = new HashMap<>();
        // Map<String, Set<Cooker>> cookersBySpecialization = initCookers(splitedCookerData);
        new Kitchen(days);
    }

    private static Map<String, Set<String>> initDataByDay(String data) {
        String[] splitedCookerData = data.split("\n");
        String day = splitedCookerData[0];
        Map<String, Set<String>> result = new HashMap<>();
        Set<String> dataSet = new HashSet<>();
        for (int i = 1; i < splitedCookerData.length; i++) {
            if (splitedCookerData[i].contains(":")) {
                dataSet.add(splitedCookerData[i]);
            } else {
                result.put(day, dataSet);
                dataSet = new HashSet<>();
            }
        }
        return result;
    }

    public static Map<String, Set<Cooker>> initCookers(Set<String> cookerData) {
        List<Cooker> cookers = new ArrayList<>();
        for (String cooker : cookerData) {
            String[] splitedCookerData = cooker.split(":");
            cookers.add(new Cooker(
                    splitedCookerData[0].split(" ")[0],
                    splitedCookerData[0].split(" ")[1],
                    splitedCookerData[1]));
        }
        return getCookerPointBySpecialization(cookers);
    }

    public static Map<String, Set<MenuPoint>> initMenuPoints(Set<String> menuData) {
        List<MenuPoint> menuPoints = new ArrayList<>();
        for (String menuPoint : menuData) {
            String[] splitedMenuData = menuPoint.split(":");
            menuPoints.add(new MenuPoint(
                    splitedMenuData[0],
                    getPriceFromString(splitedMenuData[1]),
                    splitedMenuData[2]));
        }
        return getMenuPointBySpecialization(menuPoints);
    }

    private static Map<String, Set<MenuPoint>> getMenuPointBySpecialization(List<MenuPoint> menuPoints) {
        Map<String, Set<MenuPoint>> menuBySpecialization = new HashMap<>();
        for (MenuPoint menuPoint : menuPoints) {
            if (menuBySpecialization.containsKey(menuPoint.getSpecialization())) {
                menuBySpecialization.get(menuPoint.getSpecialization()).add(menuPoint);
            } else {
                menuBySpecialization.put(menuPoint.getSpecialization(), Set.of(menuPoint));
            }
        }
        return menuBySpecialization;
    }

    private static Map<String, Set<Cooker>> getCookerPointBySpecialization(List<Cooker> cookers) {
        Map<String, Set<Cooker>> cookersBySpecialization = new HashMap<>();
        for (Cooker cooker : cookers) {
            if (cookersBySpecialization.containsKey(cooker.getSpecialization())) {
                cookersBySpecialization.get(cooker.getSpecialization()).add(cooker);
            } else {
                cookersBySpecialization.put(cooker.getSpecialization(), Set.of(cooker));
            }
        }
        return cookersBySpecialization;
    }

    private static double getPriceFromString(String stringPrice) {
        String[] prices = stringPrice.split(" ");
        return Double.parseDouble(prices[0].replace("грн", ""))
                + Double.parseDouble(prices[1].replace("коп", "")) * 0.01;
    }


}

