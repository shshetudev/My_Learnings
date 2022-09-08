package stream_api.map.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorter {
    private static final Map<Long, String> employees = generateEmployees();

    public static void main(String[] args) {

        // Sort the values in ascending order
        print(sortEmployeesInAscOrder());
        print(convertMapStructure());
        // Sort the map in reverse order

        // Sort the map using sorted() method
    }

    private static Map<Long, String> sortEmployeesInAscOrder() {
        return employees.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
        ));
    }

    private static Map<String, Long> convertMapStructure() {
        return employees.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getValue, Map.Entry::getKey, (e1, e2) -> e2, LinkedHashMap::new
        ));
    }
    private static void print(Map<?, ?> map) {
        System.out.println(map);
    }

    private static HashMap<Long, String> generateEmployees() {
        HashMap<Long, String> employeeMap = new HashMap<>();
        employeeMap.put(1L, "Shahariar");
        employeeMap.put(3L, "Adib");
        employeeMap.put(2L, "Rahul");
        employeeMap.put(5L, "Prince");
        employeeMap.put(4L, "Jewel");
        return employeeMap;
    }
}
