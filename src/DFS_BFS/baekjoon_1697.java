package DFS_BFS;

/**
 * 작성자: 이지은
 * 문제: 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 *      수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 *      수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *
 * BFS 이용
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1697 {
    static int N, K;
    static int [] time; //걸리는 시간
    static int newNow = 0;  //now가 0부터 시작

    static void find(int n) {
        Queue <Integer> que = new ArrayDeque<>();
        que.offer(n);

        while(!que.isEmpty()) {
            int now = que.poll();
            int [] arr = {now-1, now+1, now*2};

            if(now == K) return;  //수빈이 위치와 동생 위치가 동일할 때

            for(int a : arr) {
                newNow = a;
                if(newNow>=0 && newNow < 100001  && time[newNow] == 0) {
                    time[newNow] = time[now]+1;
                    que.offer(newNow);
                }
                if(newNow == K) break; //값 갱신 후 break;
            }
        } //while end
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());  //수빈이 위치
        K = Integer.parseInt(st.nextToken());  //동생 위치

        time = new int[100001];
        find(N);

        System.out.println(time[K]);
    }
}
