package Combination;

/**
 * 작성자: 이지은
 * 문제: 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 * 출력: 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
 *      중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_15650_N과M2 {
    static int [] arr;
    static int N, M;
    static boolean [] isSelected;
    static int [] select;

    static void combination(int r, int start) {
        if(r == M) {
            for(int i=0; i<M; i++) System.out.print(arr[select[i]]+" ");
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            select[r] = i;
            combination(r+1, i);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        select = new int[M];
        isSelected = new boolean[N];

        combination(0,0);
    }
}
