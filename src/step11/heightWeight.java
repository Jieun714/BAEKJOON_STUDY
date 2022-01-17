package step11;

import java.io.*;
import java.util.*;

//백준 7568번 덩치
//2치원 배열을 사용하여, 몸무게와 키를 저장 후 비교
public class heightWeight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 전체 사람 수

		int[][] arr = new int[n][2]; // 몸무게와 키만 입력 받기 때문에 열의 길이를 2로 줌

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int rank = 1; 

			for (int j = 0; j < n; j++) {
				if (i == j) //i와 j랑 같으면 같은 배열을 가리키기 때문에 생략
					continue;
				//arr[x][0]는 몸무게 비교, arr[y][0]는 키 비교
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++; 
				}
			}
			
			System.out.print(rank+" "); //랭크 출력(공백문자로 분리되게)
		}
	}
}
