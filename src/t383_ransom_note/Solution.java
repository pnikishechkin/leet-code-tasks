package t383_ransom_note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            Scanner sc = new Scanner(reader);
            String s = sc.next();
            System.out.println(s);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения BufferedReader");
        }

        try {
            List<String> lines = Files.readAllLines(Path.of("test.txt"));
            System.out.println(lines.toString());
        } catch (IOException e) {
            System.out.println("Ошибка чтения Files");
        }
    }
}
