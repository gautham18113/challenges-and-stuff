package core;

import core.datastructure.Coord;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static void swap(int idx1, int idx2, int[] arr) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
