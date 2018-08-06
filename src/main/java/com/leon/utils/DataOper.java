package com.leon.utils;

import com.alibaba.fastjson.JSONObject;

public class DataOper
{
	/**
	 * 交换数组A中的i与j位置的元素
	 * @param A 原始数据
	 * @param i i
	 * @param j j
	 */
	public static void swapInt(int[] A, int i, int j)
	{
		int a = A[i] ^ A[j];
		A[j] = a ^ A[j];
		A[i] = a ^ A[i];
	}

	/**
	 * 打印数据
	 * @param object 需要打印的数据
	 */
	public static void print(Object object)
	{
		System.out.println(JSONObject.toJSONString(object));
	}

	/**
	 * 打印整型的二维数组
	 * @param data 待打印数据
	 */
	public static void printMatrix(int[][] data)
	{
		int n = data.length;
		for (int i = 0; i < n; i++)
		{
			int l = data[i].length;
			for (int j = 0; j < l; j++)
			{
				System.out.print(data[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
