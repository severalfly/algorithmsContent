package com.leon.ch15;

import org.junit.Test;

public class OptimalBst
{
	private int[] pData = new int[] { 0, 15, 10, 5, 10, 20 };
	private int[] qData = new int[] { 5, 10, 5, 5, 5, 10 };

	private void optimalBst(int[] p, int[] q, int n)
	{
		int[][] e = new int[n + 1][n];
		int[][] w = new int[n + 1][n];
		int[][] root = new int[n][n];
		for (int i = 1; i < n + 1; i++)
		{
			e[i][i - 1] = q[i - 1];
			w[i][i - 1] = q[i - 1];
		}
		for (int l = 1; l <= n + 1; l++)
		{
			for (int i = 1; i <= n - l; i++)
			{
				int j = i + l - 1;
				e[i][j] = Integer.MAX_VALUE;
				w[i][j] = w[i][j - 1] + p[i] + q[i];
				for (int r = i; r <= j; r++)
				{
					int t = e[i][r - 1] + e[r + 1][j] + w[i][j];
					if (t < e[i][j])
					{
						e[i][j] = t;
						root[i][j] = r;
					}
				}
			}
		}
		printMatrix(e);
		System.out.println();
		System.out.println();
		printMatrix(root);
	}

	@Test
	public void testOptimalBst()
	{
		optimalBst(this.pData, this.qData, 6);
	}

	private void printMatrix(int[][] data)
	{
		int n = data.length;
		for (int i = 0; i < n; i++)
		{
			int l = data[i].length;
			for (int j = 0; j < l; j++)
			{
				System.out.print(data[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	@Test
	public void testPrintMatrix()
	{
		int[][] data = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		printMatrix(data);
	}
}
