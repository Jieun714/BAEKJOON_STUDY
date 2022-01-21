package Graph;

import java.io.*;
import java.util.*;

//���� 3055�� ����ġ Ż�� ����
//BFS�� ���. �ʺ� �켱 Ž��
//������ ��� ��� ����ó�� �ʼ�
//���� �� ������ ĭ���� ����ġ�� �̵��� �� ���� == ���� ���� �̵���Ű�� ���� ����ġ�� �̵�.
class Point { // ��ġ�� �ľ��ϱ� ���� Ŭ���� ����
	int y;
	int x;
	char type;

	public Point(int y, int x, char type) {
		super();
		this.y = y;
		this.x = x;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Point [y=" + y + ", x=" + x + ", type=" + type + "]";
	}
}

public class baekjoon_3055 {
	static int R, C; // R:��, C:��
	static char[][] map; // ����ġ ��ġ ����
	static int[][] dp;
	static Queue<Point> queue = new LinkedList<>();; // BFS�� ����ϱ� ������ Queue�� ����
	static boolean foundAnswer; // ����Ʈ true //�̵� �� �� ���� �� ���ϱ� ���� ����
	static Point st;

	// ��, ��, ��, �Ʒ�
	static int[] MX = { -1, 1, 0, 0 };
	static int[] MY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); // ��
		C = sc.nextInt(); // ��

		map = new char[R][C]; // �Է¹��� ������ �ʱ�ȭ
		dp = new int[R][C]; // ���
		st = null;

		// �Է��� �ް� starting point�� ����
		for (int r = 0; r < R; r++) { // ��
			String line = sc.next();
			for (int c = 0; c < C; c++) { // ��
				map[r][c] = line.charAt(c); // �� �ڸ��� ���� ���� �迭�� ����

				if (map[r][c] == 'S') { // S�� ����ġ
					st = new Point(r, c, 'S');
				} else if (map[r][c] == '*') { // *�� ��� �ִ� ��
					queue.add(new Point(r, c, '*'));
				}
			}
		}
		
		queue.add(st); // starting point�� ���� ���ξ��ٰ� �������� ����

		while (!queue.isEmpty()) { // ť�� ������� ������
			// 1. ť���� ������
			Point p = queue.poll(); 
			// 2. �������ΰ�
			if (p.type == 'D') {  //���� �������� ����������
				System.out.println(dp[p.y][p.x]);
				foundAnswer = true; 
				break;
			}
			// 3. ����� ���� ��ȸ -> �¿����Ʒ�
			for (int i = 0; i < 4; i++) { //�¿����Ʒ��θ� �̵� �� �� �����Ƿ� ������ 4
				int tx = p.x + MX[i];
				int ty = p.y + MY[i]; 
				
				// 4. �� �� �ִ°�? (����)
				if (ty >= 0 && ty < R && tx >= 0 && tx < C) { //�Է¹��� ����� ���̸� ����� �ʵ���
					if (p.type == '.' || p.type == 'S') { // ����ġ�̰ų� ��� �ִٸ�
						if ((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
							// 5. üũ�� -> dp�� ����+1�� ���
							dp[ty][tx] = dp[p.y][p.x] + 1;
							// 6. ť�� ����
							queue.add(new Point(ty, tx, map[ty][tx]));
						}
					} else if (p.type == '*') { // 4. �� �� �ִ°�? (��) -> ���� ����� �ʰ�
						if (map[ty][tx] == '.' || map[ty][tx] == 'S') {
							// 5. üũ�� -> ������ * ǥ��
							map[ty][tx] = '*';
							// 6. ť�� ����
							queue.add(new Point(ty, tx, '*'));
						}
					}
				}
			}
		}
		if (foundAnswer == false) { // ���� ���ٸ�
			System.out.println("KAKTUS");
		}
	}
}
