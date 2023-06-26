package TwoPointer;
/**
 * 문제: N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
 *      N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라. 수의 위치가 다르면 값이 같아도 다른 수이다.
 *      야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다. 이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)
 * 출력: 좋은 수의 개수를 첫 번째 줄에 출력한다.
 * 헤결: 투 포인트 사용
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //수의 개수
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0; //좋은 수 개수
        Collections.sort(list); //정렬
        for(int i=0; i<N; i++){
            int M = list.get(i); //어떤 수
            int start = 0;
            int end = N-1;
            while(start<end){
                int sum = list.get(start) + list.get(end);
                if(sum<M) { //합이 작으면
                    start++;
                } else if (sum>M) { //합이 클 때
                    end--;
                } else {
                    //start와 end이 서로 다른 두 수인지 체크
                    if(start != i && end != i){
                        cnt++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                }
            } //while end
        } //for end
        System.out.println(cnt);  //결과 출력
    }
}
