package step7;

import java.io.*;

//백준 11654 문자, 숫자를 입력 받아 아스키코드를 변환
public class asciiCode {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int asc = (int)br.readLine().charAt(0);  //입력과 동시에 아스키코드 값으로 변환
		
		// https://st-lab.tistory.com/59 참조. BufferedReader 를 사용하지 않고 바로 입력 받아서 값 출력
		//int asc = System.in.read();
		
		System.out.println(asc);
	}

}
