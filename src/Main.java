import java.util.HashMap;

public class Main { // HashMap
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);

        String englandCapital = capitalCities.get("England");
        System.out.println("England'in başkenti: " + englandCapital);

        capitalCities.remove("England");
        System.out.println("England başkenti silindi.");

        int size = capitalCities.size();
        System.out.println("HashMap'in boyutu: " + size);

        for (String country : capitalCities.keySet()) { //
            System.out.println("Ülke: " + country);
        }

        for (String capital : capitalCities.values()) {
            System.out.println("Başkent: " + capital);
        }

        for (String country : capitalCities.keySet()) {
            System.out.println("Ülke: " + country + ", Başkent: " + capitalCities.get(country));
        }
    }
}
