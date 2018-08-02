package com.leon.ch15;

import com.leon.utils.DataOper;
import org.junit.Test;

public class LcsLength
{
	private int[] xData = new int[] { 0, 1, 2, 3, 2, 4, 1, 2 };
	private int[] yData = new int[] { 0, 2, 4, 3, 1, 2, 1 };

	private int lcsLength(int[] x, int[] y)
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
					b[i][j] = 12;
				}
				else if (c[i - 1][j] >= c[i][j - 1])
				{
					c[i][j] = c[i - 1][j];
					b[i][j] = 11;
				}
				else
				{
					c[i][j] = c[i][j - 1];
					b[i][j] = 10;
				}
			}
		}
		DataOper.print(c);
		DataOper.print(b);
		return 0;
	}

	@Test
	public void testLcsLength()
	{
		lcsLength(this.xData, this.yData);
	}
}
