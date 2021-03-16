import java.io.*;
import java.util.*;


public class Task1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\text.txt");
            Scanner sc = new Scanner(file);
            String text = sc.nextLine();
            while (sc.hasNext()) {
                text += " " + sc.next();
            }
            String[] text1 = text.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");
            for (String key : text1) {
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else
                    map.put(key, 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }


        } catch (FileNotFoundException e) {
            System.out.println("Five not found");
        }
    }
}

