package DFS_BFS;

import java.util.*;
import java.io.*;

//���� 7576�� �丶��
//BFS�� ����Ͽ� �丶�䰡 �ʹ� ��¥ ���
//������ �򰥸� //���� �ʿ�
//https://coder-in-war.tistory.com/entry/BOJ-JAVA7576-%ED%86%A0%EB%A7%88%ED%86%A0 ����
public class baekjoon_7576 {
	public static int M, N;  //������ ũ�⸦ ��Ÿ���� ���� //M: ����, N: ����
	public static int[][] box;  //�丶�䰡 ��� ����
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

		M = Integer.parseInt(st.nextToken()); //����
		N = Integer.parseInt(st.nextToken()); //����

		box = new int[N+1][M+1];

		for (int i = 1; i < N+1; i++) { 
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M+1; j++) { 
				box[i][j] = Integer.parseInt(st.nextToken()); //������ ���� ����
			}
		}
		bfs(box, N, M);
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				if(box[i][j] == 0) { //�������ϴ� ��Ȳ�̸�
					System.out.println(-1);  // -1 ���
					return;
				}
				max = Math.max(max, box[i][j]);
			}
		}
		System.out.print(max-1);
	}

	
	//1: ���� �丶��, 0: �������� �丶��, -1: �丶�䰡 ��� ���� �ʴ� ĭ
	//����� �丶�䰡 ��� ���� �������� �ּ� ��¥, ó������ ��� �丶�䰡 �;� ������: 0, ��� �丶�䰡 ���� ���ϴ� ��Ȳ: -1
	public static void bfs(int[][] box, int N, int M) {
		Queue<Tomato> queue = new LinkedList<Tomato>();
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				if(box[i][j]==1) {  //���� ���� �丶���̸�
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