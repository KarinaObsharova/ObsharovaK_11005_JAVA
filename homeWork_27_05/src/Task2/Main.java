package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static volatile ArrayList evenWords = new ArrayList();
    static volatile ArrayList oddWords = new ArrayList();
    static ArrayList<Character> characterList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File file = new File("src//Task2//input.txt");
        Scanner in = new Scanner(file);
        ArrayList<String> list0 = new ArrayList<>();

        while (in.hasNext()) {
            String line = in.next();
            list0.add(line.toLowerCase(Locale.ROOT));
        }
        for (int i = 0; i < list0.size(); i++) {
            String buf = list0.get(i);
            for (int j = 0; j < buf.length(); j++) {
                if (!characterList.contains(buf.charAt(j))) {
                    characterList.add(buf.charAt(j));
                }
            }
            if (characterList.size() % 2 == 0) {
                MyThread0 myThread0 = new MyThread0();
                myThread0.start();
                myThread0.join();
                characterList.clear();
            } else {
                MyThread1 myThread1 = new MyThread1();
                myThread1.start();
                myThread1.join();
                characterList.clear();
            }
        }
        System.out.println(oddWords);
        System.out.println(evenWords);
    }

    static class MyThread0 extends Thread {
        @Override
        public void run() { // even words
            addToList(characterList);
            try {
                MyThread0.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void addToList(ArrayList<Character> map) {
            String evenWord = map.toString();
            System.out.println("First thread add to ArrayList a word" + evenWord);
            evenWords.add(evenWord);
        }
    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            addToList(characterList);
            try {
                MyThread1.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void addToList(ArrayList<Character> map) {
            String oddWord = map.toString();
            System.out.println("Second thread add to ArrayList a word" + oddWord);
            oddWords.add(oddWord);
        }
    }
}