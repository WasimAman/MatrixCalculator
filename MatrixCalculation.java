/*
    The job of this program is to perform Matrix calculations...
    like.
        Addition,substraction,multiplication,Transpose and determinant etc...
*/
import java.util.Arrays;
import java.util.Scanner;

public class MatrixCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("1) Addition\t\t\t2) Substraction");
            System.out.println("3) Multiplication\t\t4) Transpose");
            System.out.println("5) Determinant(nxn)\t\t6) Exit");
            System.out.print("Which calculation do you want to perform: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:

                    int rows,cols;
                    System.out.print("Enter row's number:- ");
                    rows = sc.nextInt();
                    System.out.print("Enter col's number:- ");
                    cols = sc.nextInt();
                    int[][] matA = getMatrixInput(rows, cols, sc);      
                    int[][] matB = getMatrixInput(rows, cols, sc);
                    addition(matA,matB,rows,cols,sc);
                    break;
                case 2:
                    int row,col;
                    System.out.print("Enter row's number:- ");
                    row = sc.nextInt();
                    System.out.print("Enter col's number:- ");
                    col = sc.nextInt();
                    int[][] Amat = getMatrixInput(row, col, sc);      
                    int[][] Bmat = getMatrixInput(row, col, sc);
                    substraction(Amat, Bmat, row, col,sc);
                    break;
                case 3:
                    int rowA,rowB,colA,colB;
                    do{
                        System.out.print("Enter rowA number:- ");
                        rowA = sc.nextInt();
                        System.out.print("Enter colA number:- ");
                        colA = sc.nextInt();
                        System.out.print("Enter rowB number:- ");
                        rowB = sc.nextInt();
                        System.out.print("Enter colB number:- ");
                        colB = sc.nextInt();
                    }while(colA!=rowB);
                    int[][] MmatA = getMatrixInput(rowA, colA, sc);        
                    int[][] MmatB = getMatrixInput(rowB, colB, sc);
                    int[][] mul = new int[rowA][colB];
                    multiplication(MmatA,MmatB,mul,rowA,rowB,colA,colB,sc);
                    break;
                case 4:
                    int rowT,colT;
                    System.out.print("Enter row's number:- ");
                    rowT = sc.nextInt();
                    System.out.print("Enter col's number:- ");
                    colT = sc.nextInt();
                    int[][] mat = getMatrixInput(rowT, colT, sc); 
                    transpose(mat,rowT,colT,sc);
                    break;
                case 5:
                    int n;
                    do{
                        System.out.print("Enter the value of n (matrix size): ");
                        n = sc.nextInt();
                        if(n<=0){
                            System.out.println("Invalid size!!!");
                        }
                    }while(n<=0);
                    int[][] Dmat = getMatrixInput(n, n, sc);
                    System.out.println("Determinant = " + calculateDeterminant(Dmat));
                    break;
                case 6:
                    continueCalculation = false;
                    System.out.println("Thanks for using this!!!");

                    break;
                default:
                    System.out.println("Invalid choice!!");
            }
        }
        sc.close();
    }

    public static int[][] getMatrixInput(int rows, int cols,Scanner sc) {
        int[][] mat = new int[rows][cols];
        System.out.println("Enter Element for " + rows + "x" + cols + " matrix: ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at row " + (i + 1) + " and column " + (j + 1) + ": ");
                mat[i][j] = sc.nextInt();
            }
        }
        sc.nextLine(); // Consume the newline character
        return mat;
    }

    public static void addition(int[][] matA,int[][] matB,int rows,int cols,Scanner sc){
        int[][] add = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                add[i][j] = matA[i][j]+matB[i][j];
            }
        }
        System.out.println("The result of addition matrix is:");
        for(int i=0;i<rows;i++){
            System.out.println(Arrays.toString(add[i]));
        }
        return;
    }
    public static void substraction(int[][] matA,int[][] matB,int rows,int cols,Scanner sc){
        int[][] add = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                add[i][j] = matA[i][j]+matB[i][j];
            }
        }
        System.out.println("The result of addition matrix is:");
        for(int i=0;i<rows;i++){
            System.out.println(Arrays.toString(add[i]));
        }
        return;
    }
    public static void multiplication(int[][] matA,int[][] matB,int[][] mul,int rowA,int rowB,int colA,int colB,Scanner sc){
        for(int i=0;i<rowA;i++){
            for(int j=0;j<colB;j++){
                mul[i][j] = 0;
                for(int k=0;k<colA;k++){
                    mul[i][j]+=matA[i][k]*matB[k][j];
                }
            }
        }
        System.out.println("The result of addition matrix is:");
        for(int i=0;i<rowA;i++){
            System.out.println(Arrays.toString(mul[i]));
        }
        return;
    }
    public static void transpose(int[][] mat ,int rows,int cols,Scanner sc){
         
        int[][] trans = new int[cols][rows];      
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int temp = mat[i][j];
                trans[j][i] = temp;
            }           
        }
        System.out.println("Transpose matrix is:");
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                System.out.print(trans[i][j]+" ");
            }
            System.out.println();
        }
        return;
    }
    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        // Base case: If the matrix is 1x1, return the single element as the determinant.
        if (n == 1) {
            return matrix[0][0];
        }

        int determinant = 0;

        for (int i = 0; i < n; i++) {
            determinant += matrix[0][i] * getCofactor(matrix, 0, i) * Math.pow(-1, i);
        }

        return determinant;
    }

    // Function to get the cofactor of a matrix after excluding a given row and column
    public static int getCofactor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] cofactor = new int[n - 1][n - 1];

        int newRow = 0;
        int newCol;

        for (int i = 0; i < n; i++) {
            if (i == row) continue;

            newCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;

                cofactor[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }

        return calculateDeterminant(cofactor);
    }
}
