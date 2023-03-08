package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharsCounter {
    private String pathToInputFile;
    private String pathToOutputFile;
    private Map<Character, Integer> counterMap = new HashMap<>();
    private int counter;

    /**
     * the method opens a .txt file and reads latin characters into a map using ascii
     * @throws IllegalArgumentException if the file is not .txt
     */
    public void countLatin () throws IllegalArgumentException{
        if(!txtExtension(pathToInputFile)){
            throw new IllegalArgumentException("Can only work with .txt files");
        }
        Scanner myInputFile = null;
        try {
            myInputFile = new Scanner(new File(pathToInputFile));
        while (myInputFile.hasNext()) {
            String curLine = myInputFile.nextLine();
            int size = curLine.length();
            for (int i = 0; i < size; i++) {
                if (curLine.charAt(i) >= 'A' && (int) curLine.charAt(i) <= 'z') {
                    if(counterMap.containsKey(curLine.charAt(i))){
                        counterMap.put(curLine.charAt(i), counterMap.get(curLine.charAt(i)) + 1);
                    }
                    else{
                        counterMap.put(curLine.charAt(i), 1);
                    }
                    counter++;
                }
            }
        }
        myInputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Your file doesn't exist");
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            System.out.println("Something went wrong...");
            throw new RuntimeException(e);
        }
    }

    public void printToFile(){
        if(!txtExtension(pathToOutputFile)){
            throw new IllegalArgumentException("Can only work with .txt files");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToOutputFile));
            writer.write("Total number of latin chars: "+ counter+"\n");
            for(Map.Entry mp: counterMap.entrySet()){
                writer.write(mp.getKey()+ " - "+mp.getValue()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong...");
            throw new RuntimeException(e);
        }
    }


    /**
     * the method check if the file has a .txt extension
     * @param file takes a string(in this case-a path to the file)
     * @return true if file has .txt extension
     */
    public boolean txtExtension(String file){
        String extension=".";
        if(file.length()>=5) {
            for (int i = file.length() - 1; i >= file.length() - 3; i--) {
                extension = extension + file.charAt(i);
            }
            if (extension.equals(".txt")) {
                return true;
            }
        }
        return false;
    }

    public void setPathToInputFile(String pathToInputFile){
        this.pathToInputFile=pathToInputFile;
    }
    public void setPathToOutputFile(String pathToOutputFile){
        this.pathToOutputFile=pathToOutputFile;
    }

}
