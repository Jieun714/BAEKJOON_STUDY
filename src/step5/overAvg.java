package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 4344번 평균 구하기
//평균 점수 이상인 학생들의 비율 구하기
public class overAvg {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());  //토큰 사용
		
		int C = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		
		for (int i = 0; i < C; i++) { // 테스트 케이스 수 만큼 반복
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //학생 수 
			int[] arr = new int[N]; //학생 수만큼 배열
			
			int count = 0;  //평균 넘는 학생 카운트  //for문 밖에 선언시 %가 더해짐
			double avg = 0; //평균 점수
			double overAvg = 0; //평균을 넘는 학생 비율
			
			for (int j = 0; j < N; j++) { //학생 수 만큼 반볻
				int score = Integer.parseInt(st.nextToken()); //점수 입력 받음
				arr[j] = score;
				avg += score;
			}
			avg = (avg/N);  //평균 구하기
			 
			for (int k = 0; k < arr.length; k++) { //배열 안에 있는 값
				if(arr[k] > avg) {  //평균 값과 비교해서 평균 넘는 학생 수 세기
					count++;
				}
			}
			
			overAvg = (double) count/N*100; //(double) 사용안하면 계산이 제대로 안됨! 필수
			System.out.printf("%.3f",overAvg);  //학생 수 평균 출력 (소수 셋째자리)
			System.out.println("%"); //출력 예제에서 %까지 출력
		}
	}
}
