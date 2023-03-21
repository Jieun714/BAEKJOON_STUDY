package 구현;

/**
 * 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다.
 * 		둘째 줄에는 정수가 공백으로 구분되어져있다.
 *      셋째 줄에는 찾으려고 하는 정수 v(-100 ≤ v ≤ 100)가 주어진다.
 * 출력: 첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10807 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //Integer로 캐스팅
        //default 공백, " " 같은 거 지정가능
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int [] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());  //쪼개서 받을 수 있음.
        }

        int V = Integer.parseInt(br.readLine()); //배열의 값과 비교할 V 입력
        int cnt = 0; //동일한 값의 개수

        for(int a: arr) {
            if(a == V) { //배열의 값과 입력받은 값이 동일할 때
                cnt++;
            }
        }
        System.out.println(cnt); //결과 출력
    }
}
