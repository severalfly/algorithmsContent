package com.leon.ch9;

import com.leon.utils.DataOper;
import org.junit.Test;

import java.util.Random;

public class RandomSelected
{
	private int[] A = new int[] { 2, 8, 7, 1, 3, 5, 6, 4, 11, 5 };

	private int randomSelect(int[] A, int p, int r, int i)
	{
		if (p == r)
		{
			return A[p];
		}
		int q = randomPartition(A, p, r);
		int k = q - p + 1;
		if (i == k)
		{
			return A[p];
		}
		else if (i < k)
		{
			return randomSelect(A, p, q - 1, i);
		}
		else
		{
			return randomSelect(A, q + 1, r, k - i);
		}

	}

	@Test
	public void testRandomSelect()
	{
		int i = randomSelect(A, 0, A.length - 1, 2);
		System.out.println(i);
	}

	private int randomPartition(int[] A, int p, int r)
	{
		int random = new Random().nextInt(r - p + 1) + p;
		DataOper.swapInt(A, random, r);

		int tmp = A[r];
		int i = p - 1;
		int j = p;
		for (; j < r; j++)
		{
			if (A[j] < tmp)
			{
				i++;
				DataOper.swapInt(A, i, j);
			}
		}
		DataOper.swapInt(A, i + 1, r);
		return i + 1;
	}

	@Test
	public void testRP()
	{
		int partition = randomPartition(this.A, 0, this.A.length - 1);
		System.out.print(partition + "   ");
		DataOper.print(this.A);
	}
}
