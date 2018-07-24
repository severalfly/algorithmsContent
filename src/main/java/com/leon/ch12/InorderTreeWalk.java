package com.leon.ch12;

import com.leon.utils.DataOper;
import org.junit.Test;

public class InorderTreeWalk
{
	private void inOrderTreeWald(TreeW treeW)
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
		TreeW treeW = buildTreeW();
		System.out.println("start to in order tree walk");
		new InorderTreeWalk().inOrderTreeWald(treeW);
		System.out.println("end to in order tree walk");
	}

	private TreeW treeSearch(TreeW treeW, int k)
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
		TreeW treeW = buildTreeW();
		TreeW treeW1 = treeSearch(treeW, 1);
		DataOper.print(treeW1);
	}

	private static TreeW buildTreeW()
	{
		TreeW treeW = new TreeW(2);
		TreeW treeW2 = new TreeW(1);
		TreeW treeW3 = new TreeW(3);
		treeW.setLeft(treeW2);
		treeW.setRight(treeW3);
		return treeW;
	}
}


