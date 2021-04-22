import java.io.*;
import java.util.*;


public class Task3 {
    public static void main(String[] args){
        Map<String, Map<String, Integer>> map = new HashMap<>();
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\text1.txt");
            Scanner sc = new Scanner(file);
            String text = sc.nextLine();
            while (sc.hasNext()) {
                text += " " + sc.next();
            }
            String[] text1 = text.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");
            for (int i = 1; i < text1.length; i++) {
                if(map.containsKey(text1[i-1])){
                    Map<String, Integer> map2 = map.get(text1[i-1]);
                    if(map2.containsKey(text1[i])){
                        map2.put(text1[i], map2.get(text1[i]) + 1);
                    } else {
                        map2.put(text1[i], 1);
                    }
                    map.put(text1[i-1], map2);
                } else {
                    Map<String, Integer> map2 = new HashMap<>();
                    map2.put(text1[i], 1);
                    map.put(text1[i-1], map2);
                }

            }
            System.out.println(map);


        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
