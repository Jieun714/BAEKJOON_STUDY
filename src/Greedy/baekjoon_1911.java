package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //물웅덩이 개수
        int L = Integer.parseInt(st.nextToken()); //물웅덩이를 덮을 수 있는 길이
        ArrayList<long []> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new long[] {Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())});
        }
        Collections.sort(list, Comparator.comparingLong(o -> o[0])); //웅덩이의 시작 위치를 기준으로 정렬

        long now = list.get(0)[0]; //웅덩이의 시작 위치
        int cnt = 0; //널빤지 개수
        for(long [] l : list) {
            while(now < l[1]) { //현재 널빤지 위치가 웅덩이 끝 위치보다 작을 동안
                if(l[0]<now) now += L; //현재 널빤지 위치가 웅덩이 시작 위치보다 클 때
                else now = l[0] + L; //현재 널빤지 위치가 웅덩이 시작 위치보다 작을 때
                cnt++;
            }
        }
        System.out.println(cnt); //결과 출력
    }
}