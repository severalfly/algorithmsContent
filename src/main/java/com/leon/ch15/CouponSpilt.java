package com.leon.ch15;

import org.junit.Test;

/**
 *
 */
public class CouponSpilt
{
	// 这里300 为最大订单金额，可以扩展到很大很大
	private static int[] pData = new int[3000];

	static
	{
		// 存在哪些面值的优惠券，对应设置为对应值就可以
		//		pData[9] = 9;
		//		pData[99] = 99;
		pData[199] = 199;
		pData[299] = 299;
		pData[399] = 399;
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
		int n = 1993;
		SAndR sAndR = extendBottomUpCutRod(pData, n);

		//		System.out.println(JSONObject.toJSONString(sAndR.getR()));
		//		System.out.println(JSONObject.toJSONString(sAndR.getS()));
		while (n > 0)
		{
			System.out.println(sAndR.getS()[n]);
			n = n - sAndR.getS()[n];
		}
	}

}

