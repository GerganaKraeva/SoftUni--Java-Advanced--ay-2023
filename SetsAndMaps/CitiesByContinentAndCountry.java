package SetsAndMapsAdvancedLab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] userInfo = scanner.nextLine().split("\\s+");
            String continent = userInfo[0];
            String country = userInfo[1];
            String city = userInfo[2];
            continents.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countryAndCities = continents.get(continent);
            countryAndCities.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countryAndCities.get(country);
            cities.add(city);
        }
        for (String continent : continents.keySet()) {
            System.out.println(continent + ":");
            continents.get(continent).forEach((key, value) ->
                    System.out.println(key + " -> " + String.join(", ", value)));
        }

    }
}

