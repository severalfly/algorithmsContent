package com.leon.ch15;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 *
 */
public class CouponSpilt
{
	private static int[] pData = new int[3000];

	static
	{
		//		pData[9] = 9;
		//		pData[99] = 99;
		pData[199] = 199;
		pData[299] = 299;
		pData[399] = 399;
	}

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

	//	@Test
	//	public void testCutRod()
	//	{
	//		long time = System.currentTimeMillis();
	//		int q = curRod(this.pData, 1000);
	//		long dtime = System.currentTimeMillis() - time;
	//		System.out.println(q + "  " + dtime);
	//	}
	//
	//	@Test
	//	public void testMemoizedCutRod()
	//	{
	//		long time = System.currentTimeMillis();
	//		int q = memoizedCutRod(pData, 1000);
	//		long dtime = System.currentTimeMillis() - time;
	//		System.out.println(q + "  " + dtime);
	//	}

	private int memoizedCutRod(int[] p, int n)
	{
		int[] r = new int[n + 1];
		for (int i = 0; i <= n; i++)
		{
			r[i] = 0 - Integer.MAX_VALUE;
		}
		return memoizedCutRodAux(p, n, r);
	}

	private int memoizedCutRodAux(int[] p, int n, int[] r)
	{
		if (r[n] >= 0)
		{
			return r[n];
		}
		int q = 0 - Integer.MAX_VALUE;
		if (n == 0)
		{
			q = 0;
		}
		else
		{
			for (int i = 1; i <= n; i++)
			{
				int tmp = p[i] + memoizedCutRodAux(p, n - i, r);
				q = Math.max(q, tmp);
			}
		}
		r[n] = q;
		return q;
	}

	@Test
	public void testBottomUpCutRod()
	{
		long time = System.currentTimeMillis();
		int q = bottomUpCutRod(pData, 1000);
		long dtime = System.currentTimeMillis() - time;
		System.out.println(q + "  " + dtime);
	}

	private int bottomUpCutRod(int[] p, int n)
	{
		int[] r = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
		{
			r[i] = 0;
		}
		for (int j = 1; j <= n; j++)
		{
			int q = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++)
			{
				q = Math.max(q, p[i] + r[j - i]);
			}
			r[j] = q;
		}
		return r[n];
	}

	private SAndR extendBottomUpCutRod(int[] p, int n)
	{
		int[] r = new int[n + 1];
		int[] s = new int[n + 1];
		for (int i = 0; i <= n; i++)
		{
			r[i] = 0;
		}
		for (int j = 1; j <= n; j++)
		{
			int q = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++)
			{
				if (q < p[i] + r[j - i])
				{
					q = p[i] + r[j - i];
					s[j] = i;
				}
			}
			r[j] = q;
		}
		return new SAndR(r, s);
	}

	@Test
	public void testExtendBottomUpCutRod()
	{
		int n = 1000;
		SAndR sAndR = extendBottomUpCutRod(pData, n);

		System.out.println(JSONObject.toJSONString(sAndR));
		while (n > 0)
		{
			System.out.println(sAndR.getS()[n]);
			n = n - sAndR.getS()[n];
		}
	}

}

