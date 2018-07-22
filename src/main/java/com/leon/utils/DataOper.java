package com.leon.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class DataOper
{
	public static void swapInt(int[] A, int i, int j)
	{
		int a = A[i] ^ A[j];
		A[j] = a ^ A[j];
		A[i] = a ^ A[i];
	}

	@Test
	public void testSwap()
	{
		int[] A = new int[] { 1, 2, 3, 4 };
		swapInt(A, 0, 3);
		System.out.println(JSONObject.toJSONString(A));
	}
}
