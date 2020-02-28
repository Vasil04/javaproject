package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] firstMatrix = createMatrix(input);
        printMatrix(firstMatrix);
        System.out.println("Желаете ли да създадете втора матрица? Ако желаете въведете 'да' или 'yes', ако не желаете въведете - 'не' или 'no'. При всеки вход различен от 'да' или 'yes' няма да бъде създадена нова матрица.");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("да") || response.equalsIgnoreCase("yes")) {
            int[][] secondMatrix = createMatrix(input);
            printMatrix(secondMatrix);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("Какво действие желаете да извършите:събиране;изваждане;умножение.");
            String action = input.nextLine();
            if (action.equalsIgnoreCase("събиране")) {
                addition(firstMatrix, secondMatrix);
            }
            if (action.equalsIgnoreCase("изваждане")){
                subtraction(firstMatrix, secondMatrix);
            }
        }
    }

    private static void subtraction(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length == secondMatrix.length && firstMatrix[0].length == secondMatrix[0].length) {
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[0].length; j++) {
                    System.out.print(firstMatrix[i][j] - secondMatrix[i][j]);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Двете матрици не може да бъдат събрани");
        }
    }

    private static void addition(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length == secondMatrix.length && firstMatrix[0].length == secondMatrix[0].length) {
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[0].length; j++) {
                    System.out.print(firstMatrix[i][j] + secondMatrix[i][j]);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Двете матрици не може да бъдат събрани");
        }
    }

    private static int[][] createMatrix(Scanner input) {
        System.out.println("Моля въведете колко реда желаете да има вашата първа матрица");
        int rows = Integer.parseInt(input.nextLine());
        System.out.println("и сега колко колони");
        int columns = Integer.parseInt(input.nextLine());
        int[][] firstMatrix = new int[rows][columns];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                System.out.println("Въведете " + (j+1) +" елемент от " + (i+1) + " ред.");
                firstMatrix[i][j] = Integer.parseInt(input.nextLine());
            }
        }
        return firstMatrix;
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
