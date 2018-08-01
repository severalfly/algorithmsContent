package com.leon.ch15;

import org.junit.Test;

public class FloorTimes
{
	private int floorTimes(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else if (n == 1)
		{
			return 1;
		}
		else if (n == 2)
		{
			return 2;
		}
		return floorTimes(n - 1) + floorTimes(n - 2);
	}

	@Test
	public void testFloorTime()
	{
		System.out.println(floorTimes(1));
		System.out.println(floorTimes(2));
		System.out.println(floorTimes(3));
		System.out.println(floorTimes(4));
		System.out.println(floorTimes(5));
		System.out.println(floorTimes(11));
	}
}
