package Backtracking;

/**
 * 작성자: 이지은
 * 문제: 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
 *      새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다.
 *      C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다. 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
 * 출력: 각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1759 {
    static int L, C;
    static String [] arr;
    static int [] select;
    static boolean [] isSelected;
    static ArrayList <String> str_lst;
    static String str;
    static int cnt;

    public static void combination(int r, int start) {
        if(r == L) {
            cnt = 0;
            str = "";
            for(int i=0; i<L; i++) {
                //모음조건
                if(arr[select[i]].equals("a")||arr[select[i]].equals("e")||arr[select[i]].equals("i")||arr[select[i]].equals("o")||arr[select[i]].equals("u")) {
                    str += arr[select[i]];
                    cnt++;
                }else {
                    str += arr[select[i]];
                }
            }

            if(cnt>L-2) return; //자음수가 2개 이상 안되는 경우
            if(str.length()==L) { //모음이 1개 이상 있는 경우
                if(cnt>0) str_lst.add(str);
                return;
            }
            return;
        }

        for(int i=start; i<C; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            select[r] = i;
            combination(r+1, i);
            isSelected[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        L = Integer.parseInt(st.nextToken());  //선택할 알파벳 수
        C = Integer.parseInt(st.nextToken());  //배열의 크기

        arr = new String[C];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);
        select = new int[L];
        isSelected = new boolean[C];

        str_lst = new ArrayList<>();

        combination(0,0);

        for(String str: str_lst) {
            System.out.println(str);
        }

    }
}
