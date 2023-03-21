package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자: 이지은
 * Dynamic 프로그램
 * 문제: N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다.
 *      둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
 *      다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어진다.
 * 출력: 총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
 */
public class baekjoon_11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j<N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int[N+1][N+1];  //2차원 배열
        //dp점화식
        for(int x = 1; x<N+1; x++) {
            for(int y=1; y<N+1; y++) {
                dp[x][y] = dp[x][y-1] + dp[x-1][y] - dp[x-1][y-1] +arr[x][y];
            }
        }
        //System.out.println(Arrays.deepToString(dp));  //dp값 확인

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 =Integer.parseInt(st.nextToken());
            int y1 =Integer.parseInt(st.nextToken());
            int x2 =Integer.parseInt(st.nextToken());
            int y2 =Integer.parseInt(st.nextToken());

            //구간합
            int total = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];

            System.out.println(total);
        }
    }
}
