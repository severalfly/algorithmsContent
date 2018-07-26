package com.leon.ch12;

public class TreeUtils
{
	public static TreeW buildTreeW()
	{
		TreeW treeW = new TreeW(5);
		//		TreeW treeW2 = new TreeW(1);
		//		TreeW treeW3 = new TreeW(6);
		//		treeW.setLeft(treeW2);
		//		treeW.setRight(treeW3);
		TreeInsert.treeInsert(treeW, new TreeW(1));
		TreeInsert.treeInsert(treeW, new TreeW(6));
		TreeInsert.treeInsert(treeW, new TreeW(9));
		TreeInsert.treeInsert(treeW, new TreeW(7));
		TreeInsert.treeInsert(treeW, new TreeW(4));
		return treeW;
	}

	/**
	 * 中序打印
	 * @param treeW 待打印
	 */
	private static void printTree(TreeW treeW)
	{
		if (treeW != null)
		{
			printTree(treeW.getLeft());
			System.out.print(treeW.getKey() + " ");
			printTree(treeW.getRight());
		}
	}

	public static void outputTree(TreeW treeW)
	{
		System.out.println(treeW.getKey());
		printTree(treeW);
		System.out.println();
	}

	/**
	 * 搜索最小节点
	 * @param treeW 待搜索
	 * @return 最小节点
	 */
	public static TreeW treeMininum(TreeW treeW)
	{
		while (treeW.getLeft() != null)
		{
			treeW = treeW.getLeft();
		}
		return treeW;
	}

	/**
	 * 搜索最大值节点
	 * @param x 待搜索
	 * @return 最大节点
	 */
	public static TreeW treeMaximum(TreeW x)
	{
		while (x.getRight() != null)
		{
			x = x.getRight();
		}
		return x;
	}

	/**
	 * 搜索后继
	 * @param x 待搜索
	 * @return 后继节点
	 */
	public static TreeW treeSuccessor(TreeW x)
	{
		if (x.getRight() != null)
		{
			treeMininum(x.getRight());
		}
		TreeW y = x.getP();

		while (y != null && x == y.getRight())
		{
			x = y;
			y = y.getP();
		}
		return y;
	}
}
