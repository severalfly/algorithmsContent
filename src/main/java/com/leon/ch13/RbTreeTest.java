package com.leon.ch13;

import org.junit.Test;

public class RbTreeTest
{
	@Test
	public void testLeftRotate()
	{
		RbTree tree = RbTreeOper.buildRbtree();
		RbTreeOper.outputTree(tree.getRoot());
		// 开始旋转
		RbTreeOper.leftRotate(tree, tree.getRoot().getRight());

		//		RbTreeOper.outputTree(root);
		RbTreeOper.outputTree(tree.getRoot());

	}

}
