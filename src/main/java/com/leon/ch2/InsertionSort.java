package com.leon.ch2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class InsertionSort
{
	@Test
	public void testUp()
	{
		int[] arr = new int[] { 6, 1, 100, 4, 5, 3, 2 };
		for (int j = 1; j < arr.length; j++)
		{
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] > key)
			{
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = key;
		}
		System.out.println(JSONObject.toJSONString(arr));
	}

	@Test
	public void testDown()
	{
		int[] arr = new int[] { 1, 10, 100, 4, 5, 3, 2 };
		for (int j = 1; j < arr.length; j++)
		{
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] < key)
			{
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = key;
		}
		System.out.println(JSONObject.toJSONString(arr));
	}
}
