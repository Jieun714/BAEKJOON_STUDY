package Sorting;
/**
 * 문제: 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 * 입력: 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 * 출력: 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 * 해결: sort, 선택정렬 사용
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class baekjoon_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine(); //정렬하려는 수
        Integer [] arr =  new Integer[N.length()];
        for(int i=0; i<N.length(); i++){
            arr[i] = N.charAt(i)-'0';
        }
        // 1. sort 사용
//        Arrays.sort(arr, Collections.reverseOrder());

        // 2. 선택 정렬 사용
        for(int i=0; i<arr.length; i++){
            int max = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]>arr[max]){ //내림차순이므로 최댓값을 찾음
                     max = j;
                }
            }
            //swap
            if(arr[i]<arr[max]){
                int num = arr[i];
                arr[i] = arr[max];
                arr[max] = num;
            }
        }
        //결과 출력
        for(int num: arr) {
            System.out.print(num);
        }
    }
}
