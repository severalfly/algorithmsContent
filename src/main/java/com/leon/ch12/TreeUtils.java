package com.leon.ch12;

public class TreeUtils
{
	public static TreeW buildTreeW()
	{
		TreeW treeW = new TreeW(2);
		TreeW treeW2 = new TreeW(1);
		TreeW treeW3 = new TreeW(6);
		treeW.setLeft(treeW2);
		treeW.setRight(treeW3);
		return treeW;
	}

	/**
	 * 中序打印
	 * @param treeW 待打印
	 */
	public static void printTree(TreeW treeW)
	{
		if (treeW != null)
		{
			printTree(treeW.getLeft());
			System.out.print(treeW.getKey() + " ");
			printTree(treeW.getRight());
		}
	}
}
