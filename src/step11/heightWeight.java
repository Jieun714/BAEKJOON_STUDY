package step11;

import java.io.*;
import java.util.*;

//���� 7568�� ��ġ
//2ġ�� �迭�� ����Ͽ�, �����Կ� Ű�� ���� �� ��
public class heightWeight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // ��ü ��� ��

		int[][] arr = new int[n][2]; // �����Կ� Ű�� �Է� �ޱ� ������ ���� ���̸� 2�� ��

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int rank = 1; 

			for (int j = 0; j < n; j++) {
				if (i == j) //i�� j�� ������ ���� �迭�� ����Ű�� ������ ����
					continue;
				//arr[x][0]�� ������ ��, arr[y][0]�� Ű ��
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++; 
				}
			}
			
			System.out.print(rank+" "); //��ũ ���(���鹮�ڷ� �и��ǰ�)
		}
	}
}
