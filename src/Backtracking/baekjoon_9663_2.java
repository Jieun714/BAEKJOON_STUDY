package Backtracking;

/**
 * 작성자: 이지은
 * 문제: N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 *      N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 *
 * 순열을 사용
 * */

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_9663_2 {
    static int N;
    static int [] chess;
    static int ans; //서로 공격할 수 없는 경우의 개수
    static boolean [] isVisited;

    // 새로운 퀸을 좌표에 배치할 경우 유효한 지 체크
    static boolean isCheck(int x, int y) {

        //다른 퀸들 chess[i]랑 비교
        for(int i=0; i<N; i++) {
            //자기 자신이거나 고르지 않은 퀸은 비교 제외
            if(y == i || chess[i] == -1) continue;
            //대각선에 걸리는 경우
            if(Math.abs(y-i)==Math.abs(x-chess[i])) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int cnt) {
        if(cnt >= N) {
            ans++;  //정답 체크
//			System.out.println(Arrays.toString(chess));
            return;
        }

        for(int i=0; i<N; i++) {
            if(isVisited[i]) continue;  //중복 방지
            if(!isCheck(i, cnt)) continue;

            //마킹
            isVisited[i] = true;
            chess[cnt] = i;

            dfs(cnt+1); //다음 경우의 수 탐색

            //마킹해제
            isVisited[i] = false;
            chess[cnt] = -1;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chess = new int[N];
        Arrays.fill(chess, -1);

        isVisited = new boolean[N];
        dfs(0);

        System.out.println(ans);

        sc.close();

    }
}
