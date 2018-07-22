package com.leon.ch6;

import com.alibaba.fastjson.JSONObject;
import com.leon.utils.DataOper;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MaxHeapSort
{
	int[] A = new int[] { 0, 10, 16, 23, 6, 3, 1, 9, 5 };

	@Test
	public void testHeapSort()
	{
		int length = 1024;
		int[] B = new int[length];
		for (int i = 1; i < length; i++)
		{
			B[i] = new Random().nextInt(100000);
		}
		heapSort(B);
		System.out.println(JSONObject.toJSONString(B));
		for (int i = 2; i < length; i++)
		{
			if (B[i - 1] > B[i])
			{
				System.out.println(B[i - 1] + "   " + B[i] + "   " + i);
			}
		}
	}

	public void heapSort(int[] A)
	{
		int n = A.length - 1;
		int heapSize = A.length - 1;
		for (int i = n; i > 1; i--)
		{
			maxHeapify(A, 1, heapSize);
			//			System.out.println(JSONObject.toJSONString(A));
			DataOper.swapInt(A, 1, heapSize);
			heapSize--;

		}

	}

	private void buildMaxHeap(int[] A, int heapSize)
	{
		int n = A.length - 1;
		for (int i = n / 2; i >= 1; i--)
		{
			maxHeapify(A, i, heapSize);
		}
	}

	@Test
	public void testbuildMaxHeap()
	{
		int length = 1024;
		int[] B = new int[length];
		for (int i = 1; i < length; i++)
		{
			B[i] = new Random().nextInt(100000);
		}
		buildMaxHeap(B, B.length - 1);
		System.out.println(JSONObject.toJSONString(B));
	}

	@Test
	public void testMaxHeapify()
	{

		maxHeapify(A, 1, A.length - 1);
		System.out.println(JSONObject.toJSONString(A));
	}

	private void maxHeapify(int[] A, int i, int heapSize)
	{
		int l = left(i);
		int r = right(i);
		int largest = -1;
		if (l <= heapSize && A[l] > A[i])
		{
			largest = l;
		}
		else
		{
			largest = i;
		}

		if (r <= heapSize && A[r] > A[largest])
		{
			largest = r;
		}
		if (largest != i)
		{
			// 不是最大堆
			DataOper.swapInt(A, i, largest);
			//			System.out.println(String.format("%s, %s, %s", A[i], A[l], A[r]));
			maxHeapify(A, largest, heapSize);
		}
	}

	private int parent(int i)
	{
		return i / 2;
	}

	private int left(int i)
	{
		return 2 * i;
	}

	private int right(int i)
	{
		return 2 * i + 1;
	}
}
