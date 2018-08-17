package com.leon.exe;

import java.util.ArrayList;

public class CaseTestPrice
{
	public static void main(String[] args)
	{

		// 一堆书的价格
		Object[] tmp = { 299, 299, 299, 399, 399, 499, 499 };
		// Object[] tmp = str.split(" ");
		int minCount = 1000;// 满200
		int maxCount = 1299;// 自己认为的最大限制
		int num = 0;
		ArrayList<Object[]> rs = RandomC(tmp);
		// ArrayList<Object[]> rs = cmn(tmp, 3);//3个的组合
		// ArrayList<Object[]> rs = cmn(tmp, 4);//4个的组合
		for (int i = 0; i < rs.size(); i++)

		{
			// System.out.print(i+"=");
			Double countTemp = 0.0;
			String strTemp = "";
			for (int j = 0; j < rs.get(i).length; j++)
			{
				countTemp = countTemp + Double.parseDouble(rs.get(i)[j].toString());
				// System.out.print(rs.get(i)[j] + ",");
				strTemp += rs.get(i)[j] + ",";
			}
			// System.out.println();
			if (minCount < countTemp && countTemp <= maxCount)
			{
				num++;
				System.out.println("满" + minCount + "减，方案" + num + ":" + countTemp + "\n组合是：" + strTemp + "\n");
			}

		}

	}

	// 求一个数组的任意组合
	static ArrayList<Object[]> RandomC(Object[] source)
	{
		ArrayList<Object[]> result = new ArrayList<Object[]>();
		if (source.length == 1)
		{
			result.add(source);
		}
		else
		{
			Object[] psource = new Object[source.length - 1];
			for (int i = 0; i < psource.length; i++)
			{
				psource[i] = source[i];
			}
			result = RandomC(psource);
			int len = result.size();// fn组合的长度
			result.add((new Object[] { source[source.length - 1] }));
			for (int i = 0; i < len; i++)
			{
				Object[] tmp = new Object[result.get(i).length + 1];
				for (int j = 0; j < tmp.length - 1; j++)
				{
					tmp[j] = result.get(i)[j];
				}
				tmp[tmp.length - 1] = source[source.length - 1];
				result.add(tmp);
			}

		}
		return result;
	}

	// 求指定长度的数组任意组合
	static ArrayList<Object[]> cmn(Object[] source, int n)
	{
		ArrayList<Object[]> result = new ArrayList<Object[]>();
		if (n == 1)
		{
			for (int i = 0; i < source.length; i++)
			{
				result.add(new Object[] { source[i] });

			}
		}
		else if (source.length == n)
		{
			result.add(source);
		}
		else
		{
			Object[] psource = new Object[source.length - 1];
			for (int i = 0; i < psource.length; i++)
			{
				psource[i] = source[i];
			}
			result = cmn(psource, n);
			ArrayList<Object[]> tmp = cmn(psource, n - 1);
			for (int i = 0; i < tmp.size(); i++)
			{
				Object[] rs = new Object[n];
				for (int j = 0; j < n - 1; j++)
				{
					rs[j] = tmp.get(i)[j];
				}
				rs[n - 1] = source[source.length - 1];
				result.add(rs);
			}
		}
		return result;
	}
}
