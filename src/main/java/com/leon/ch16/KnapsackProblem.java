package com.leon.ch16;

import com.leon.utils.DataOper;
import org.junit.Test;

/**
 * 0-1 背包问题
 * 使用动态规则方法解决
 */
public class KnapsackProblem
{
	private int[] w = new int[] { 0, 2, 3, 4, 5 };// 商品的体积
	private int[] v = new int[] { 0, 3, 4, 5, 6 }; // 每件商品的价值

	/**
	 * 2018-08-08 准备返回剩余的可容纳空间大小
	 * @return 大小
	 */
	private void zeroOneKnapsackProblem(int[] w, int[] v)
	{
		int number = w.length;
		int capacity = 8;
		int[][] V = new int[number][capacity + 1];
		for (int i = 1; i < number; i++)
		{
			for (int j = 1; j <= capacity; j++)
			{
				if (j < w[i]) // 装不进去
				{
					V[i][j] = V[i - 1][j];
				}
				else
				{
					if (V[i - 1][j] > V[i - 1][j - w[i]] + v[i]) // 不装的价值更大
					{
						V[i][j] = V[i - 1][j];
					}
					else
					{
						V[i][j] = V[i - 1][j - w[i]] + v[i];
					}
				}
			}
		}
		DataOper.printMatrix(V);
	}

	@Test
	public void testKnapsack()
	{
		zeroOneKnapsackProblem(w, v);
	}
}
