package BFS;

import java.util.*;

public class SuperUglyNumber {
    // Write a program to find the nth super ugly number.
    //
    //Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
    // For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first
    // 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

    //所谓的丑数就是指primes自己之间互相乘以及和衍生出来的乘积再次互相乘。所以要记录互相乘的时候走到了哪里，让弹出来的prime[i]依次从小到大
    //乘以所有的丑数即可。
    public static void main(String[] args) {
        SuperUglyNumber test = new SuperUglyNumber();
        int[] array = new int[]{3,5,7,11,13,17,19,23,41,43,47,53,59,67,71,73,89,97,101,103,127,139,149,151,173,179,181,191,193,197,199,211,223,227,229,239,251,257,271,277,281,283,331,337,353,359,373,379,383,389,397,401,419,439,443,463,467,479,509,521,541,547,557,563,569,577,587,601,617,619,643,647,659,673,677,691,709,733,743,751,757,773,787,797,829,839,857,859,863,877,881,907,911,919,929,937,947,971,983,997};
        test.nthSuperUglyNumber(4368, array);
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < m; i++) {
            q.add(new int[]{primes[i], i, 0});
        }
        int[] ans = new int[n];
        ans[0] = 1;
        for (int j = 1; j < n; ) {
            int[] poll = q.poll();
            int val = poll[0], i = poll[1], idx = poll[2];
            if (val != ans[j - 1]) {
                ans[j++] = val;
            }
            q.add(new int[]{ans[idx + 1] * primes[i], i, idx + 1});
        }
        return ans[n - 1];
    }

}
