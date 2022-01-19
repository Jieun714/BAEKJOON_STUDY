package step14;

import java.io.*;
import java.util.*;

//���� 2580�� ��������
//https://st-lab.tistory.com/119 ����
public class baekjoon_2580 {

	public static int[][] arr = new int[9][9]; // 9x9�迭
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine()); // 9�� ���� ���پ�
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); // �� �迭�� ���� ����
			}
		}

		dfs(0, 0);
	}

	public static void dfs(int row, int col) { //
		if (col == 9) { // ���� �� ä������ ��
			dfs(row + 1, 0); // ���� ������
			return;
		}

		if (row == 9) { // ���� �� ������ ��
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j] + " "); // �� ĭ�� ��� stringBuilder�� �� �ֱ�
				}
				sb.append('\n'); // ���� ���
			}
			System.out.println(sb); //���
			System.exit(0); // �ý��� ����
		}

		if (arr[row][col] == 0) { //���� ������
			for (int i = 1; i <= 9; i++) {
				if (check(row, col, i)) {  //���� �˻�ּ� �������� ���� ��
					arr[row][col] = i; //arr�� �� �߰�
					dfs(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		dfs(row, col + 1);
	}

	// ���ο� ���ο��� ���� ���� �����ϴ� �� �˻�
	public static boolean check(int row, int col, int value) {
		for(int i=0; i<9; i++) {
			if(arr[row][i] == value) { //�࿡�� ���� ���� ������ false
				return false;
			}
				 
			if(arr[i][col] == value) { //������ ���� ���� ������ false
				return false;
			}
		}
		
		int nrow = (row/3)*3; //���� x��ǥ
		int ncol = (col/3)*3; //���� y��ǥ
		
		for(int j= nrow; j<nrow+3; j++) {
			for(int k= ncol; k<ncol+3; k++) {
				if(arr[j][k] == value) {
					return false;
				}
			}
		}
		return true;
	}
}
