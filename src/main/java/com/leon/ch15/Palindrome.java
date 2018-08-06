package com.leon.ch15;

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
	private String str = "adhfoaefhadklfjaopidhfalasdqwey";

	private int[][] palindrome(String str)
	{
		int n = str.length();
		int[][] w = new int[n][n]; // 保存最长回文的数量
		int[][] root = new int[n][n]; // 保存最长回文的中点

		for (int i = 0; i < w.length; i++)
		{
			w[i][i] = 1;
		}

		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j + i < n; j++)
			{
				int tmp = 0;
				if (str.charAt(j + i) == str.charAt(j))
				{
					tmp = w[j + 1][j + i - 1] + 2;
				}
				else
				{
					tmp = Math.max(w[j + 1][j + i], w[j][j + i - 1]);
				}
				w[j][j + i] = tmp;
			}
		}
		//		DataOper.printMatrix(w);
		return w;
	}

	@Test
	public void testPalindrome()
	{
		System.out.println(this.str.length());
		long now = System.currentTimeMillis();
		int[][] w = palindrome(this.str);
		int length = w[0][w.length - 1];
		int i = 0;
		int j = w.length - 1;
		for (; i < w.length; i++)
		{
			if (w[i][w.length - 1] != length)
			{
				break;
			}
		}
		i--;
		for (; j >= 0; j--)
		{
			if (w[0][j] != length)
			{
				break;
			}
		}
		j++;
		//		System.out.println(i + " " + j);
		String subStr = str.substring(i, j + 1);
		System.out.println(subStr.length());

		System.out.println(System.currentTimeMillis() - now);
	}

	@Test
	public void testPalindromeReverse()
	{
		System.out.println(this.str.length());
		long now = System.currentTimeMillis();
		int palindrome = palindrome(this.str, 0, str.length() - 1);
		System.out.println(palindrome);
		System.out.println(System.currentTimeMillis() - now);
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
