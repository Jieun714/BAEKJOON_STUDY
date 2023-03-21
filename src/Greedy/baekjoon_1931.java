package Greedy;

/**
 * 작성자: 이지은
 * 문제: 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 *      단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 *      회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 *
 * 입력: 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
 *      둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 *      시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.
 * 출력: 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 *
 * Stack을 사용해서 풀이
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //회의의 수
        ArrayList <int []> meeting = new ArrayList<>(); //시작시간과 끝나는 시간을 담는 배열

        int cnt = 0; //최대 회의의 수

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meeting.add(new int[] {start, end});  //넣어줌
        }

        //배열 정렬
        Collections.sort(meeting, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])  //동일할 때 정렬 중요!!
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        Stack <Integer> stack = new Stack<>();
        stack.push(meeting.get(0)[1]);  //첫 번째 종료시간을 스택에 담아줌
        cnt++;
        for(int i=1; i<N; i++) {
            if(stack.peek() <= meeting.get(i)[0]) { //해당하면
                stack.pop();  //스택에서 빼주고
                stack.push(meeting.get(i)[1]); //새로운 종료시간 삽입
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
