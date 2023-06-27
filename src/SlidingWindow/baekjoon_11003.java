package SlidingWindow;
/**
 * 문제: N개의 수 A1, A2, ..., AN과 L이 주어진다.
 *      Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
 * 입력: 첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000) 둘째 줄에는 N개의 수 Ai가 주어진다. (-10^9 ≤ Ai ≤ 10^9)
 * 출력: 첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
 * 해결: 슬라이딩 윈도우. 책 풀이 참고
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수의 개수
        int L = Integer.parseInt(st.nextToken()); //범위 지정
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올 때마다 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            while(!deque.isEmpty() && deque.getLast().value > now){
                deque.removeLast();
            }
            deque.addLast(new Node(now, i)); //덱에 값 삽입
            if(deque.getFirst().idx<=i-L){ //범위에서 벗어난 값은 덱에서 제거
                deque.removeFirst();
            }
            sb.append(deque.getFirst().value).append(" "); //최소값을 sb에 담음
        }
        System.out.println(sb); //결과 출력
    }
    static class Node{
        public int value;
        public int idx;

        Node(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
}
