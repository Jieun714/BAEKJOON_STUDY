package Greedy;

/**
 * 작성자: 이지은
 * 문제: N개의 스위치와 N개의 전구가 있다. 각각의 전구는 켜져 있는 상태와 꺼져 있는 상태 중 하나의 상태를 가진다. i(1 < i < N)번 스위치를 누르면 i-1, i, i+1의 세 개의 전구의 상태가 바뀐다.
 *      즉, 꺼져 있는 전구는 켜지고, 켜져 있는 전구는 꺼지게 된다. 1번 스위치를 눌렀을 경우에는 1, 2번 전구의 상태가 바뀌고, N번 스위치를 눌렀을 경우에는 N-1, N번 전구의 상태가 바뀐다.
 *      N개의 전구들의 현재 상태와 우리가 만들고자 하는 상태가 주어졌을 때, 그 상태를 만들기 위해 스위치를 최소 몇 번 누르면 되는지 알아내는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 자연수 N(2 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 전구들의 현재 상태를 나타내는 숫자 N개가 공백 없이 주어진다.
 *      그 다음 줄에는 우리가 만들고자 하는 전구들의 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 0은 켜져 있는 상태, 1은 꺼져 있는 상태를 의미한다.
 * 출력: 첫째 줄에 답을 출력한다. 불가능한 경우에는 -1을 출력한다.
 * 해결: 그리디 알고리즘 사용
 * 참고: 시간초과를 해결하지 못해서 https://settembre.tistory.com/476 참조
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon_2138 {
    static int N; //전구 갯수
    static List<Integer> [] list; //전구 상태를 담은 리스트
    static int cnt = Integer.MAX_VALUE; //스위치 누른 횟수

    public static void push(int idx, int type){
        for(int i=idx-1; i<=idx+1; i++){
            if(i>=0 && i<N){
                if(list[type].get(i) == 1) {
                    list[type].set(i, 0);
                }else {
                    list[type].set(i, 1);
                }
            }
        }
    }

    public static void go(int idx, int type, int result){
        if(idx==N){ //종료조건
            if(list[type].get(idx-1) == list[1].get(idx-1)){
                cnt = Math.min(cnt, result);
            }
            return;
        }
        if(list[type].get(idx-1) != list[1].get(idx-1)){
            push(idx, type);
            go(idx+1, type, result+1);
        } else{
            go(idx+1, type, result);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[3];
        for(int i=0; i<3; i++) list[i] = new ArrayList<>();
        for(int i=0; i<2; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                list[i].add(str.charAt(j)-'0'); //리스트에 전구 상태 삽입
            }
        } //for end

        for(int i=0; i<N; i++){ //현재 상태 전구 카피
            list[2].add(list[0].get(i));
        }

        // 0번 스위치를 안눌렀을 때
        go(1, 0, 0);

        // 0번 스위치를 눌렀을 때
        push(0, 2);
        go(1,2, 1);

        if(cnt==Integer.MAX_VALUE) cnt = -1;
        System.out.println(cnt);
    }

}
