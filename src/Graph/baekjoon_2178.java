package day07;
/**
 * 문제: 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 *      이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 *      한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * BFS 사용
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2178 {
	static int N, M;
	static int [][] map;
	static int [] dx = {0, 0, -1, 1};
	static int [] dy = {1, -1, 0, 0};
	static boolean [][] isVisited;
	
	static void bfs(int x, int y) {
		Queue <int []> que = new ArrayDeque<>();
		que.offer(new int [] {x, y});
		isVisited[x][y] = true; //방문처리 
		
		while(!que.isEmpty()) {  //큐가 빌때까지 
			int [] now = que.poll();
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M) { //이동 가능한 칸일 동안
					if(map[nx][ny] == 1 && !isVisited[nx][ny]) {
						isVisited[nx][ny] = true; //방문처리 
						que.offer(new int [] {nx, ny});
						//다이나믹 프로그램 사용 
						map[nx][ny] = map[now[0]][now[1]] +1;  //카운트 업 
					}
				}
			}//4방탐색 for문 끝 
		} // while문 끝 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		isVisited = new boolean[N][M];
		
		bfs(0,0);
		
		System.out.println(map[N-1][M-1]); //(N, M)의 위치 값 출력 
	}
}
