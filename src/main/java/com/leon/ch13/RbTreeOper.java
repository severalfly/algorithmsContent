package com.leon.ch13;

public class RbTreeOper
{
	/**
	 * 左旋转
	 * @param t 主树
	 * @param x 被旋转节点
	 */
	public static void leftRotate(RbTree t, RbTree x)
	{
		//		RbTree root = t;
		RbTree y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != null)
		{
			y.getLeft().setP(x);
		}
		y.setP(x.getP());
		if (x.getP() == null)
		{
			t.setRoot(y);
			//			t = y;
		}
		else if (x == x.getP().getLeft())
		{
			x.getP().setLeft(y);
		}
		else
		{
			x.getP().setRight(y);
		}
		y.setLeft(x);
		x.setP(y);
		//		return root;
	}

	/**
	 * 右旋转
	 * @param t 树
	 * @param y 待旋转
	 */
	public static void rightRotate(RbTree t, RbTree y)
	{
		//		RbTree root = t;
		RbTree x = y.getLeft();
		y.setLeft(x.getRight());
		if (x.getRight() != null)
		{
			x.getRight().setP(y);
		}
		x.setP(y.getP());
		if (y.getP() == null)
		{
			t.setRoot(x);
		}
		else if (y == y.getP().getRight())
		{
			y.getP().setRight(x);
		}
		else
		{
			y.getP().setLeft(x);
		}
		x.setRight(y);
		y.setP(x);
		//		return root;
	}

	/**
	 * 生成一个树
	 */
	public static RbTree buildRbtree()
	{
		RbTree tree = new RbTree(0);
		RbTree node = new RbTree(5);
		RbTree node1 = new RbTree(4);
		RbTree node2 = new RbTree(6);
		RbTree node3 = new RbTree(7);
		//		RbTree tree4 = new RbTree(8);
		node.setLeft(node1);
		node1.setP(node);
		node.setRight(node2);
		node2.setP(node);
		node2.setRight(node3);
		node3.setP(node2);
		tree.setRoot(node);
		return tree;
	}

	/**
	 * 中序遍历并打印
	 * @param tree 树
	 */
	private static void inOrderPrint(RbTree tree)
	{
		if (tree != null)
		{
			inOrderPrint(tree.getLeft());
			System.out.print(tree.getKey() + " ");
			inOrderPrint(tree.getRight());
		}
	}

	/**
	 * 打印出来
	 * @param tree 树
	 */
	public static void outputTree(RbTree tree)
	{
		System.out.print(tree.getKey() + ": ");
		inOrderPrint(tree);
		System.out.println();
	}

	public static void rbInsert(RbTree t, RbTree z)
	{
		RbTree y = null;
		RbTree x = t;
		while (x != null)
		{
			y = x;
			//			if
		}
	}
}
