package Sorting;

/**
 * 작성자:이지은
 * 문제: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
 *      이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 출력: 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 작성일: 2023-03-13
 *
 * partition과 quickSort 메소드 생성. 재귀호출 사용.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2750_퀵정렬 {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //배열의 left부터 right까지 pivot을 기주으로 나누고 최종 pivot위치 반환
    public static int partition(int[] arr, int start, int end) {
        int pivot = start;
        int left = start+1;
        int right = end;

        //엇갈리지 않았을 동안
        while(left<right) {
            while(left<=right && arr[left]<=arr[pivot]) left++;
            while(left<=right && arr[right]>=arr[pivot]) right--;

            if(left>right) swap(arr, right, pivot); //엇갈린 경우
            else swap(arr, left, right);
        }
        return right;
    }

    public static void quickSort(int[] arr, int start, int end) {
        //재귀 종료 조건
        if(start>=end) return;

        int pivot = partition(arr, start, end);

        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //퀵 정렬
        quickSort(arr, 0, N-1);

        for(int a: arr) {
            System.out.println(a);
        }
    }
}
