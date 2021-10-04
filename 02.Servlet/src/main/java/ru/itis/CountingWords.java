package ru.itis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CountingWords {
    MyFileReader fileReader;

    public CountingWords(MyFileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Map<String, Integer> count() {
        Map<String, Integer> wordCounts = new HashMap<>();

        String str;
        while ((str = fileReader.read()) != null) {
            Arrays.stream(str.replaceAll("[-!?().^:,]", " ")
                    .toLowerCase(Locale.ROOT)
                    .split("\\s+"))
                    .filter(w -> w.length() > 0)
                    .forEach(w -> wordCounts.put(w, wordCounts.getOrDefault(w, 0) + 1));
        }
        return wordCounts;
    }
}
