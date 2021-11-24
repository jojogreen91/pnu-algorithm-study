import java.util.*;

public class Main {

    static class Place {
        int row;
        int column;

        public Place(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static int distance(int chickenRow, int chickenColumn, int houseRow, int houseColumn) {
        int distance = Math.abs(chickenRow - houseRow) + Math.abs(chickenColumn - houseColumn);

        return distance;
    }

    static int[] flag;
    static int chickenMeterMin = Integer.MAX_VALUE;

    static void solution(int level, int pointer, ArrayList<Place> chickenList, ArrayList<Place> houseList, int chickenMax) {
        if (level == chickenMax) {
            int chickenMeter = 0;

            for (int j = 0; j < houseList.size(); j++) {
                Place houseTemp = houseList.get(j);

                int chickenMeterThisHouse = Integer.MAX_VALUE;
                for (int i = 0; i < flag.length; i++) {
                    if (flag[i] == 1) {
                        Place chickenTemp = chickenList.get(i);

                        int temp = distance(chickenTemp.row, chickenTemp.column, houseTemp.row, houseTemp.column);
                        chickenMeterThisHouse = Math.min(chickenMeterThisHouse, temp);
                    }
                }

                chickenMeter += chickenMeterThisHouse;
            }

            chickenMeterMin = Math.min(chickenMeterMin, chickenMeter);
        } else {
            for (int i = pointer; i < chickenList.size(); i++) {
                flag[i] = 1;
                solution(level + 1, i + 1, chickenList, houseList, chickenMax);
                flag[i] = 0;
            }
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int chickenMax = sc.nextInt();

        int[][] board = new int[num + 1][num + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        ArrayList<Place> chickenList = new ArrayList<>();
        ArrayList<Place> houseList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (board[i][j] == 2) {
                    chickenList.add(new Place(i, j));
                } else if (board[i][j] == 1) {
                    houseList.add(new Place(i, j));
                }
            }
        }

        flag = new int[chickenList.size()];

        solution(0, 0, chickenList, houseList, chickenMax);
        System.out.println(chickenMeterMin);
    }
}
