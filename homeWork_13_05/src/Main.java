import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        //Task1
        String[] arrayString = {"aajjj", "air", "jdjjdj", "aajfjjjkkk"};
        Stream<String> stream = Arrays.stream(arrayString)
                .filter(x -> x.charAt(0) == 'a')
                .sorted((x, y) -> Integer.compare(x.length(), y.length()));
        stream.forEach(System.out::println);

        //Task2
        int[] arrayInteger = {123, 432, 654, 111, 475};
        Stream<Integer> stream1 = Arrays.stream(arrayInteger)
                .boxed()
                .sorted((x, y) -> Integer.compare(x % 10, y % 10))
                .map(x -> x/10).distinct();
        stream1.forEach(System.out::println);

        //Task3
        HashMap<String, Integer> hashMap = new HashMap<>();
        File file = new File("./src/task3");
        Stream<String> stream3 = Files.lines(Paths.get("./src/task3"));
        stream3
                .map(x -> x.split("[|]"))
                .map(x -> hashMap.containsKey(x[0]) ?
                        hashMap.put(x[0], hashMap.get(x[0]) + Integer.parseInt(x[1])) :
                        hashMap.put(x[0], Integer.parseInt(x[1]))).count();
        System.out.println(hashMap);
    }
}
