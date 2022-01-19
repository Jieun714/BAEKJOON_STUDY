package step14;

import java.io.*;
import java.util.*;

//백준 2580번 스도쿠문제
//https://st-lab.tistory.com/119 참조
public class baekjoon_2580 {

	public static int[][] arr = new int[9][9]; // 9x9배열
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine()); // 9개 숫자 한줄씩
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); // 각 배열에 값을 넣음
			}
		}

		dfs(0, 0);
	}

	public static void dfs(int row, int col) { //
		if (col == 9) { // 열이 다 채워졌을 때
			dfs(row + 1, 0); // 다음 행으로
			return;
		}

		if (row == 9) { // 행이 다 끝났을 때
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j] + " "); // 한 칸씩 띄며 stringBuilder에 값 넣기
				}
				sb.append('\n'); // 한줄 띄기
			}
			System.out.println(sb); //출력
			System.exit(0); // 시스템 종료
		}

		if (arr[row][col] == 0) { //값이 없으면
			for (int i = 1; i <= 9; i++) {
				if (check(row, col, i)) {  //값을 검사애서 동일하지 않을 때
					arr[row][col] = i; //arr에 값 추가
					dfs(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		dfs(row, col + 1);
	}

	// 가로와 세로에서 같은 값이 존재하는 지 검사
	public static boolean check(int row, int col, int value) {
		for(int i=0; i<9; i++) {
			if(arr[row][i] == value) { //행에서 같은 값이 있으면 false
				return false;
			}
				 
			if(arr[i][col] == value) { //열에서 같은 값이 있으면 false
				return false;
			}
		}
		
		int nrow = (row/3)*3; //시작 x좌표
		int ncol = (col/3)*3; //시작 y좌표
		
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
