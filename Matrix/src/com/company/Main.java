package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to work with COMPLEX NUMBERS or MATRIXES?");//the valid commands are UpperCased
            String command = scan.nextLine().toLowerCase().trim();
            switch (command) {
                case "complex numbers":
                    System.out.println("Do you want to ADD 2 COMPLEX numbers, SUBTRACT 2 COMPLEX numbers, MULTIPLY 2 COMPLEX numbers, TRIGANOMIZE complex number");
                    String complexCommand = scan.nextLine().toLowerCase().trim();
                    if (complexCommand.equals("add 2 complex")) {
                        ComplexNumber num1 = new ComplexNumber(0, 0);
                        ComplexNumber num2 = new ComplexNumber(0, 0);
                        try {
                            fillComplex(num1, scan);
                            fillComplex(num2, scan);
                            ComplexNumber res = num1.add(num2);
                            System.out.println("Your result is:");
                            printComplex(res);
                        } catch (InputMismatchException e) {
                            System.out.println("Real and img parts should be doubles. Try again.");
                        }
                    }
                    if (complexCommand.equals("subtract 2 complex")) {
                        ComplexNumber num1 = new ComplexNumber(0, 0);
                        ComplexNumber num2 = new ComplexNumber(0, 0);
                        try {
                            fillComplex(num1, scan);
                            fillComplex(num2, scan);
                            ComplexNumber res = num1.subtract(num2);
                            System.out.println("Your result is:");
                            printComplex(res);
                        } catch (InputMismatchException e) {
                            System.out.println("Real and img parts should be doubles. Try again.");
                        }
                    }
                    if (complexCommand.equals("multiply 2 complex")) {
                        ComplexNumber num1 = new ComplexNumber(0, 0);
                        ComplexNumber num2 = new ComplexNumber(0, 0);
                        try {
                            fillComplex(num1, scan);
                            fillComplex(num2, scan);
                            ComplexNumber res = num1.multiply(num2);
                            System.out.println("Your result is:");
                            printComplex(res);
                        } catch (InputMismatchException e) {
                            System.out.println("Real and img parts should be doubles. Try again.");
                        }
                    }
                    if (complexCommand.equals("triganomize")) {
                        ComplexNumber num1 = new ComplexNumber(0, 0);
                        try {
                            fillComplex(num1, scan);
                            System.out.println("Your result is:");
                            num1.triganomize();
                        } catch (InputMismatchException e) {
                            System.out.println("Real and img parts should be doubles. Try again.");
                        }
                    } else if (!complexCommand.equals("add 2 complex") && !complexCommand.equals("subtract 2 complex") && !complexCommand.equals("multiply 2 complex")
                            && !complexCommand.equals("triganomize")) {
                        System.out.println("No such command");
                    }
                    break;
                case "matrixes":
                    System.out.println("Do you want to ADD 2 MATRIXES,MULTIPLY 2 MATRIXES, TRANSPONATE, FIND DET");
                    String matrixCommand = scan.nextLine().toLowerCase().trim();
                    if (matrixCommand.equals("add 2 matrixes")) {
                        try {
                            MtrFin matrix1 = fillMatrix(scan);
                            MtrFin matrix2 = fillMatrix(scan);
                            MtrFin result = matrix1.addMatrixes(matrix2);
                            System.out.println("Your result is:");
                            printMatrix(result);
                        }
                        catch (InputMismatchException e){
                            System.out.println("Enter proper value of size or an element!");
                        }
                    }
                    if (matrixCommand.equals("multiply 2 matrixes")) {
                        try {
                            MtrFin matrix1 = fillMatrix(scan);
                            MtrFin matrix2 = fillMatrix(scan);
                            MtrFin result = matrix1.multiplyMatrix(matrix2);
                            System.out.println("Your result is:");
                            printMatrix(result);
                        }
                        catch (InputMismatchException e){
                            System.out.println("Enter proper value of size or an element!");
                        }
                    }
                    if (matrixCommand.equals("transponate")) {
                        try {
                            MtrFin matrix1 = fillMatrix(scan);
                            MtrFin result = matrix1.transponate();
                            System.out.println("Your result is:");
                            printMatrix(result);
                        }
                        catch (InputMismatchException e){
                            System.out.println("Enter proper value of size or an element!");
                        }
                    }
                    if (matrixCommand.equals("find det")) {
                        try {
                            MtrFin matrix1 = fillMatrix(scan);
                            ComplexNumber result = matrix1.determinate();
                            System.out.println("Your result is:");
                            printComplex(result);
                        }
                        catch (InputMismatchException e){
                            System.out.println("Enter proper value of size or an element!");
                        }
                    } else if (!matrixCommand.equals("add 2 matrixes") && !matrixCommand.equals("multiply 2 matrixes") && !matrixCommand.equals("transponate")
                            && !matrixCommand.equals("find det")) {
                        System.out.println("No such command");
                    }
                    break;
                default:
                    System.out.println("No such command");
                    break;
            }
        }

    public static void fillComplex(ComplexNumber num, Scanner scan){
            System.out.println("Enter complex number");
            System.out.print("Enter real:");
            double a = scan.nextDouble();
            System.out.print("Enter img:");
            double b = scan.nextDouble();
            num.setA(a);
            num.setB(b);
    }

    public static void printComplex(ComplexNumber num){
        if(num.getB()==0){
            System.out.print(num.getA());
        }
        else if(num.getB()>0) {
            System.out.print(num.getA() + "+" + num.getB() + "i");
        }
        else if(num.getB()<0) {
            System.out.print(num.getB() + "" + num.getB() + "i");
        }
    }
    public static MtrFin fillMatrix(Scanner scan) {
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of cols:");
        int cols = scan.nextInt();
        if(rows==0 || cols==0){
            throw new InputMismatchException("Can't fill matrix of 0 size");
        }
        MtrFin matrix = new MtrFin(rows,cols);
        System.out.println("Enter matrix type");
        String type = scan.next();
            if (type.equals("double")) {
                for (int i = 0; i < matrix.getRows(); i++) {
                    for (int j = 0; j < matrix.getCols(); j++) {
                        System.out.println("Enter element in " + i + " row " + j + " column");
                        double number = scan.nextDouble();
                        matrix.setValue(i,j,new ComplexNumber(number, 0));
                    }
                }
            }
            if (type.equals("complex")) {
                for (int i = 0; i < matrix.getRows(); i++) {
                    for (int j = 0; j < matrix.getCols(); j++) {
                        System.out.println("Enter element in " + i + " row " + j + " column");
                        System.out.println("Enter a");
                        double a = scan.nextDouble();
                        System.out.println("Enter b");
                        double b = scan.nextDouble();
                        matrix.setValue(i,j,new ComplexNumber(a, b));
                    }
                }
            }
            else if (!type.equals("complex") && !type.equals("double")){
                throw new InputMismatchException("Can't work with this type");
            }
        return matrix;
    }
    public static void printMatrix(MtrFin matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                printComplex(matrix.getValue(i,j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
