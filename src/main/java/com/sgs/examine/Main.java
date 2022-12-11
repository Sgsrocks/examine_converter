package com.sgs.examine;

import java.io.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LineNumberReader file = new LineNumberReader(new FileReader("./itemexame.txt"));
        Scanner scan = new Scanner(file);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("./iitemdump.txt", true));
        while(scan.hasNextLine()){
            String[] tokens = scan.nextLine().split(",");
            Optional<String> first = Arrays.stream(tokens).findFirst();
            String last = tokens[tokens.length - 1];
            bw.write("{");
            bw.newLine();
            bw.write("\"id\": "+first+",");
            bw.newLine();
            bw.write("\"examine\": \""+last+"\"");
            bw.newLine();
            bw.write("},");
            bw.newLine();
        }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
