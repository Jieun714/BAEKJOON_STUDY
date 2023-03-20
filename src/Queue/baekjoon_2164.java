package day02;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 작성자: 이지은
 * 문제: N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.
 * 출력: 첫째 줄에 남게 되는 카드의 번호를 출력한다.
 * */
public class B2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue <Integer> que = new ArrayDeque<>();
		
		for(int i=1; i<N+1; i++) {
			que.add(i); //큐에 1~N을 넣어줌
		}
		
		int front = que.poll(); //맨 위의 값을 제거
		while(!que.isEmpty()) { //카드가 하나가 남을 때까지
			front = que.poll(); //다음의 카드
			que.add(front); //맨 위의 카드를 다시 넣어줌
			que.poll(); //맨 위의 값을 제거
		}
		
		System.out.println(front); //출력
	}
}
