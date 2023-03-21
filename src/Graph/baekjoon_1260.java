package Graph;

/**
 * 작성자: 이지은
 * 문제: 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 *      단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 *      정점 번호는 1번부터 N번까지이다.
 * 출력: 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
 *
 * DFS: 재귀 사용
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_1260 {
    static int N, M, V;
    static ArrayList <Integer> graph[];
    static StringBuilder sb = new StringBuilder();
    static boolean [] isCheck;  //방문체크할 배열

    // DFS 재귀 사용시
    static void dfs(int idx) {
        isCheck[idx] = true;  //방문처리
        sb.append(idx+ " ");

        for(int now : graph[idx]) {
            //방문하지 않고, 간선이 존재할 때
            if(!isCheck[now]) dfs(now);
        }
    }

    //DFS 스택 사용
//	static void dfs(int idx) {
//		Stack <Integer> stack = new Stack<>();
//		stack.push(idx);
//
//		while(!stack.isEmpty()) {
//			int nowIdx = stack.pop();
//
//			if(isCheck[nowIdx] == false) {
//				sb.append(nowIdx+" ");
//				isCheck[nowIdx] = true;
//			}
//
//			for(int now: graph[nowIdx]) {
//				if(isCheck[now] == true) continue;
//				stack.push(now);
//			}
//		}
//	}

    //BFS 큐 사용
    static void bfs(int idx) {
        Queue <Integer> que = new ArrayDeque<>(); //큐 선언
        que.add(idx);
        isCheck[idx] = true; //방문처리

        while(!que.isEmpty()) { //큐가 빌때까지
            int nowIdx = que.poll();
            sb.append(nowIdx+" ");
            for(int now : graph[nowIdx]) {
                if(!isCheck[now]) {
                    que.add(now);
                    isCheck[now] = true;
                }
            }
        } //while 종료
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //간선 개수
        V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호

        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //양방향 표시
            graph[a].add(b);
            graph[b].add(a);
        }

        //오름차순 정렬
        for (int i=0; i<N+1; i++) Collections.sort(graph[i]);

        // 스택 사용의 경우 내림차순 정렬
//		for (int i=0; i<N+1; i++) Collections.sort(graph[i], Collections.reverseOrder());

        isCheck = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        for (int i=0; i<N+1; i++) Collections.sort(graph[i]);

        isCheck = new boolean[N+1]; //초기화
        bfs(V);
        System.out.println(sb);

    }
}
