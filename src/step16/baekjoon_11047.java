package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11047번 동전
// 그리디 알고리즘: 선택에서 가장 좋은 선택을 찾음
public class baekjoon_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 동전의 종류
		int K = Integer.parseInt(st.nextToken()); // 가치의 합
		int[] arr = new int[N]; // 가치의 오름차순을 담을 배열
		int count = 0; // 동전 갯수

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 가치 정렬
		}

		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] <= K) { // 배열의 값이 K보다 작거나 같다면
				count += (K / arr[i]); // 몫
				K = K % arr[i]; // 나머지. if문의 K가 나머지가 되는 거임
			}
		}
		System.out.print(count);
	}
}
