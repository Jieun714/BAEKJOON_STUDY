package Greedy;

/**
 * 문제: N개의 강의가 있다. 우리는 모든 강의의 시작하는 시간과 끝나는 시간을 알고 있다. 이때, 우리는 최대한 적은 수의 강의실을 사용하여 모든 강의가 이루어지게 하고 싶다.
 *      물론, 한 강의실에서는 동시에 2개 이상의 강의를 진행할 수 없고, 한 강의의 종료시간과 다른 강의의 시작시간이 겹치는 것은 상관없다. 필요한 최소 강의실의 수를 출력하는 프로그램을 작성하시오.
 *
 * 알고리즘: 우선순위 큐 사용. 그리디 알고리즘
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1374 {
    public static class Meet{
        int num, start, end;
        Meet(int num, int start, int end){
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }
    static List<Meet> list;
    static PriorityQueue<Integer> que;
    static int N, max;

    static void check(int num){
        if(num == N) return;
        //큐가 비지않으면서 que의 peek()보다 idx num에 해당하는 시작시간이 클 경우
        while(!que.isEmpty() && que.peek() <= list.get(num).start){
            que.poll();
        }

        que.add(list.get(num).end); //끝나는 시간을 우선순위 큐에 삽입
        max = Math.max(max, que.size());

        check(num+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        //초기화
        list = new ArrayList<>();
        que = new PriorityQueue<>();
        max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());  //강의 번호
            int start = Integer.parseInt(st.nextToken());  //강의 시작 시간
            int end = Integer.parseInt(st.nextToken());  //강의 종료 시간

            list.add(new Meet(num, start, end));
        }

        Collections.sort(list, new Comparator<Meet>() {
            @Override
            public int compare(Meet o1, Meet o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        check(0);

        System.out.println(max);
     }
}
