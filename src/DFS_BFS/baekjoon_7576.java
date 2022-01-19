package DFS_BFS;

import java.util.*;
import java.io.*;

//백준 7576번 토마토
//BFS를 사용하여 토마토가 익는 날짜 계산
//아직은 헷갈림 //이해 필요
//https://coder-in-war.tistory.com/entry/BOJ-JAVA7576-%ED%86%A0%EB%A7%88%ED%86%A0 참고
public class baekjoon_7576 {
	public static int M, N;  //상자의 크기를 나타내는 정수 //M: 가로, N: 세로
	public static int[][] box;  //토마토가 담긴 상자
	public static int[] dx = { -1,  0, 1, 0 }; 
	public static int[] dy = { 0, -1, 0, 1 };

	static class Tomato {
		int x;
		int y;

		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로

		box = new int[N+1][M+1];

		for (int i = 1; i < N+1; i++) { 
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M+1; j++) { 
				box[i][j] = Integer.parseInt(st.nextToken()); //베열에 값을 담음
			}
		}
		bfs(box, N, M);
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				if(box[i][j] == 0) { //익지못하는 상황이면
					System.out.println(-1);  // -1 출력
					return;
				}
				max = Math.max(max, box[i][j]);
			}
		}
		System.out.print(max-1);
	}

	
	//1: 익은 토마토, 0: 익지않은 토마토, -1: 토마토가 들어 있지 않는 칸
	//출력은 토마토가 모두 익을 때까지의 최소 날짜, 처음부터 모든 토마토가 익어 있으면: 0, 모든 토마토가 익지 못하는 상황: -1
	public static void bfs(int[][] box, int N, int M) {
		Queue<Tomato> queue = new LinkedList<Tomato>();
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				if(box[i][j]==1) {  //만약 익은 토마토이면
					queue.offer(new Tomato(i,j));
				}
 			}
		}
		
		while(!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
				
				if(nx <= 00 || ny <= 0 || nx >= N+1 || ny >= M+1) continue;
				if(box[nx][ny] != 0) continue;
				
				box[nx][ny] = box[tomato.x][tomato.y] +1;
				queue.add(new Tomato(nx, ny));
			}
		}		
	}
}