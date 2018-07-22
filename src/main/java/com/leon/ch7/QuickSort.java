package com.leon.ch7;

import com.alibaba.fastjson.JSONObject;
import com.leon.utils.DataOper;
import org.junit.Test;

public class QuickSort
{
	private int[] A = new int[] { 2, 8, 7, 1, 3, 5, 6, 4 };

	private int partition(int[] A, int p, int r)
	{
		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++)
		{
			if (A[j] <= x)
			{
				i++;
				DataOper.swapInt(A, i, j);
			}
		}
		DataOper.swapInt(A, i + 1, r);
		return i + 1;
	}

	@Test
	public void testPartition()
	{
		int partition = partition(A, 0, 2);
		System.out.println(partition);
		System.out.println(JSONObject.toJSONString(A));
	}

	private void quickSort(int[] A, int p, int r)
	{
		if (p < r)
		{
			int partition = partition(A, p, r);
			quickSort(A, p, partition - 1);
			quickSort(A, partition + 1, r);

		}
	}

	@Test
	public void testQuickSort()
	{
		quickSort(A, 0, A.length - 1);
		DataOper.print(A);
	}
}
