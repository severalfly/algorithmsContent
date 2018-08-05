package com.leon.ch15;

public class OptimalBst
{
	private void optimalBst(int[] p, int[] q, int n)
	{
		int[][] e = new int[n + 2][n + 1];
		int[][] w = new int[n + 2][n + 1];
		int[][] root = new int[n + 1][n + 1];
		for (int i = 1; i <= n + 1; i++)
		{
			e[i][i - 1] = q[i - 1];
			w[i][i - 1] = q[i - 1];
		}
	}
}
