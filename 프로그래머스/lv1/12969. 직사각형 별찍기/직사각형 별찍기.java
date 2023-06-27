import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 5 : 열
        int b = sc.nextInt(); // 3 : 행

        int[][] answer = new int[b][a];
        
        for (int i = 0; i < answer.length; i ++) { // 행의 수
            for (int j = 0; j < answer[0].length; j ++) { // 열의 수 (= 첫 번째 행의 열의 수)
                System.out.print("*");
                if (j == answer[0].length - 1) {
                    System.out.println();
                }
            }
        }
    }
}