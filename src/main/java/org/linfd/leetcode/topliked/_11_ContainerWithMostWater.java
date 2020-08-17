package org.linfd.leetcode.topliked;

/**
 * #11 Container With Most Water
 *
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class _11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int ans = 0;
        int area;
        for(int i=0, j=height.length-1; i < j;){
            int length = j - i;
            if(height[i] < height[j]){
                area = height[i] * length;
                i ++;
            }else {
                area = height[j] * length;
                j --;
            }
            ans = Math.max(area, ans);
        }
        return ans;
    }
}