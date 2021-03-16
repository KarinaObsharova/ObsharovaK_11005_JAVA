import java.io.*;
import java.util.*;


public class Task3 {
    public static void main(String[] args){
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\text1.txt");
            Scanner sc = new Scanner(file);
            String text = sc.nextLine();
            while (sc.hasNext()) {
                text += " " + sc.next();
            }
            String[] text1 = text.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");
            for (int i = 1; i < text1.length; i++) {
                if(map.containsKey(text1[i-1])){ // если слово есть
                    Map<String, Integer> temp = map.get(text1[i-1]);
                    if(temp.containsKey(text1[i])){
                        temp.put(text1[i], temp.get(text1[i]) + 1);
                    } else {
                        temp.put(text1[i], 1);
                    }
                    map.put(text1[i-1], temp);
                } else {
                    Map<String, Integer> temp = new HashMap<>();
                    temp.put(text1[i], 1);
                    map.put(text1[i-1], temp);
                }

            }
            System.out.println(map);


        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
