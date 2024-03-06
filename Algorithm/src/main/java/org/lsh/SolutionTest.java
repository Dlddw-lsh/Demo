package org.lsh;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SolutionTest {

    @Test
    public void solve() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        new Stack<>().peek().var
        System.out.println(lowerBound(list, 7));
        System.out.println(minLengthAfterRemovals(list));
    }

    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int x = nums.get(n / 2);
        int maxCnt = lowerBound(nums, x + 1) - lowerBound(nums, x);
        return Math.max(maxCnt * 2 - n, n % 2);
    }

    // 开区间写法
    private int lowerBound(List<Integer> nums, int target) {
        int left = -1, right = nums.size();
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (nums.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
