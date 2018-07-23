package com.leon.ch8;

import com.leon.utils.DataOper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class BuckerSort
{
	private void sort(float[] A)
	{
		int n = A.length;
		Vector<List<Float>> B = new Vector<>(n);
		for (int i = 0; i < n; i++)
		{
			B.add(new ArrayList<>(A.length));
		}
		for (int i = 0; i < A.length; i++)
		{
			int position = (int) (n * A[i]);
			List<Float> ints = B.get(position);
			ints.add(A[i]);
		}
		for (List<Float> floats : B)
		{
			insertSort(floats);
		}
		int i = 0;
		for (List<Float> floats : B)
		{
			for (Float aFloat : floats)
			{
				A[i++] = aFloat;
			}
		}
		//		DataOper.print(A);
	}

	@Test
	public void testBukerSort()
	{
		float[] list = new float[] { 0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.23f, 0.12f, 0.23f, 0.68f };
		sort(list);
		DataOper.print(list);
	}

	/**
	 * 使用插入排序对子数组进行排序
	 * @param list 待排序数据
	 */
	private void insertSort(List<Float> list)
	{
		for (int i = 1; i < list.size(); i++)
		{
			Float key = list.get(i);
			for (int j = i; j > 0; j--)
			{
				if (list.get(j) < list.get(j - 1))
				{
					float tmp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, tmp);

				}
				else
				{
					list.set(j, key);
					break;
				}
			}

		}
	}

	@Test
	public void testInsertSort()
	{
		List<Float> list = new ArrayList<>();
		list.add(1.2f);
		list.add(5.6f);
		list.add(5.6f);
		list.add(5.6f);
		list.add(5.6f);
		list.add(3.4f);
		insertSort(list);
		DataOper.print(list);
	}
}
