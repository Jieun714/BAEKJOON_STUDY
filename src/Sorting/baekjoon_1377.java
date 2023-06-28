package Sorting;
/**
 * 문제: 주어지는 C++ 알고리즘을 참고.
 * 입력: 첫째 줄에 N이 주어진다. N은 500,000보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 A[1]부터 A[N]까지 하나씩 주어진다. A에 들어있는 수는 1,000,000보다 작거나 같은 자연수 또는 0이다.
 * 출력: 정답을 출력한다.
 * 해결: 그냥 사용하면 시간초과. 버블정렬
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Point implements Comparable<Point>{
    int value;
    int idx;

    public Point(int value, int idx){
        super();
        this.value = value;
        this.idx = idx;
    }
    @Override
    public int compareTo(Point o){
        return this.value - o.value;
    }
}

public class baekjoon_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N개의 수
        Point [] arr = new Point[N]; //N개의 수를 담은 배열
        for(int i=0; i<N; i++){
            arr[i] = new Point(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);
        int max = 0;
        for(int i=0; i<N; i++){
            if(max<arr[i].idx-i){ // (정렬 전 idx - 정렬 후 idx) 계산의 최댓값 저장
                max = arr[i].idx-i;
            }
        }
        System.out.println(max+1); //결과 출력
    }
}
