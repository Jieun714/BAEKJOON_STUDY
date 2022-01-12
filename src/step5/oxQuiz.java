package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 8958번 OX Quiz
// https://st-lab.tistory.com/50 에서 StringBuilder 참조
public class oxQuiz {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(br.readLine()); // 형변환
		String[] arr = new String[N]; // N만큼 배열 생성
		
		for (int i = 0; i < N; i++) { // 배열에 데이터 삽입
			arr[i] = br.readLine();
		}

		// 점수 계산
		for (int i = 0; i < arr.length; i++) {	
			//num과 sum을 for문 밖에 선언 할 경우 sum이 누적되는 문제가 발생함
			int num = 0; // 점수
			int sum = 0; // 총합
			
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'O') { //각각의 자리의 문자를 비교
					num++;	//값을 누적
				} else {
					num = 0; //0으로 초기화
				}
				sum += num;
			}
			System.out.println(sum); //평균 출력
			//sb.append(sum).append('\n'); //개행
		}
		//System.out.println(sb); // StringBuilder를 사용하여 평균 출력
	}
}
