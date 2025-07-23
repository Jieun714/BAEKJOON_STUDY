package Greedy;
/**
 * 문제: 수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
 *      김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
 *      참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
 *      수강신청 대충한 게 찔리면, 선생님을 도와드리자!
 * 입력: 첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000) 이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 10^9)
 * 출력: 강의실의 개수를 출력하라.
 * 해결: 정렬 + 우선순위 큐
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //수업 개수
        List<int []> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b}); //수업 시작 시간과 종료 시간 저장
        }
        list.sort(Comparator.comparingInt(o -> o[0])); //수업 시작 시간 기준으로 정렬

        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); //종료 시간 기준으로 정렬
        for(int i=0; i<N; i++) {
            int [] now = list.get(i);
            int flag = 0;
            if(!pq.isEmpty()) { //우선순위 큐에 수업이 있으면, 가장 빨리 끝나는 수업과 비교
                int [] schedule = pq.peek();
                if(schedule[1] <= now[0]) { //현재 수업 시작 시간이 이전 수업 종료 시간 이후면 같은 강의실 사용 가능
                    pq.poll(); //이전 수업을 큐에서 제거
                    if(schedule[2] == 0) answer += 1; //새로운 강의실 배정이었던 경우 카운트 증가
                    flag = 1; //재사용된 강의실임을 표시
                }
            }
            pq.add(new int[]{now[0], now[1], flag}); //현재 수업을 큐에 삽입 [시작, 종료, 새로운 강의실 사용 여부]
        }

        //큐에 남아있는 수업들 중 새 강의실이 필요한 경우 세기
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[2] == 0) answer++;
        }

        System.out.println(answer); //결과 출력
    }
}
