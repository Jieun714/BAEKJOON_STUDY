package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2178번 미로찾기
//너비우선 탐색(BFS)
//1: 이동 가능한 칸, 0: 이동 불가능한 칸
public class baekjoon_2178 {
	static int N,M; //행, 열
	static int count = 0;
	static int[][] map; //미로 지도
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> queue = new LinkedList<>(); //bfs 알고리즘을 위해 큐 생성
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		check[0][0] = true;  //방문했다는 초기값
		bfs(0, 0);
		System.out.print(count);
	}
	
	static int bfs(int x, int y) { 
		queue.add(new int[] {x,y}); //queue.offer(idx); // 처음 시작노드 추가
//		check[x][y] = true; // 처음 시작노드 방문처리

		while (!queue.isEmpty()) { //큐가 비지 않았을 때
			int val[] = queue.poll();  //queue.poll();
			int nx = val[0];
			int ny = val[1];
			
			for (int i = 1; i <4; i++) {  //좌우상하로 이동하기 때문 4
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];
				
				if (nextX<0 || nextY<0 || nextX>=N || nextY>=M) {
					continue;
				}
				if(check[nextX][nextY] || map[nextX][nextY] == 0) {
					continue;
				}
				
				queue.add(new int[] {nextX, nextY});
				map[nextX][nextY] = map[nx][ny] +1;
				check[nextX][nextY] = true;
			}
			count++;
		}
		return count;
	}
}