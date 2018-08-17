package com.leon.exe;

import com.leon.utils.DataOper;

import java.util.ArrayList;
import java.util.List;

public class Lines
{
	public static void main(String[] args)
	{
		int[] data = new int[] { 599, 599, 499, 499, 499, 399, 399, 399, 299, 299, 299, 299, 199 };
		int limit = 1000;

		int start = 0;
		int end = data.length - 1;
		int sum = 0;
		List<Integer> ids = new ArrayList<>();
		for (int i = start; i < data.length - 1; i++)
		{
			sum += data[i];
			if (sum < limit)
			{
				// 加上当前值还不够
				ids.add(i);
				continue;
			}
			sum -= data[i];
			// 加上当前值已经超过限制，则从最高处向后取数据
			for (int j = end; j >= i; j--)
			{
				sum += data[j];
				if (sum > limit)
				{
					// 因为已经排序了，最尾处满足条件的，肯定是最优解
					ids.add(j);
					end = j - 1;
					break;
				}
			}
			if (sum > limit)
			{
				i--;
				DataOper.print(ids);
				ids = new ArrayList<>();
				sum = 0;

			}
		}
	}
}
