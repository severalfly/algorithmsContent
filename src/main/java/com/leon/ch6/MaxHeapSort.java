package com.leon.ch6;

import com.alibaba.fastjson.JSONObject;
import com.leon.utils.DataOper;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MaxHeapSort
{
	int[] A = new int[] { 0, 70, 3, 80, 66, 45, 9, 94, 40, 16 };
	int heapSize = A.length - 1;

	@Test
	public void testHeapSort()
	{
		int length = 102400;
		A = new int[length];
		heapSize = A.length - 1;
		for (int i = 1; i < length; i++)
		{
			A[i] = new Random().nextInt(10000);
		}
		heapSort(A);
		System.out.println(JSONObject.toJSONString(A));
		for (int i = 1; i < A.length; i++)
		{
			if (A[i - 1] > A[i])
			{
				System.out.println(A[i - 1] + "   " + A[i] + "   " + i);
			}
		}
	}

	public void heapSort(int[] A)
	{
		buildMaxHeap(A);
		System.out.println("init heap:  " + JSONObject.toJSONString(A));
		int n = A.length - 1;
		for (int i = n; i > 0 && heapSize > 0; i--)
		{
			DataOper.swapInt(A, 0, heapSize);
			heapSize--;
			//			maxHeapify(A, i);
			//			System.out.println("after heap: " + JSONObject.toJSONString(A));
			buildMaxHeap(A);
		}

	}

	private void buildMaxHeap(int[] A)
	{
		int n = A.length - 1;
		for (int i = (n + 1) / 2; i >= 0; i--)
		{
			maxHeapify(A, i);
		}
	}

	@Test
	public void testbuildMaxHeap()
	{
		//		int length = 11;
		//		int[] B = new int[length];
		//		for (int i = 1; i < length; i++)
		//		{
		//			B[i] = new Random().nextInt(100);
		//		}
		System.out.println(JSONObject.toJSONString(A));
		buildMaxHeap(A);
		System.out.println(JSONObject.toJSONString(A));
	}

	@Test
	public void testMaxHeapify()
	{

		maxHeapify(A, 0);
		System.out.println(JSONObject.toJSONString(A));
	}

	private void maxHeapify(int[] A, int i)
	{
		int l = left(i);
		int r = right(i);
		int largest = i;
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
			maxHeapify(A, largest);
			//			maxHeapify(A, r, heapSize);
		}
	}

	private int parent(int i)
	{
		return i / 2;
	}

	private int left(int i)
	{
		return 2 * i + 1;
	}

	private int right(int i)
	{
		return 2 * i + 2;
	}
}
