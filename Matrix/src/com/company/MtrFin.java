package com.company;

import java.util.Scanner;

public class MtrFin {
    private int rows;
    private int cols;
    private  ComplexNumber[][] matrix;

    public MtrFin(int rows, int cols) {
        this.rows=rows;
        this.cols=cols;
        this.matrix = new ComplexNumber[rows][cols];
    }

    /**
     * the method adds 2 matrixes of the same size.
     * the method is not static and called from an object of the MtrFin class
     * if the sizes are not the same-throws an exception
     * @return the result of addition as a new matrix
     */
    public MtrFin addMatrixes(MtrFin matrix2) {
        if(this.rows!=matrix2.rows || this.cols!=matrix2.cols){
            throw new IllegalArgumentException("Only matrixes of same size can be added");
        }
        MtrFin result = new MtrFin(this.rows, this.cols);
        result.rows = this.rows;
        result.cols = this.cols;
        if (this.rows == matrix2.rows && this.cols == matrix2.cols) {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.cols; j++) {
                    result.matrix[i][j] = this.matrix[i][j].add(matrix2.matrix[i][j]);
                }
            }
        }
        return result;
    }

    /**
     * the method multiplies 2 matrixes.
     * the method is not static and called from an object of the MtrFin class
     * if the number of rows of 1 matrix != number of cols of 2 matrix-throws an exception
     * @return the result of multiplication as a new matrix
     */
    public MtrFin multiplyMatrix(MtrFin matrix2) {
        if (this.cols != matrix2.rows){
            throw new NullPointerException("Matrixes of this size can't be multiplied");
        }
            MtrFin result = new MtrFin(matrix2.rows, matrix2.cols);
                for (int i = 0; i < matrix2.rows; i++) {
                    for (int j = 0; j < matrix2.cols; j++) {
                        result.matrix[i][j] = new ComplexNumber(0, 0);
                        for (int k = 0; k < this.cols; k++) {
                            result.matrix[i][j] = result.matrix[i][j].add(this.matrix[i][k].multiply(matrix2.matrix[k][j]));
                        }
                    }
                }
        return result;
    }

    /**
     * the method transponates a matrix.
     * the method is not static and called from an object of the MtrFin class
     * @return the result of transponation as a new matrix
     */
    public MtrFin transponate(){
        MtrFin result = new MtrFin(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j]=this.matrix[j][i];
            }
        }
        return  result;
    }

    /**
     * the method finds determinant of a matrix.
     * the method is not static and called from an object of the MtrFin class
     * if the matrix is not square - throws an exception
     * @return the result as a ComplexNumber
     */
    public ComplexNumber determinate(){
        ComplexNumber result = new ComplexNumber(0,0);
        if(this.rows!=this.cols) {
            throw new IllegalArgumentException("Can only find det of square matrixes");
        }
            if(this.rows==1){
                result=new ComplexNumber(this.matrix[0][0].getA(), this.matrix[0][0].getB());
            }
            if(this.rows==2){
                ComplexNumber mainDiagonal = this.matrix[0][0].multiply(this.matrix[1][1]);
                ComplexNumber subDiagonal = this.matrix[0][1].multiply(this.matrix[1][0]);
                result = mainDiagonal.subtract(subDiagonal);
            }
            if(this.rows>2){
                for(int i =0; i<this.rows; i++){
                    MtrFin minor = new MtrFin(this.rows-1, this.cols-1);
                    int x =0;
                    int y=0;
                    for(int j=1;j<this.rows;j++){
                        for(int k=0;k<this.rows;k++){
                            if(k==i){
                                continue;
                            }
                            minor.matrix[x][y]=this.matrix[j][k];
                            y++;
                        }
                        y=0;
                        x++;
                    }
                    result=result.add(minor.determinate().multiply(new ComplexNumber(Math.pow(-1,i),0).multiply(this.matrix[0][i])));
                }
            }
        return result;
    }

    /**
     *getters and setters to work with private fields
     */
    public int getRows(){
        return  this.rows;
    }
    public int getCols(){
        return  this.cols;
    }

    public void setRows(int rows){
        this.rows = rows;
    }
    public void setCols(int cols){
        this.cols = cols;
    }

    public ComplexNumber getValue(int i, int j){
        return this.matrix[i][j];
    }

    public  void setValue(int i, int j, ComplexNumber value){
        this.matrix[i][j]= value;
    }
}
