package Sorting;
/**
 * 문제: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 출력: 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 해결: 병행정렬 사용
 * */

import java.io.*;

public class baekjoon_2751 {
    public static int [] arr, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N개의 수
        arr = new int[N+1];
        temp = new int[N+1]; //정렬할 때 잠시 사용할 임시 배열 선언
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N); //병합 정렬 수행
        //결과 출력하기
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(arr[i]+"\n");
        }
        System.out.println(sb);
    }

    //병합 정렬 함수
    public static void mergeSort(int s, int e){
        if(e-s < 1) return; //종료 조건
        int m = s+(e-s)/2; //중간점

        //재귀함수
        mergeSort(s, m);
        mergeSort(m+1, e);
        for (int i=s; i<=e; i++){
            temp[i] = arr[i];
        }
        int k = s;
        int idx1 = s;
        int idx2 = m+1;
        //두 그룹을 병합
        while(idx1 <= m && idx2 <= e){
            //양쪽 그룹의 인덱스가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장
            //선택된 데이터의 인덱스 값을 오른쪽으로 한칸 이동
            if(temp[idx1] > temp[idx2]){
                arr[k] = temp[idx2];
                k++;
                idx2++;
            } else {
                arr[k] = temp[idx1];
                k++;
                idx1++;
            }
        } //while end

        //한쪽 그룹이 모두 선택한 후 남아 있는 값 정리
        while(idx1 <= m){
            arr[k] = temp[idx1];
            k++;
            idx1++;
        }
        while(idx2 <= e){
            arr[k] = temp[idx2];
            k++;
            idx2++;
        }

    }
}