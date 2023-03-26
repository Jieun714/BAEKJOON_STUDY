package UnionFind;

/**
 * 문제: 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
 *      1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 *
 * 유니온 파인드를 사용한 풀이
 * 4
 * 3
 * 1 2
 * 3 4
 * 2 3
 * ans: 3
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2606 {
    static int N; // 컴퓨터의 수
    static int M; // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
    static int[] parent;

    // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        Arrays.setAll(parent, i -> i);  //배열 초기화

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int cnt = 0; //1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
        for(int i=2; i<N+1; i++) {
            if(find(1) == find(i)) cnt++;
        }

        System.out.println(cnt);
    }
}
