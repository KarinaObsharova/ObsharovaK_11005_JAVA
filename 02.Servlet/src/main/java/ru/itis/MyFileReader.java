package ru.itis;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    private String fileName;
    private BufferedReader reader;


    public MyFileReader(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.reader = new BufferedReader(new FileReader(fileName));
    }

    public String read() {
        try {
            return reader.readLine();
        }
        catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
