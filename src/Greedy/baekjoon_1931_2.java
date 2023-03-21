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
 * 정렬 후 변수를 이용해 풀이
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_1931_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //회의의 수
        int [][] arr = new int[N][2];
        int cnt = 0; //최대 회의의 수

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //배열 정렬
        Arrays.sort(arr, new Comparator<int []>() {
            @Override
            public int compare(int [] a, int [] b) {
                if(a[1] == b[1])
                    return a[0] -b[0];
                else
                    return a[1] - b[1];
                //삼항연산자 사용
//				return a[1]==b[1] ? a[0]-b[0]:a[1]-b[1];
            }
        });

        //람다식으로 표현
//		Arrays.sort(arr, (a,b) -> a[1]==b[1] ? a[0]-b[0]:a[1]-b[1]);

        int nowTime = 0;

        for(int i=0; i<N; i++) {
            if(nowTime <= arr[i][0]) {
                nowTime = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
