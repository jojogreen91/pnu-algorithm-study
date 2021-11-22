import java.util.*;

public class Main {

    static int row;
    static int column;
    static int[][] board;
    static int[][] flag;

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dColumn = {0, 1, 0, -1};

    static int sumMax = Integer.MIN_VALUE;

    static void dfsSolution(int level, int rowNow, int columnNow, int sum) {
        if (level == 3) {
            sumMax = Math.max(sumMax, sum);
            return;
        } else {
            for (int k = 0; k < 4; k++) {
                int nextRow = rowNow + dRow[k];
                int nextColumn = columnNow + dColumn[k];

                if (nextRow >= 0 && nextRow < row && nextColumn >= 0 && nextColumn < column && flag[nextRow][nextColumn] != 1) {
                    flag[nextRow][nextColumn] = 1;

                    dfsSolution(level + 1, nextRow, nextColumn, sum + board[nextRow][nextColumn]);

                    flag[nextRow][nextColumn] = 0;
                }
            }
        }
    }

    static void addSolution(int rowNow, int columnNow) {
        int addCount = 0;

        int sumTotal = board[rowNow][columnNow];
        for (int i = 0; i < 4; i++) {
            int nextRow = rowNow + dRow[i];
            int nextColumn = columnNow + dColumn[i];

            if (nextRow >= 0 && nextRow < row && nextColumn >= 0 && nextColumn < column) {
                addCount++;
                sumTotal += board[nextRow][nextColumn];
            }
        }

        if (addCount == 3) {
            sumMax = Math.max(sumMax, sumTotal);
        } else if (addCount == 4) {
            for (int i = 0; i < 4; i++) {
                int nextRow = rowNow + dRow[i];
                int nextColumn = columnNow + dColumn[i];

                if (nextRow >= 0 && nextRow < row && nextColumn >= 0 && nextColumn < column) {
                    int sumMinusWing = sumTotal - board[nextRow][nextColumn];

                    sumMax = Math.max(sumMax, sumMinusWing);
                }
            }
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        column = sc.nextInt();

        board = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        flag = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                flag[i][j] = 1;
                dfsSolution(0, i, j, board[i][j]);
                flag[i][j] = 0;

                addSolution(i, j);
            }
        }
        System.out.println(sumMax);
    }
}
