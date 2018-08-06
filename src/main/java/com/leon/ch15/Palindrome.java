package com.leon.ch15;

import com.leon.utils.DataOper;
import org.junit.Test;

/**
 * 回文是正序与逆序相同的非空字符串，例如，所有长度为1的字符串, civic, racecar, aibohphobia 都是回文
 * 设计高效算法，求给定输入字符串的最长回文子序列，例如给定输入 chcaracter, 算法应该返回 carac。算法的运行时间是怎样的？
 *
 * 用一个辅助矩阵 w ，保存 [i,j] 上的最长回文子序列
 */
public class Palindrome
{
	//	private String str = "ara";
	private String str = "chcaracter";

	private void palindrome(String str)
	{
		int n = str.length();
		int[][] w = new int[n][n]; // 保存最长回文的数量
		int[][] root = new int[n][n]; // 保存最长回文的中点

		for (int i = 0; i < w.length; i++)
		{
			for (int j = 0; j < w[i].length; j++)
			{
				w[i][j] = 1;
			}
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
			}
		}
		DataOper.printMatrix(w);
	}

	@Test
	public void testPalindrome()
	{
		//		palindrome(this.str);
		int palindrome = palindrome(this.str, 0, str.length() - 1);
		System.out.println(palindrome);
	}

	private int palindrome(String str, int i, int j)
	{
		if (i == j)
		{
			return 1;
		}
		if (i > j)
		{
			return 0;
		}
		if (str.charAt(i) == str.charAt(j))
		{
			return palindrome(str, i + 1, j - 1) + 2;
		}
		return Math.max(palindrome(str, i, j - 1), palindrome(str, i + 1, j));
	}
}
