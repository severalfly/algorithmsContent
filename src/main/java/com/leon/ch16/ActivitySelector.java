package com.leon.ch16;

import org.junit.Test;

public class ActivitySelector
{
	private int[] s = new int[] { 0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
	private int[] f = new int[] { 0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16 };

	private int recursiveActivitySelector(int[] s, int[] f, int k, int n)
	{
		int m = k + 1;
		while (m <= n && s[m] < f[k])
		{
			m++;
		}
		if (m <= n)
		{
			System.out.println(s[m] + " " + f[m]);
			return recursiveActivitySelector(s, f, m, n);
		}
		return 0;
	}

	@Test
	public void testRecursiveActivitySelector()
	{
		recursiveActivitySelector(this.s, this.f, 0, s.length - 1);
		greedyActivitySelector(this.s, this.f);
	}

	private void greedyActivitySelector(int[] s, int[] f)
	{
		int n = s.length;
		System.out.println(s[1] + " " + f[1]);
		int k = 1;
		for (int i = 2; i < n; i++)
		{
			if (s[i] >= f[k])
			{
				System.out.println(s[i] + " " + f[i]);
				k = i;
			}
		}
	}
}
