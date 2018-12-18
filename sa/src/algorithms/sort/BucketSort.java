package algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        String data = "aasdfb34ddF9AaSdfF";
        sort(data);
    }

    public static void sort(String data) {
        //存放大写字母
        List<Character> bucket1 = new ArrayList<Character>();
        //存放小写字母
        List<Character> bucket2 = new ArrayList<Character>();
        //存放数字
        List<Character> bucket3 = new ArrayList<Character>();

        for (int i = 0; i < data.length(); i++) {
            char value = data.charAt(i);
            if (value >= 48 && data.charAt(i) <= 57) {
                bucket3.add(value);
            } else if (value >= 65 && value <= 90) {
                bucket1.add(value);
            } else {
                bucket2.add(value);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char value : bucket1) {
            sb.append(value);
        }

        for (char value : bucket2) {
            sb.append(value);
        }

        for (char value : bucket3) {
            sb.append(value);
        }
        System.out.println(sb.toString());
    }
}
