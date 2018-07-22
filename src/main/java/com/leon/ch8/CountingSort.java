package com.leon.ch8;

import com.leon.utils.DataOper;
import org.junit.Test;

import javax.xml.crypto.Data;

public class CountingSort
{
	int[] A = new int[] { 2, 5, 3, 0, 2, 3, 0, 3 };

	void countingSort(int[] A, int[] B, int k)
	{
		int[] C = new int[k + 1];
		for (int i = 0; i < C.length; i++)
		{
			C[i] = 0;
		}
		for (int i = 0; i < A.length; i++)
		{
			C[A[i]]++;
		}

		//		DataOper.print(C);
		for (int i = 1; i < C.length; i++)
		{
			C[i] += C[i - 1];
		}
		for (int i = 0; i < C.length; i++)
		{
			// 因为书中的例子C 的下标从1开始，这里要全部扣除一次
			C[i]--;
		}
		//		DataOper.print(C);
		for (int i = A.length - 1; i >= 0; i--)
		{
			B[C[A[i]]] = A[i];
			C[A[i]]--;
		}
		//		DataOper.print(B);
	}

	@Test
	public void testCountingSort()
	{
		int[] B = new int[A.length];
		countingSort(A, B, 5);
		DataOper.print(A);
		DataOper.print(B);
	}
}
