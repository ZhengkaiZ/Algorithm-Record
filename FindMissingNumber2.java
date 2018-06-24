import java.util.*;
public class FindMissingNumber2 {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    private boolean flag = false;
    private int ans = 0;
    public int findMissing2(int n, String str) {
        // write your code here
        if (n < 1 || str == null) {
            return 1;
        }
        int length = str.length();
        if (length == 0) {
            return 1;
        }
        
        boolean[] record = new boolean[n + 1];
        backTracking(str, length, 0, record);
        return ans;
    }
    
    private void backTracking(String s,
                              int length,
                              int index,
                              boolean[] record) {
        if (index == length) {
            if (flag) {
                return;
            }
            for (int i = 1; i < record.length; i++) {
                if (record[i] == false) {
                    ans = i;
                }
            }
            flag = true;
        }
        
        for (int i = 1; i < 3; i++) {
            if (index + i <= length) {
                int temp = Integer.valueOf(s.substring(index, index + i));
                if (temp >= record.length) {
                    continue;
                }
                if (record[temp] == true) {
                    continue;
                } else {
                    record[temp] = true;
                }
                backTracking(s, length, index + i, record);
                record[temp] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        String s = "3456789101113141516171819201212";
        FindMissingNumber2 temp = new FindMissingNumber2();
        System.out.println(temp.findMissing2(21, s));
    }
}
