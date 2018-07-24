package com.leon.ch12;

import com.leon.utils.DataOper;
import org.junit.Test;

public class InorderTreeWalk
{
	public static void inOrderTreeWald(TreeW treeW)
	{
		if (treeW != null)
		{
			inOrderTreeWald(treeW.getLeft());
			System.out.println(treeW.getKey());
			inOrderTreeWald(treeW.getRight());
		}
	}

	public static void main(String[] args)
	{
		TreeW treeW = TreeUtils.buildTreeW();
		System.out.println("start to in order tree walk");
		new InorderTreeWalk().inOrderTreeWald(treeW);
		System.out.println("end to in order tree walk");
	}

	public static TreeW treeSearch(TreeW treeW, int k)
	{
		if (treeW == null || k == treeW.getKey())
		{
			return treeW;
		}
		if (k < treeW.getKey())
		{
			return treeSearch(treeW.getLeft(), k);
		}
		else
		{
			return treeSearch(treeW.getRight(), k);
		}
	}

	@Test
	public void testTreeSearch()
	{
		TreeW treeW = TreeUtils.buildTreeW();
		int k = 2;
		TreeW treeW1 = treeSearch(treeW, k);
		DataOper.print(treeW1);
		treeW1 = interativeTreeSearch(treeW, k);
		DataOper.print(treeW1);
	}

	public static TreeW interativeTreeSearch(TreeW treeW, int k)
	{
		while (treeW != null && treeW.getKey() != k)
		{
			if (k < treeW.getKey())
			{
				treeW = treeW.getLeft();
			}
			else
			{
				treeW = treeW.getRight();
			}
		}
		return treeW;
	}

}


