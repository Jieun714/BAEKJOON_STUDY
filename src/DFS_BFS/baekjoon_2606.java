package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2606번 바이러스
//전체를 다 돌기 때문에, BFS와 DFS로 품
public class baekjoon_2606 {
	public static int N, M; // 컴퓨터 수와 컴퓨토 쌍 수
	public static int count; // 바이러스에 걸리게 되는 컴퓨터의 수
	public static int[][] arr; // 방문
	public static boolean[] check; // 방문했는 지 체크하는 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍 수

		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1]; // 왜 배열의 크기가 정점 +1 인가

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		dfs(1); // 1번 컴퓨터에서 시작
		System.out.println(count);

		bfs(1);
		System.out.println(count);
	}

	public static int dfs(int idx) {
		check[idx] = true;
		for (int i = 1; i < N + 1; i++) {
			if (arr[idx][i] == 1 && !check[i]) { // if (!check[i]) {
				count++; // 바이러스가 걸린(방문한) 컴퓨터 수
				dfs(i); // dfs를 수행
			}
		}
		return count;
	}

	//BFS. 너비우선 //큐 사용
	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx); // 처음 시작노드 추가
		
		while (!queue.isEmpty()) { // 큐가 비지 않았을 때
			idx = queue.poll();
			check[idx] = true; // 처음 시작노드 방문처리

			for (int i = 1; i < N + 1; i++) {
				if (arr[idx][i] == 1 && !check[i]) { // 해당하는 배열이 1이고, 방문하지 않았을 때
					queue.add(i); // 처음 시작노드 추가
					check[i] = true; // 처음 시작노드 방문처리
					count++;
				}
			}
		}
	}
}
