package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NameManipulator {
    private String surname;
    private String name;
    private String fathersName;
    private int birthYear;
    private int birthMonth;
    private int birthDate;
    private char gender;
    private String age;

    /**
     * the method generates initials out of first name and father's name and concatinates it with surname
     * @return a string that contains surname and initials
     */
    public String getInitials(){
        String initials= this.surname.charAt(0)+"."+this.fathersName.charAt(0);
        String result = this.surname + " "+ initials;
        return result;
    }

    /**
     * a method determines the gender of a person based on an idea that russian people whose
     * father's name ends with "ч" are male
     * @return gender of a person represented by char
     */
    public char genderIdentifier (){
        if(this.fathersName.charAt(this.fathersName.length()-1) == 'ч'){
            this.gender = 'М';
        }
        else{
            this.gender = 'Ж';
        }
        return gender;
    }

    /**
     * a method identifies age of a person on a current date. It also determines the appropriate form
     * of the word that describes age in Russian language
     * @return age and an appropriate word
     */
    public String ageIdentifier(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuu.MM.dd");
        LocalDate localDate = LocalDate.now();
        String curDate = dtf.format(localDate);
        String result[]=curDate.split("\\.");
        int curYear = Integer.parseInt(result[0]);
        int curMonth = Integer.parseInt(result[1]);
        int curDay = Integer.parseInt(result[2]);
        if(curMonth<birthMonth || (curMonth==birthMonth && curDay<birthDate)){
            this.age = (curYear-this.birthYear)-1+" ";
        }
        else {
            this.age = curYear-this.birthYear+" ";
        }
        int lastAgeDigit = Character.getNumericValue(this.age.charAt(this.age.length()-2));
        if(lastAgeDigit==1){
            this.age +="год";
        }
        if(lastAgeDigit == 2 || lastAgeDigit == 3 || lastAgeDigit == 4){
            this.age += "года";
        }
        else{
            this.age+="лет";
        }
        return this.age;
    }

    /**
     * a method breaks down an input string into fragments
     * @param data is an input string containing data about the person
     */

    public void separateData(String data){
       try {
            String result[] = data.split(" ");
            this.surname = result[0];
            this.name = result[1];
            this.fathersName = result[2];
            String birthDate[] = result[3].split("\\.");
            this.birthDate = Integer.parseInt(birthDate[0]);
            this.birthMonth = Integer.parseInt(birthDate[1]);
            this.birthYear = Integer.parseInt(birthDate[2]);
        } catch (NumberFormatException e){
           System.out.println("Please, enter birthDate according to the format!");
           System.exit(-1);
       }
       catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Please, enter data in an appropriate format!");
           System.exit(-1);
       }
    }
}
