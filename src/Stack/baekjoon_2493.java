package Stack;

/**
 * 작성자: 이지은
 * 문제: 탑들의 개수 N과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라.
 * 입력: 첫째 줄에 탑의 수를 나타내는 정수 N이 주어진다. N은 1 이상 500,000 이하이다.
 *      둘째 줄에는 N개의 탑들의 높이가 직선상에 놓인 순서대로 하나의 빈칸을 사이에 두고 주어진다. 탑들의 높이는 (1 ≤ n ≤ 100,000,000) 정수이다.
 * 출력: 첫째 줄에 주어진 탑들의 순서대로 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호를 하나의 빈칸을 사이에 두고 출력한다.
 *      만약 레이저 신호를 수신하는 탑이 존재하지 않으면 0을 출력한다.
 *
 * stack에 탑에 높이를 담는 것이 아닌 탑의 idx번호 담음
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack<Integer> stack = new Stack<>(); // 입력으로 받은 스택
        Stack<Integer> idx = new Stack<>(); // 현재 위치를 담을 스택

        StringBuilder builder = new StringBuilder();
        int peek;

        for (int i = 1; i < N+1; i++) {
            int height = Integer.parseInt(st.nextToken()); // 입력 받음

            while (true) {
                if (!stack.isEmpty()) {
                    peek = stack.peek();

                    if (height < peek) { //가장 먼저 만나는 탑일 때
                        builder.append(idx.peek() + " ");
                        stack.push(height); //입력 받은 값 담음
                        idx.push(i); // 현재 위치를 담음
                        break;
                    } else {
                        stack.pop();
                        idx.pop();
                    }
                } else { // 스택이 비었을 때
                    builder.append(0 + " "); //수신하는 탑이 없을 때
                    stack.push(height); //입력 받은 값 담음
                    idx.push(i); //현재 위치를 담음
                    break; //while 종료
                }
            }
        }
        System.out.println(builder);

    }
}
