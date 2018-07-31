package com.leon.ch15;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
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
		int q = curRod(this.pData, 30);
		long dtime = System.currentTimeMillis() - time;
		System.out.println(q + "  " + dtime);
	}

	@Test
	public void testMemoizedCutRod()
	{
		long time = System.currentTimeMillis();
		int q = memoizedCutRod(pData, 40);
		long dtime = System.currentTimeMillis() - time;
		System.out.println(q + "  " + dtime);
	}

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
		int q = bottomUpCutRod(pData, 30);
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
		SAndR sAndR = extendBottomUpCutRod(pData, 30);
		System.out.println(JSONObject.toJSONString(sAndR));
	}

}

@Setter
@Getter
class SAndR
{
	private int[] r;
	private int[] s;

	public SAndR(int[] r, int[] s)
	{
		this.r = r;
		this.s = s;
	}
}
