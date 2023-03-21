package UnionFind;

/**
 * 작성자: 이지은
 * 문제: 도시들의 개수와 도시들 간의 연결 여부가 주어져 있고, 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때 가능한지 여부를 판별하는 프로그램을 작성하시오.
 *      같은 도시를 여러 번 방문하는 것도 가능하다.
 *
 *  유니온 파인드 알고리즘 사용
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1976 {
    static int N, M;
    static int[] parent;
    static int [] plans;

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
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //도시의 수
        M = Integer.parseInt(br.readLine()); //여행 계획 수

        parent = new int[N + 1];
        plans = new int[M];

        for (int i = 0; i < N + 1; i++)
            parent[i] = i;

        //도시 연결 정보
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<N+1; j++) {
                int x = Integer.parseInt(st.nextToken());

                if(x == 1) union(i, j); //연결되어있을 떄
            }
        }

        //여행 계획 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0; //여행계획 카운트
        for(int i=0; i<M-1; i++) {
            if(find(plans[i]) == find(plans[i+1])) cnt ++;
            else break;
        }

        if(cnt == M-1) System.out.println("YES");
        else System.out.println("NO");
    }
}
