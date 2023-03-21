package UnionFind;

/**
 * 작성자: 이지은
 * 문제: 초기에 n+1개의 집합 {0},{1},{2},,,,{n}이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
 *      집합을 표현하는 프로그램을 작성하시오.
 * 7 4
 * 0 1 3
 * 0 7 6
 * 0 3 6
 * 1 7 6
 *
 * ans: YES
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1717 {
    static int N, M;
    static int [] parent;

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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for(int i =0; i<N+1; i++) parent[i] = i;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x==0) union(a,b); //합집합일 때
            else {
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
