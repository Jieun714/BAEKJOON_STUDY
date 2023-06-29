package Sorting;
/**
 * 문제: 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다. 둘째에는 A1, A2, ..., AN이 주어진다. (-10^9 ≤ Ai ≤ 10^9)
 * 출력: A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.
 * 해결: sort, 퀵정렬 사용
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_11004 {
    public static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //N개의 수
        K = Integer.parseInt(st.nextToken()); //오름차순으로 지정했을 때 인덱스
        int [] arr = new int[N]; //N개의 수를 담는 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1. sort 사용. 시간이 오래 걸림
        //Arrays.sort(arr);

        // 2. 퀵 정렬. 시간 단축
        quickSort(arr, 0, N-1);

        System.out.println(arr[K-1]);
    }

    public static void quickSort(int [] arr, int start, int end){
        if(start<end){
            int pivot = partition(arr, start, end);
            if(pivot==K-1)
                return;
            else if(K-1 < pivot)
                quickSort(arr, start, pivot-1);
            else
                quickSort(arr, pivot+1, end);
        } //if end
    }

    public static int partition(int [] arr, int start, int end){
        if(start+1 == end){
            if(arr[start] > arr[end])
                swap(arr, start, end);
            return end;
        }
        int mid = (start+end)/2; //중간 값을 1번쨰 요소로 이동
        swap(arr, start, mid); //중간 값과 변경
        int pivot = arr[start];
        int i = start+1;
        int j = end;

        while(i<=j){
            while(pivot < arr[j] && j > 0){ //피벗보다 작은 수가 나올 때까지
                j--;
            }
            while(pivot > arr[i] && i <N-1){ //피벗보다 큰 수가 나올 때까지
                i++;
            }
            if(i<=j){
                swap(arr, i++, j--);
            }
        }
        //i==j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    //swap 함수 선언
    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}