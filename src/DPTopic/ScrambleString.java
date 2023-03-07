package DPTopic;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    // Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
    //
    //Below is one possible representation of s1 = "great":
    //
    //            great
    //
    //             /    \
    //
    //           gr    eat
    //
    //          / \      /  \
    //
    //         g   r  e   at
    //
    //                      / \
    //
    //                    a   t
    //
    //To scramble the string, we may choose any non-leaf node and swap its two children. For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
    //
    //                  rgeat
    //
    //                   /    \
    //
    //                rg    eat
    //
    //               / \      /  \
    //
    //             r   g   e   at
    //
    //                     / \
    //
    //                   a   t
    //
    //  We say that "rgeat" is a scrambled string of "great". Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
    //
    //              rgtae
    //
    //              /    \
    //
    //            rg    tae
    //
    //           / \    /  \
    //
    //          r   g  ta  e
    //
    //                  / \
    //
    //                 t   a
    //
    // We say that "rgtae" is a scrambled string of "great". Given two strings s1 and s2,
    // determine if s2 is a scrambled string of s1.

    // 大概思路就是，首先排除几种情况，一种是长度不同，一种是包含每个字母的个数不同。排除之后就直接分块，一块是左边的一块是右边的，把s1和s2左右分开然后做dfs，
    // 类似于之前找bst。如果只切一个就会stack overflow，所以必须两个都切

    public boolean isScramble(String s1, String s2) {
        if(s1 == null && s2 == null){
            return true;
        }
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }

        int[][][] helper = new int[s1.length()][s2.length()][s1.length() + 1];
        return findAll(s1, s2, helper, 0, 0, s1.length());
    }
    private boolean findAll(String s1, String s2, int[][][] helper, int i1, int i2, int length){
        if(helper[i1][i2][length] != 0){
            return helper[i1][i2][length] == 1;
        }
        if(s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))){
            helper[i1][i2][length] = 1;
            return true;
        }

        if(! valid(s1, s2, i1, i2, length)){
            helper[i1][i2][length] = -1;
            return false;
        }

        for(int i = 1; i < length; i++){
            if(findAll(s1, s2, helper, i1, i2, i) && findAll(s1, s2, helper, i1 + i, i2 + i, length - i)){
                helper[i1][i2][length] = 1;
                return true;
            }
            if(findAll(s1, s2, helper, i1, i2 + length - i, i) && findAll(s1, s2, helper, i1 + i, i2, length - i)){
                helper[i1][i2][length] = 1;
                return true;
            }
        }

        helper[i1][i2][length] = -1;
        return false;
    }
    private boolean valid(String s1, String s2, int i1, int i2, int length){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = i1; i < i1 + length; i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for(int i = i2; i < i2 + length; i++){
            if(! map.containsKey(s2.charAt(i))){
                return false;
            }

            if(map.get(s2.charAt(i)) == 0){
                return false;
            }

            map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
        }
        return true;
    }
}
