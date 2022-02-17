package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1541
//그리드 알고리즘을 사용하여 풀이. 
public class baekjoon_1541 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;  //전체 합
		StringTokenizer sub = new StringTokenizer(br.readLine(),"-"); //"-"가 있는 곳을 기준으로 나눔
		
		while(sub.hasMoreTokens()) { 
			int num = 0;
			
			StringTokenizer add = new StringTokenizer(sub.nextToken(),"+"); //"-"로 나눈 토큰에서 +가 있는 부분을 찾음
			
			while(add.hasMoreTokens()) { //"+"로 나눈 토큰을 반복
				num += Integer.parseInt(add.nextToken()); //각 토큰을 더해줌 
			}
			
			if(sum == 0) { //sum의 값이 0이면
				sum += num;  //sum의 값에 num의 값을 더함
			}else {
				sum -= num;  //빼줌
			}
		}
		System.out.println(sum);
	}
}
