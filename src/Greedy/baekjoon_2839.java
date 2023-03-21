package Greedy;

/**
 * 작성자: 이지은
 * 문제: 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
 * 출력: 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 *
 * 그리디 알고리즘 사용
 * */

import java.util.Scanner;

public class baekjoon_2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //

        int cnt = 0; // 가져가는 설탕 봉지 갯수
        cnt = N/5;  //초기에 5로 나누어줌
        N %= 5;

        while(true) {
            if(cnt <0) break; //cnt가 작지면 while문 탈출

            if(N%3 == 0) { //나누어 떨어질 떄
                cnt += N/3;
                break;
            } else { //조건에 안 맞으면
                cnt -= 1;
                N = N+5; //N에 5키로를 추가
            }
        }
        System.out.println(cnt);
    }
}
