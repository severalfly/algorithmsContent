package com.leon.ch12;

public class TreeUtils
{
	public static TreeW buildTreeW()
	{
		TreeW treeW = new TreeW(2);
		TreeW treeW2 = new TreeW(1);
		TreeW treeW3 = new TreeW(3);
		treeW.setLeft(treeW2);
		treeW.setRight(treeW3);
		return treeW;
	}
}
