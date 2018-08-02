package com.leon.ch15;

import com.leon.utils.DataOper;
import org.junit.Test;

public class LcsLength
{
	private int[] xData = new int[] { 0, 1, 2, 3, 2, 4, 1, 2 };
	private int[] yData = new int[] { 0, 2, 4, 3, 1, 2, 1 };

	private static final int LU = 12;
	private static final int U = 11;
	private static final int L = 10;

	private int[][] lcsLength(int[] x, int[] y)
	{
		int m = x.length - 1;
		int n = y.length - 1;
		int[][] b = new int[m + 1][n + 1];
		int[][] c = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++)
		{
			c[i][0] = 0;
		}
		for (int j = 0; j <= n; j++)
		{
			c[0][j] = 0;
		}

		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (x[i] == y[j])
				{
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = LU;
				}
				else if (c[i - 1][j] >= c[i][j - 1])
				{
					c[i][j] = c[i - 1][j];
					b[i][j] = U;
				}
				else
				{
					c[i][j] = c[i][j - 1];
					b[i][j] = L;
				}
			}
		}
		DataOper.print(c);
		DataOper.print(b);
		return b;
	}

	@Test
	public void testLcsLength()
	{
		int[][] b = lcsLength(this.xData, this.yData);
		printLcs(b, xData, xData.length - 1, yData.length - 1);
	}

	/**
	 * 逆向打印出序列，实际结果是正序
	 * @param b
	 * @param xData
	 * @param i
	 * @param j
	 */
	private void printLcs(int[][] b, int[] xData, int i, int j)
	{
		if (i == 0 || j == 0)
		{
			return;
		}
		if (b[i][j] == LU)
		{
			printLcs(b, xData, i - 1, j - 1);
			System.out.println(xData[i]);
		}
		else if (b[i][j] == U)
		{
			printLcs(b, xData, i - 1, j);
		}
		else
		{
			printLcs(b, xData, i, j - 1);
		}
	}
}
