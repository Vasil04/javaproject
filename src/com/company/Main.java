package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] firstMatrix = createMatrix(input);
        printMatrix(firstMatrix);
        System.out.println("Желаете ли да създадете втора матрица? Ако желаете въведете 'да' или 'yes', ако не желаете въведете 'не' или 'no'. При всеки вход различен от 'да' или 'yes' няма да бъде създадена нова матрица. Ако желаете да прекратите изберете '0'");
        String response = input.nextLine();
        boolean keepGoing = true;
        while (keepGoing) {
            if (response.equalsIgnoreCase("0")){
                break;
            }
            if (response.equalsIgnoreCase("да") || response.equalsIgnoreCase("yes")) {
                int[][] secondMatrix = createMatrix(input);
                printMatrix(secondMatrix);

                System.out.println("Какво действие желаете да извършите: събиране; изваждане; умножение; детерминанта; обратна; единична?");
                String action = input.nextLine();
                if (action.equalsIgnoreCase("събиране")) {
                    addition(firstMatrix, secondMatrix);
                } else if (action.equalsIgnoreCase("изваждане")) {
                    subtraction(firstMatrix, secondMatrix);
                } else if (action.equalsIgnoreCase("умножение")) {
                    multiplying(firstMatrix, secondMatrix);
                } else if (action.equalsIgnoreCase("детерминанта")) {
                    System.out.println("Ако желаете действието да се изпълни за първата матрица въведете 1, ако желаете за втората - 2");
                    int choice = Integer.parseInt(input.nextLine());
                    if (choice == 1) {
                        if (firstMatrix.length == firstMatrix[0].length) {
                            System.out.println("Детерминантата на избраната матрица е: " + determinant(firstMatrix, firstMatrix.length));
                        } else {
                            System.out.println("Избраната матрица няма детерминанта");
                        }
                    } else if (choice == 2) {
                        if (secondMatrix.length == secondMatrix[0].length) {
                            System.out.println("Детерминантата на избраната матрица е: " + determinant(secondMatrix, secondMatrix.length));
                        } else {
                            System.out.println("Избраната матрица няма детерминанта");
                        }
                    }
                } else if (action.equalsIgnoreCase("обратна")) {
                    System.out.println("Ако желаете действието да се изпълни за първата матрица въведете 1, ако желаете за втората - 2");
                    int choice = Integer.parseInt(input.nextLine());
                    if (choice == 1) {
                        if (firstMatrix.length == firstMatrix[0].length) {
                            int[][] adj = new int[firstMatrix.length][firstMatrix.length];
                            float[][] inv = new float[firstMatrix.length][firstMatrix.length];
                            System.out.println("Обратната матрица е");
                            if (inverse(firstMatrix, inv))
                                display(inv);
                        }
                    } else if (choice == 2) {
                        if (secondMatrix.length == secondMatrix[0].length) {
                            int[][] adj = new int[secondMatrix.length][secondMatrix.length];
                            float[][] inv = new float[secondMatrix.length][secondMatrix.length];
                            System.out.println("Обратната матрица е");
                            if (inverse(secondMatrix, inv))
                                display(inv);
                        }
                    }
                } else if (action.equalsIgnoreCase("единична")) {
                    System.out.println("Ако желаете действието да се изпълни за първата матрица въведете 1, ако желаете за втората - 2");
                    int choice = Integer.parseInt(input.nextLine());
                    if (choice == 1) {
                        isSingular(firstMatrix);
                    } else if (choice == 2) {
                        isSingular(secondMatrix);
                    }
                }
            } else {
                System.out.println("Какво действие желаете да извършите: детерминанта; обратна; единична?");
                String actionTwo = input.nextLine();
                if (actionTwo.equalsIgnoreCase("детерминанта")) {
                    if (firstMatrix.length == firstMatrix[0].length) {
                        System.out.println("Детерминантата на избраната матрица е: " + determinant(firstMatrix, firstMatrix.length));
                    } else {
                        System.out.println("Избраната матрица няма детерминанта");
                    }
                } else if (actionTwo.equalsIgnoreCase("обратна")) {
                    if (firstMatrix.length == firstMatrix[0].length) {
                        int[][] adj = new int[firstMatrix.length][firstMatrix.length];
                        float[][] inv = new float[firstMatrix.length][firstMatrix.length];
                        System.out.println("Обратната матрица е");
                        if (inverse(firstMatrix, inv))
                            display(inv);
                    }
                } else if (actionTwo.equalsIgnoreCase("единична")) {
                    isSingular(firstMatrix);
                }
            }
        }
    }
    private static void isSingular(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][i] == 1 && matrix[i][j] == 0) {
                    counter++;
                }
            }
        }
        if ((counter / (matrix.length-1)) == matrix.length){
            System.out.println("Матрицата е единична");
        }
        else {
            System.out.println("Матрицата не е единична");
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
        System.out.println("Моля въведете колко реда желаете да има вашата матрица");
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

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (i != row && j != column) {
                    cofactors[rowCounter][columnCounter++] = matrix[i][j];

                    if (columnCounter == length - 1) {
                        columnCounter = 0;
                        rowCounter++;
                    }
                }
            }
        }
    }
    static boolean inverse(int A[][], float [][]inverse)
    {
        int det = determinant(A, inverse.length);
        if (det == 0)
        {
            System.out.print("Не съществува обратна матрица на избраната.");
            return false;
        }

        int [][]adj = new int[inverse.length][inverse.length];
        adjoint(A, adj);

        for (int i = 0; i < inverse.length; i++)
            for (int j = 0; j < inverse.length; j++)
                inverse[i][j] = adj[i][j]/(float)det;

        return true;
    }
    static void adjoint(int A[][],int [][]adj)
    {
        if (adj.length == 1)
        {
            adj[0][0] = 1;
            return;
        }
        int sign = 1;
        int [][]temp = new int[adj.length][adj.length];

        for (int i = 0; i < adj.length; i++)
        {
            for (int j = 0; j < adj.length; j++)
            {
                getCofactor(A, temp, i, j, adj.length);
                sign = ((i + j) % 2 == 0)? 1: -1;
                adj[j][i] = (sign)*(determinant(temp, adj.length-1));
            }
        }
    }
    static void display(float A[][])
    {
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A.length; j++)
                System.out.printf("%.6f ",A[i][j]);
            System.out.println();
        }
    }
}
