package DFS_BFS;

/**
 * 작성자: 이지은
 * 문제: BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
 *      오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
 *      A는 B와 친구다. B는 C와 친구다. C는 D와 친구다. D는 E와 친구다. 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 *
 * 반례
 * 5 4
 * 0 1
 * 1 2
 * 2 3
 * 3 0
 * ans: 0
 *
 * DFS 깊이 사용
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_13023_2 {
    static int N, M;
    static ArrayList <Integer> arr[];
    static boolean [] isVisited;
    static int flag;

    static void DFS(int nowNode, int cnt) {
        if(isVisited[nowNode]) return;

        if(cnt >= 5 || flag == 1) {
            flag = 1;
            return;
        }

        isVisited[nowNode] = true;

        for(int nextNode : arr[nowNode]) {
            DFS(nextNode, cnt+1);
        }

        isVisited[nowNode] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];

        for(int i=0; i<N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i< M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        br.close();

        for(int i=0; i<N; i++) {
            isVisited = new boolean[N];
            DFS(i, 1);
        }

        System.out.println(flag);
    }
}
