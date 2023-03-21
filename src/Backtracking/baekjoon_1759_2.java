package Backtracking;

/**
 * 작성자: 이지은
 * 문제: 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
 *      새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다.
 *      C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다. 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
 * 출력: 각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다.
 *
 * Arrays.asList에 모음을 담아 비교
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1759_2 {
    static int L;
    static int C;
    static char [] arr;

    static StringBuilder builder;
    static boolean [] isSelected;

    static ArrayList <Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u'));

    static boolean checkValid(StringBuilder builder) {

        int cnt_c = 0;
        int cnt_v = 0;

        char [] password = builder.toString().toCharArray();
        for(char c : password) {
            if(vowels.contains(c))
                cnt_v += 1;
            else
                cnt_c += 1;

            if(cnt_c >=2 && cnt_v >= 1 ) return true;
        }
        return false;

    }

    static void combination(int r , int start) {

        if(r == L) {
            if(checkValid(builder))
                System.out.println(builder.toString());
            return;
        }

        for(int i=start; i<C; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            builder.append(arr[i]);
            combination(r+1 , i);
            isSelected[i] = false;
            builder.deleteCharAt(builder.length()-1);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
        L = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(bf.readLine() , " ");
        arr = new char [C];
        for(int i=0; i<C; i++) arr[i] = token.nextToken().charAt(0);

        // 초기화 //
        builder = new StringBuilder();
        isSelected = new boolean [C];

        // arr 배열 정렬 => 사전순으로 표현하기 순열을 표현하기 위함
        Arrays.sort(arr);

        // 조합 이용
        combination(0,0);
    }
}
