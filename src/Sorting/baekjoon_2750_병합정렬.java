package Sorting;

/**
 * 작성자:이지은
 * 문제: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
 *      이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 출력: 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 작성일: 2023-03-13
 *
 * 병합정렬 - 분할과 병합. 재귀호출 사용.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_2750_병합정렬 {

    public static void mergeSort(int[] arr, int[] temp, int start, int end) {
//		for(int i = start; i<end; i++) System.out.print(arr[i] +" ");
//		System.out.println();

        if(start>=end) return; //재귀 종료 조건
        int mid = (start+end)/2;

        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid+1, end);

        // 분할이 끝나고 나서 병합코드  //
        int left = start;
        int right = mid+1;
        int idx = start;

        //아직 배열을 채울 수 있는 값이 남아있는 경우
        while(left<= mid || right <= end) {
            //인덱스를 이동하면서 인덱스가 가리키는 값에 최소값을 넣어줌
            if(left>mid) { //left를 다 사용했다는 의
                temp[idx++] = arr[right++];
            }
            else if(right > end) {
                temp[idx++] = arr[left++];
            }
            else if(arr[left]> arr[right]) {
                temp[idx++] = arr[right++];
            }
            else if(arr[right]>arr[left]) {
                temp[idx++] = arr[left++];
            }
        }

        //temp에 값을 덮어 씌어주는 작업
        for(int i=start; i<end+1; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) throws IOException{
//		int [] arr = {5, 2, 8, 6, 4, 7, 3, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //퀵 정렬
        mergeSort(arr, temp, 0, arr.length-1);

        for(int a: arr) {
            System.out.println(a);
        }
    }
}
