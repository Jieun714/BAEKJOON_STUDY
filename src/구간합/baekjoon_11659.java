package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자: 이지은
 * 문제: 백준 11659 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
 *      둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
 *      셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 * 출력: 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 */
public class baekjoon_11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");

        arr[0] = 0;

        for (int i = 1; i < N+1; i++) {
            //구간 합
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i =Integer.parseInt(st.nextToken());
            int j =Integer.parseInt(st.nextToken());

            System.out.println(arr[j] - arr[i-1]);
        }
    }
}
