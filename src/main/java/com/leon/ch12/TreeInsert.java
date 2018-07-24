package com.leon.ch12;

import org.junit.Test;

public class TreeInsert
{
	/**
	 * 把 z 插入到 T中
	 * @param t tree
	 * @param z 待插入的节点
	 */
	private void treeInsert(TreeW t, TreeW z)
	{
		TreeW y = null;
		TreeW x = t;
		while (x != null)
		{
			y = x;
			if (z.getKey() < x.getKey())
			{
				x = x.getLeft();
			}
			else
			{
				x = x.getRight();
			}
		}
		z.setP(y);
		if (y == null)
		{
			// 原始tree 为null
			t = z;
		}
		else if (y.getKey() > z.getKey())
		{
			y.setLeft(z);
		}
		else
		{
			y.setRight(z);
		}
	}

	@Test
	public void testTreeInsert()
	{
		TreeW treeW = TreeUtils.buildTreeW();
		TreeUtils.printTree(treeW);
		System.out.println();
		TreeW z = new TreeW(5);
		treeInsert(treeW, z);

		System.out.println(treeW.getKey());
		// 打印看看结果
		TreeUtils.printTree(treeW);
		System.out.println();

	}
}
