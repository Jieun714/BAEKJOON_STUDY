package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1546번 평균
public class avgGrade {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 형변환
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N]; // N만큼 배열 생성

		for (int i = 0; i < N; i++) { // 배열에 데이터 삽입
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = arr[0]; //최고점수
		double sum = 0; //합
		double avg = 0; //평균
		double result = 0; //새로운 평균
		
		for (int value : arr) { //최대값 구하기
			if (value > max) { 
				max = value;
			}
		}
		
		for(int value : arr) {
			avg = (double) value/max*100; //각각의 점수에 대한 평균
			sum += avg; //avg 값을 더함
		}
		
		result = (double)sum/N; //새로운 평균

		System.out.println(result); //평균 출력
	}
}
