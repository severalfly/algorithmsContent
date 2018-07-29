package com.leon.ch13;

import org.junit.Test;

public class RbTreeTest
{
	@Test
	public void testLeftRotate()
	{
		RbTree tree = RbTreeOper.buildRbtree();
		RbTreeOper.outputTree(tree);
		// 开始旋转
		RbTree root = RbTreeOper.leftRotate(tree, tree.getRight());
		RbTreeOper.outputTree(root);

	}

}
