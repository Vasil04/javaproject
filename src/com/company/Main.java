package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Добре дошли, моля въведете колко реда желаете да има вашата първа матрица");
        int rows = input.nextInt();
        System.out.println("и сега колко колони");
        int columns = input.nextInt();
        int[][] firstMatrix = new int[rows][columns];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                System.out.println("Въведете " + (j+1) +" елемент от " + (i+1) + " ред.");
                firstMatrix[i][j] = input.nextInt();
            }
        }
        printMatrix(firstMatrix);
    }
    public static void printMatrix (int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
