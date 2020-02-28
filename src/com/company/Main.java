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
            System.out.println("Какво действие желаете да извършите:събиране;изваждане;умножение;детерминанта.");
            String action = input.nextLine();
            if (action.equalsIgnoreCase("събиране")) {
                addition(firstMatrix, secondMatrix);
            }
            else if (action.equalsIgnoreCase("изваждане")){
                subtraction(firstMatrix, secondMatrix);
            }
            else if (action.equalsIgnoreCase("умножение")){
                multiplying(firstMatrix, secondMatrix);
            }
            else if (action.equalsIgnoreCase("детерминанта")){
                System.out.println("Ако желаете действието да се изпълни за първата матрица въведете 1, ако желаете за втората - 2");
                int choice = Integer.parseInt(input.nextLine());
                if (choice == 1) {
                    if (firstMatrix.length == firstMatrix[0].length) {
                        System.out.print("Determinant " + "of the matrix is : " + determinant(firstMatrix, firstMatrix.length));
                    } else {
                        System.out.println("Избраната матрица няма детерминанта");
                    }
                }
                else if (choice == 2){
                    if (secondMatrix.length == secondMatrix[0].length) {
                        System.out.print("Determinant " + "of the matrix is : " + determinant(secondMatrix, secondMatrix.length));
                    } else {
                        System.out.println("Избраната матрица няма детерминанта");
                    }
                }
            }
            else if (action.equalsIgnoreCase())
        }
    }

    private static void multiplying(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length == secondMatrix[0].length && firstMatrix[0].length == secondMatrix.length){
            int[][] product = new int[firstMatrix.length][secondMatrix[0].length];
            for(int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < secondMatrix[0].length; j++) {
                    for (int k = 0; k < firstMatrix[0].length; k++) {
                        product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }
            printMatrix(product);
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
            System.out.println("Двете матрици не може да бъдат извадени");
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
    public static int determinant(int matrix[][], int length){
        int determinant = 0;
        if (length == 1){
            return matrix[0][0];
        }
        int cofactors[][] = new int[length][length];
        int sign = 1;
        for (int i = 0; i < length; i++) {
            getCofactor(matrix, cofactors, 0, i, length);
            determinant += sign * matrix[0][i] * determinant(cofactors, length - 1);
            sign = -sign;
        }
        return determinant;
    }
    public static void getCofactor(int matrix[][], int cofactors[][], int row, int column, int length){
        int rowCounter = 0, columnCounter = 0;

        // Looping for each element of
        // the matrix
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (i != row && j != column) {
                    cofactors[rowCounter][columnCounter++] = matrix[i][j];

                    // Row is filled, so increase
                    // row index and reset col
                    //index
                    if (columnCounter == length - 1) {
                        columnCounter = 0;
                        rowCounter++;
                    }
                }
            }
        }
    }
}
