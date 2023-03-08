package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputFile, outputFile;

        System.out.println("Enter path to input file: ");
        inputFile=scan.next();
        System.out.println("Enter path to output file: ");
        outputFile=scan.next();

        CharsCounter counter = new CharsCounter();
        counter.setPathToInputFile(inputFile);
        counter.countLatin();
        counter.setPathToOutputFile(outputFile);
        counter.printToFile();
    }
}
