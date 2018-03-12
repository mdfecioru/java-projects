package com.mdfecioru.util.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Collection;

public class ReadFromFile {
    public static void readIntegers (InputStream inputStream, Collection<Integer> c) {

        Scanner scanner = null;

        try {
            scanner = new Scanner(inputStream);

            while (scanner.hasNextInt()) {
                c.add(scanner.nextInt());
            }
        }
        catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
        finally {
            if (scanner != null) scanner.close();
        }

        return;
    }
}
