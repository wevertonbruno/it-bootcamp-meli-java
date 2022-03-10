import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, List<Integer>> CITIES = new HashMap<>();

        CITIES.put("Londres", Arrays.asList(-2, 33));
        CITIES.put("Madrid", Arrays.asList(-3, 32));
        CITIES.put("Nueva York", Arrays.asList(-8, 27));
        CITIES.put("Buenos Aires", Arrays.asList( 4, 37));
        CITIES.put("Asuncion", Arrays.asList( 6, 42));
        CITIES.put("Sao Paulo", Arrays.asList( 5, 43));
        CITIES.put("Lima", Arrays.asList( 0, 39));
        CITIES.put("Santiago de Chile",Arrays.asList(-7, 26) );
        CITIES.put("Lisboa", Arrays.asList(-1, 31));
        CITIES.put("Tokio", Arrays.asList(-10, 35));

        Map.Entry<String, List<Integer>> maxTemp = null;
        Map.Entry<String, List<Integer>> minTemp = null;

        for(Map.Entry<String, List<Integer>> city: CITIES.entrySet()){
            //Getting max temperature
            if(maxTemp == null || city.getValue().get(1).compareTo(maxTemp.getValue().get(1)) > 0){
                maxTemp = city;
            }

            //Getting min temperature
            if(minTemp == null || city.getValue().get(0).compareTo(minTemp.getValue().get(0)) < 0){
                minTemp = city;
            }
        }

        System.out.println("A temperatura mais alta foi em " +
                maxTemp.getKey() +
                ", com " +
                maxTemp.getValue().get(1) +
                "° C"
        );

        System.out.println("A temperatura mais baixa foi em " +
                minTemp.getKey() +
                ", com " +
                minTemp.getValue().get(0) +
                "° C"
        );
    }

}
