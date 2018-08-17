package com.leon.exe;

import com.leon.utils.DataOper;

import java.util.ArrayList;

public class LowestCon
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		//		Scanner scanner = new Scanner(System.in);
		//		while (scanner.hasNext())
		//		{
		//			String array = scanner.nextLine();
		//			int m = scanner.nextInt();
		String array = "299 299 299 399 399 399 399 399 499 499";
		int m = 1000;
		String[] strings = array.trim().split(" ");
		int len = strings.length;
		int[] num = new int[len];
		for (int i = 0; i < len; i++)
		{
			num[i] = Integer.parseInt(strings[i]);
		}
		System.out.println("data over");
		int[] record = new int[len];
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		backtrack(num, record, m, 0, 0, lists, 1000, 1298);
		DataOper.print(lists);
		//		System.out.println(maxFighting(lists));
		//		}
	}
	//求数组input中，和为给定key的所有子数组

	public static void backtrack(int[] input, int[] record, int key, int sum, int n, ArrayList<ArrayList<Integer>> lists, int low, int high)
	{
		if (n == input.length)
		{
			return;
		}
		else
		{
			for (int i = 0; i <= 1; i++)
			{
				sum += i * input[n];
				record[n] = i;
				if (sum >= low && sum <= high)
				{
					ArrayList<Integer> list = new ArrayList<Integer>();
					for (int j = 0; j <= n; j++)
					{
						if (record[j] == 1)
						{
							list.add(input[j]);
							input[j] = 0;
						}
					}
					lists.add(list);
				}
				if (sum < low)
				{
					backtrack(input, record, key, sum, n + 1, lists, low, high);
				}
				sum -= i * input[n];
			}
		}
	}

	//求所有子数组中，最大乘积
	public static int maxFighting(ArrayList<ArrayList<Integer>> lists)
	{
		int size = lists.size();
		if (lists == null || size == 0)
			return -1;
		int maxMultipy = Integer.MIN_VALUE;
		int multipy = 1;
		for (int i = 0; i < size; i++)
		{
			ArrayList<Integer> list = lists.get(i);
			for (int j = 0; j < list.size(); j++)
			{
				multipy *= list.get(j);
			}
			if (multipy > maxMultipy)
			{
				maxMultipy = multipy;
			}
			multipy = 1;
		}
		return maxMultipy;
	}

}

