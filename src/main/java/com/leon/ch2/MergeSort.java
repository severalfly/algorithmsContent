package com.leon.ch2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class MergeSort
{
	@Test
	public void testMerge()
	{
		int[] A = new int[] { 3, 1 };
		merge(A, 0, A.length / 2, A.length);
		System.out.println(JSONObject.toJSONString(A));
	}

	private void merge(int[] A, int p, int q, int r)
	{
		int n1 = q - p;
		int n2 = r - q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++)
		{
			L[i] = A[p + i];
		}
		for (int i = 0; i < n2; i++)
		{
			R[i] = A[q + i];
		}

		//
		//		L[n1] = Integer.MAX_VALUE;
		//		R[n2] = Integer.MAX_VALUE;

		for (int i = 0, j = 0, k = p; k < r; k++)
		{
			int key;
			if (i < n1 && j < n2)
			{
				if (L[i] <= R[j])
				{
					key = L[i++];
				}
				else
				{
					key = R[j++];
				}
			}
			else if (i < n1)
			{
				// j 已经到头了
				key = L[i++];
			}
			else
			{
				// i 已经到头
				key = R[j++];
			}
			A[k] = key;
		}

	}

	/**
	 * 未完成，有个bug找不到了
	 * @param A
	 * @param p
	 * @param r
	 */
	private void mergeSort(int[] A, int p, int r)
	{
		if (p < r)
		{
			System.out.println(p + "  " + r + "  排序前 " + JSONObject.toJSONString(A));
			int q = (p + r) / 2;// 会自动向下取整
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
			System.out.println(p + "  " + r + "  排序后 " + JSONObject.toJSONString(A));
		}
	}

	@Test
	public void testMergeSort()
	{
		int[] A = new int[] { 3, 1, 5, 4, 6, 8, 2, 7 };
		mergeSort(A, 0, A.length);
		System.out.println(JSONObject.toJSONString(A));
	}
}
