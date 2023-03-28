package Greedy;

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
    static ArrayList <Meet> list;
    static PriorityQueue <Integer> que;
    static int N, max;

    static void check(int num){
        if(num == N-1) return;
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
