package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter person's data (Surname Name Father's name ddd.mmm.yyy):");
        String info = scan.nextLine();
	    NameManipulator man = new NameManipulator();
        man.separateData(info);
        printData(man);
    }
    public static void printData(NameManipulator man){
        System.out.print(man.getInitials()+" ");
        System.out.print(man.genderIdentifier()+" ");
        System.out.println(man.ageIdentifier());
    }
}
