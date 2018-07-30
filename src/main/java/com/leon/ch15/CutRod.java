package com.leon.ch15;

import org.junit.Test;

public class CutRod
{
	private int[] pData = new int[] { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 111, 115, 118, 119, 130, 170, 170, 200, 240, 300, 401, 405, 408, 409, 410, 417, 417, 420, 424, 430, 501, 505, 508, 509, 510, 517, 517, 520, 524, 530 };

	private int curRod(int[] p, int n)
	{
		if (n == 0)
		{
			return 0;
		}
		int q = 0 - Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++)
		{
			int tmp = p[i] + curRod(p, n - i);
			q = Math.max(q, tmp);
		}
		return q;
	}

	@Test
	public void testCutRod()
	{
		long time = System.currentTimeMillis();
		int q = curRod(this.pData, 35);
		long dtime = System.currentTimeMillis() - time;
		System.out.println(q + "  " + dtime);
	}
}
