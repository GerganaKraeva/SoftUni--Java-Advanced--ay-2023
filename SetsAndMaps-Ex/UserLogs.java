package SetsAndMapsAdvancedEx;
import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> userIP = new TreeMap<>();

        while (!userInput.equals("end")) {
            String[] info = userInput.split("\\s");
            int startIndexIP = getIndex(info[0], '=');
            String ip = info[0].substring(startIndexIP + 1);
            int startIndexUser = getIndex(info[2], '=');
            String user = info[2].substring(startIndexUser + 1);

            userIP.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> ipAndMessage = userIP.get(user);
            if(!ipAndMessage.containsKey(ip)){
                ipAndMessage.put(ip,1);
            }else{
                ipAndMessage.put(ip,ipAndMessage.get(ip)+1);
            }
            userInput = scanner.nextLine();
        }

        for (String user : userIP.keySet()) {
            System.out.println(user + ":");
            Map<String,Integer>currentIp=userIP.get(user);
            int countIp=currentIp.size();
            for (String ip : currentIp.keySet()) {
                if (countIp == 1) {
                    System.out.println(ip + " => " + currentIp.get(ip) + ".");
                }else{
                    System.out.print(ip+" => "+currentIp.get(ip)+", ");
                }
                countIp--;
            }
        }
    }

    private static int getIndex(String word, char symbol) {
       int index=0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == symbol) {
                index=i;
            }
        }
        return index;
    }
}
