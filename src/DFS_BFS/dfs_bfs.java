package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*	백준 1260번 DFS와 BFS
	깊이우선과 너비우선 탐색 방법
	방문할 수 있는 정점기 여러개인 경우, 번호가 작은 것부터 방문하도록 함. 간선은 양방향
	DFS는 재귀함수 또는 스택
	BFS는 큐
*/
public class dfs_bfs {
	public static int N, M, V;
	public static int[][] arr; // 정점의 값을 담을 배열
	public static boolean[] check; // 방문한 노드인지 확인하는 배열
	public static StringBuilder sb = new StringBuilder();
	public static Stack<Integer> stack = new Stack<>(); // 스택선언
	public static Queue<Integer> queue = new LinkedList<Integer>(); //bfs 알고리즘을 위해 큐 생성

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // (탐색을 시작할)정점의 번호

		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1]; // 왜 배열의 크기가 정점 +1 인가

		for (int i = 0; i < M; i++) { // 간선의 갯수만큼 반복
			// 간선이 연결하는 두 정점의 번호를 입력
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 노드와 간선의 값 초기화
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dfs(V); // 탐색을 시작한 정점의 번호를 넣음.
//		System.out.println();
		sb.append("\n");
		check = new boolean[N+1];  //bfs를 위한 배열 재선언
		bfs(V);
		System.out.println(sb);
	}

	// 깊이우선 //재귀 사용(재귀가 스택보다 짧고, 빠름)
	public static void dfs(int idx) {
//		if (check[idx]) { // 방문한 적이 있을 시
//			return;
//		}
		check[idx] = true; // 시작노드 방문처리
//		System.out.print(idx + " ");

		sb.append(idx+" ");  //주석 풀어서 StringBuilder 사용 가능.
		for (int i = 1; i < N + 1; i++) { // 방문한 노드의 인접한 노드를 찾음
			if (arr[idx][i] == 1 && !check[i]) { // if (!check[i]) {
				dfs(i); // dfs를 수행
			}
		}
	}

	// 깊이우선 //스택 사용
	public static void dfs_stack(int idx) {
		stack.push(idx); // 시작노드를 넣어줌
		check[idx] = true; // 시작노드 방문처리

		while (!stack.isEmpty()) { // 스택이 비어 있지 않으면 계속 반복
			int val = stack.pop();
			System.out.print(val + " ");

			for (int i = 1; i < N + 1; i++) {
				if (arr[val][i] == 1 && !check[i]) { // if (!check[i]) {
					dfs_stack(i); // 반복
				}
			}
		}
	}

	// 너비우선 //큐 사용
	public static void bfs(int idx) { 
		queue.add(idx); //queue.offer(idx); // 처음 시작노드 추가
		check[idx] = true; // 처음 시작노드 방문처리

		while (!queue.isEmpty()) { //큐가 비지 않았을 때
			int val = queue.remove();  //queue.poll();
//			System.out.print(val + " ");
			sb.append(val+" ");
			
			for (int i = 1; i < N+1; i++) {
				if (arr[val][i] == 1 && !check[i]) { //해당하는 배열이 1이고, 방문하지 않았을 때
					queue.add(i);  //queue.offer(i);
					check[i] = true;
				}
			}
		}
	}
}
