package exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class dp {
	public static int LCS(String query, String test) {
        int i,j,max = 0,temp1,temp2;
        int len1 = query.length();
        int len2 = test.length();
        int[] dp = new int[len2+1];
        if(len1 == 0 || len2 == 0) return 0;
        for(i = 0; i < len1; i++)
        {
        	temp1 = 0;
        	for(j = 0; j < len2; j++)
        	{
        		if(query.charAt(i) == test.charAt(j))
        		{
        			temp2 = dp[j+1];
        			dp[j+1] = temp1+1;
        			temp1 = temp2;
        			if(dp[j+1] > max) max = dp[j+1];
        		}
        		else
        		{
        			temp1 = dp[j+1];
        			dp[j+1] = 0;
        		}
        	}
        }
        return max;
    }
	public static int LCSubsequence(String s1, String s2)
	{
		int len1 = s1.length(), len2 = s2.length();
		int[] temp = new int[len2+1];
		int temp1,temp2;
		for(int i = 1; i <= len1; ++i)
		{
			temp1 = 0;
			for(int j = 1; j <= len2; ++j)
			{
				temp2 = temp[j];
				if(s1.charAt(i-1) == s2.charAt(j-1))
					temp[j] = temp1 + 1;
				else
					temp[j] = Math.max(temp[j-1], temp[j]);
				temp1 = temp2;
			}
		}
		return temp[len2];
	}
	public static int longestIncrease(String s)
	{
		int len = s.length();
		int[] temp = new int[len];
		int maxmum = 1;
		for(int i = 0; i < len; ++i)
			temp[i] = 1;
		for(int i = 1; i < len; ++i)
		{
			for(int j = 0; j < i; ++j)
			{
				if(s.charAt(i) >= s.charAt(j))
				{
					temp[i] = Math.max(temp[i], temp[j] + 1);
				    maxmum = Math.max(temp[i], maxmum);
				}
			}
		}
		return maxmum;
	}
	public static int bagOneTwo(int[] weight, int[] value, int N)
	{
		if(weight.length != value.length)
			return -1;
		int[] temp = new int[N+1];
		for(int i = 0; i < weight.length; ++i)
		{
			for(int j = N; j > 0; --j)
			{
				if(weight[i] <= j)
				{
					temp[j] = Math.max(temp[j], temp[j-weight[i]]+value[i]);
				}
			}
		}
		return temp[N];
	}
	//正好填满背包
	public static int bagFull(int[] weight, int[] value, int N)
	{
		if(weight.length != value.length)
			return -1;
		int[] temp = new int[N+1];
		temp[0] = 0;
		for(int i = 1; i <= N; ++i)
			temp[i] = -1;
		for(int i = 0; i < weight.length; ++i)
		{
			for(int j = N; j > 0; --j)
			{
				if(weight[i] <= j && temp[j-weight[i]] >= 0)
				{
					temp[j] = Math.max(temp[j], temp[j-weight[i]]+value[i]);
				}
			}
		}
		return temp[N];
	}
	//非01背包可以转化为01背包来解
	//triangle
	public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if(len == 0) return 0;
        if(len == 1) return triangle.get(0).get(0);
        int[] array = new int[len];
        for(int i = 0; i < len; i++)
           array[i] = triangle.get(len-1).get(i);
        for(int i = len-1; i > 0; i--)
        {
            for(int j = 0; j < i; j++)
               array[j] = Math.min(array[j], array[j + 1]) + triangle.get(i-1).get(j);
        }
        return array[0];
    }
	//Maximum subarray
	public static int maxSubArray(int[] A) {
        int len = A.length;
        if(len == 0) return 0;
        if(len == 1) return A[0];
        int result = Integer.MIN_VALUE;
        int f = 0;
        for(int i = 0; i < len; i++)
        {
           f = Math.max(A[i], f+A[i]);
           result = Math.max(f, result);
        }
        return result;
    }
	//Palindrome Partitioning 2
	public static int minCut(String s) {
        int len = s.length();
        if(len < 2) return 0;
        boolean[][] flag = new boolean[len][len];
        int[] f = new int[len+1];
        for(int i = 0; i <= len; i++)
           f[i] = len - 1 - i;
        for(int i = len-1; i >= 0; i--)
           for(int j = i; j < len; j++)
           {
               if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || flag[i+1][j-1]))
               {
                   flag[i][j] = true;
                   f[i] = Math.min(f[i], f[j+1]+1);
               }
           }
        return f[0];
    }
	//Maximal Rectangle
    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int[] area = new int[row];
        int result = 0;
        for(int i = 0; i < row; i++)
        {
            area[i] = matrix[i][0] - '0'; 
        }
        result = Math.max(result, largestRectangleArea(area));
        if(matrix[0].length > 1)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                for(int i = 0; i < row; i++)
                {
                    if(matrix[i][j] == '1')
                       area[i]++;
                    else
                       area[i] = 0;
                }
                result = Math.max(result, largestRectangleArea(area));
            }
        }
        return result;
    }
    private static int largestRectangleArea(int[] height) {
        if(height.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        for(int i = 0; i < height.length;)
        {
            if(stack.empty() || height[i] > height[stack.peek()])
               stack.push(i++);
            else
            {
                int temp = stack.pop();
                result = Math.max(result, height[temp] * (stack.empty() ? i : (i - stack.peek() - 1)));
            }
        }
        while(!stack.empty()) 
        {
            int temp = stack.pop();
            result = Math.max(result, height[temp] * (stack.empty() ? height.length : (height.length - stack.peek() - 1)));
        }
        return result;
    }
    //Best time to buy and sell 3
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int[] result1 = new int[len];
        int[] result2 = new int[len];
        int small = prices[0];
        int temp = Integer.MIN_VALUE;
        for(int i = 1; i < len; i++)
        {
            if(temp < prices[i] - small)
                temp = prices[i] - small;
            result1[i] = temp;
            small = Math.min(small, prices[i]);
        }
        if(len < 4)
          return temp > 0 ? temp:0;
        temp = Integer.MIN_VALUE;
        int large = prices[len-1];
        for(int i = len-2; i >= 0; i--)
        {
            if(temp < large - prices[i])
                temp = large - prices[i];
            result2[i] = temp;
            large = Math.max(large, prices[i]);
        }
        temp = 0;
        for(int i = 0; i < len; i++)
        {
            if(result1[i] > 0 && i+1 < len && result2[i+1] > 0)
            {
                if(result1[i] + result2[i+1] > temp)
                   temp = result1[i] + result2[i+1];
            }
            else if(result1[i] > 0)
            {
                if(result1[i]> temp)
                   temp = result1[i];
            }
            else if(i+1 < len && result2[i+1] > 0)
            {
                if(result2[i+1]> temp)
                   temp = result2[i+1];
            }
        }
        return temp;
    }
    //Interleaving String
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
           return false;
        if(s1.length() < s2.length())
           return isInterleave(s2, s1, s3);
        boolean[] f = new boolean[s2.length() + 1];
        for(int i = 0; i <= s2.length(); i++)
        {
            f[i] = true;
        }
        for(int i = 1; i <= s2.length(); i++)
        {
            f[i] = (s2.charAt(i-1) == s3.charAt(i-1)) && f[i-1];
        }
        for(int i = 1; i <= s1.length(); i++)
        {
            f[0] = s1.charAt(i-1) == s3.charAt(i-1) && f[0];
            for(int j = 1; j <= s2.length(); j++)
            {
                f[j] = (s1.charAt(i-1) == s3.charAt(i + j - 1) && f[j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && f[j-1]);
            }
        }
        return f[s2.length()];
    }
    //Minimum path sum
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int[] array = new int[n];
        array[0] = grid[0][0];
        for(int j = 1; j < n; j++)
           array[j] = grid[0][j] + array[j-1];
        for(int i = 1; i < m; i++)
        {
            array[0] = array[0] + grid[i][0];
            for(int j = 1; j < n; j++)
              array[j] = Math.min(array[j-1], array[j]) + grid[i][j];
        }
        return array[n-1];
    }
    //Edit distance
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0 || n == 0) return Math.max(m, n);
        int[] distance = new int[m+1];
        int upper_left,upper,temp;
        for(int i = 0; i <= m; ++i)
            distance[i] = i;
        for(int j = 1; j <= n; ++j)
        {
            upper_left = j-1;
            for(int i = 1; i <= m; ++i)
            {
                upper = distance[i];
                distance[0] = j;
                if(word1.charAt(i-1) == word2.charAt(j-1))
                   distance[i] = upper_left;
                else
                {
                    temp = Math.min(distance[i-1],distance[i]);
                    temp = Math.min(temp, upper_left);
                    distance[i] = temp + 1;
                }
                upper_left = upper;
            }
        }
        return distance[m];
    }
    //Climing stairs
    public static int climbStairs(int n) {
        int cur = 1;
        int pre = 1;
        int temp;
        for(int i = 1; i < n; i++)
        {
            temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }
	public static void main(String[] args)
    {
    	String s1 = "dfhdsjf";
    	String s2 = "fsdfjsfkll";
    	System.out.println(dp.longestIncrease(s2));
    	System.out.println("---------------01bag------------");
    	int[] weight = {2,3,5,7,19,34,4};
    	int[] value = {4,3,2,4,5,24,32};
    	System.out.println(dp.bagFull(weight, value, 20));
    }
}
