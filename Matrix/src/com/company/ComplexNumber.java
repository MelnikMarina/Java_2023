package com.company;

public class ComplexNumber {
    private double a;//real part
    private double b;//img part

    public ComplexNumber(double a, double b){
        this.a=a;
        this.b=b;
    }
    /**
     * the method adds 2 complex numbers according to the formula: (a + ib) + (c + id) = (a + c) + i(b + d)
     * the method is not static and called from an object of the ComplexNumber class
     * @return the result of addition
     */
    public ComplexNumber add(ComplexNumber num){
        ComplexNumber result= new ComplexNumber(0,0);
        result.a=this.a+num.a;
        result.b= this.b+num.b;
        return result;
    }

    /**
     * the method subtracts one complex number from another according to the formula: (a + ib) - (c + id) = (a - c) + i(b - d)
     * the method is not static and called from an object of the ComplexNumber class
     * @return the result of subtraction
     */
    public ComplexNumber subtract(ComplexNumber num){
        ComplexNumber result= new ComplexNumber(0,0);
        result.a=this.a-num.a;
        result.b= this.b-num.b;
        return result;
    }

    /**
     * the method multiplies 2 complex numbers according to the formula: (a + bi) · (c + di) = (ac – bd) + (ad + bc)i
     * the method is not static and called from an object of the ComplexNumber class
     * @return the result of multiplication
     */
    public ComplexNumber multiply(ComplexNumber num){
        ComplexNumber result= new ComplexNumber(0,0);
        result.a=(this.a*num.a-this.b* num.b);
        result.b=(this.a*num.b+this.b*num.a);
        return result;
   }

    /**
     * the method formates a complex numbers into its triganometric form.
     * the method just prints the trig. form, you can't work with it after
     */
    public void triganomize(){
        double a= this.a;
        double b= this.b;
        double z=Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        double argZ=0;
        if(a>0 && b>0){
            argZ=Math.atan(b/a);
        }
        if(a>0 && b<0){
            argZ=-Math.atan(b/a);
        }
        if(a<0 && b>0){
            argZ=Math.PI-Math.atan(b/a);
        }
        if(a<0 && b<0){
            argZ=-Math.PI+Math.atan(b/a);
        }
        if(a==0 && b>0){
            argZ=Math.PI/2;
        }
        if(a==0 && b<0){
            argZ=-Math.PI/2;
        }
        if(a>0 && b==0){
            argZ=0;
        }
        if(a<0 && b==0){
            argZ=Math.PI;
        }
        argZ=Math.toDegrees(argZ);
        System.out.print(Math.abs(z)+"*"+"cos("+argZ+")+i*sin("+argZ+")");
    }

    /**
     *getters and setters to work with private fields
     */

    public double getA(){
        return this.a;
    }

    public double getB(){
        return this.b;
    }

    public void setA(double a){
        this.a = a;
    }
    public void setB(double b){
        this.b = b;
    }

}
