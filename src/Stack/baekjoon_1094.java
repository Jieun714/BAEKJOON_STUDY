package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 작성자: 이지은
 * 문제: N개의 막대기에 대한 높이 정보가 주어질 때, 오른쪽에서 보아서 몇 개가 보이는지를 알아내는 프로그램을 작성하려고 한다.
 * 입력: 첫 번째 줄에는 막대기의 개수를 나타내는 정수 N (2 ≤ N ≤ 100,000)이 주어지고
 *      이어지는 N줄 각각에는 막대기의 높이를 나타내는 정수 h(1 ≤ h ≤ 100,000)가 주어진다.
 * 출력: 오른쪽에서 N개의 막대기를 보았을 때, 보이는 막대기의 개수를 출력한다.
 * */

public class baekjoon_1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack <Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int cnt = 1;
        int peek = stack.pop(); //peek 제거

        while(!stack.isEmpty()) {
            int pop_value = stack.pop();

            if(pop_value>peek) {
                peek = pop_value;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
