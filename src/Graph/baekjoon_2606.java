package Graph;

/**
 * 문제: 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
 *      1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 *
 * 큐를 사용해서 풀이
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2606 {
    static int N, M;
    static ArrayList <Integer> computer[];
    static int cnt; //감염된 컴퓨터 수
    static boolean [] isVisited;

    static void bfs(int idx) {
        Queue <Integer> que = new ArrayDeque<>();
        que.add(idx);
        isVisited[idx] = true;

        while(!que.isEmpty()) {
            int now = que.poll();

            for(int num : computer[now]) {
                if(!isVisited[num]) {
                    que.add(num);
                    isVisited[num] = true;
                    cnt += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  //컴퓨터 수
        M = Integer.parseInt(br.readLine());  //연결되어 있는 컴퓨터 쌍 수

        computer  = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            computer[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computer[a].add(b);
            computer[b].add(a);
        }

        isVisited = new boolean[N+1];

        bfs(1);

        System.out.println(cnt);
    }
}
