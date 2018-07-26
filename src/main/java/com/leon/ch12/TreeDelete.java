package com.leon.ch12;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class TreeDelete
{
	/**
	 * 用 v节点替换u节点
	 * @param t 待处理的树
	 * @param u 被替换掉的节点
	 * @param v 新的节点
	 */
	private void transplant(TreeW t, TreeW u, TreeW v)
	{
		if (u.getP() == null)
		{
			t = v;
		}
		else if (u == u.getP().getLeft())
		{
			u.getP().setLeft(v);
		}
		else
		{
			u.getP().setRight(v);
		}
		if (v != null)
		{
			v.setP(u.getP());
		}
	}

	/**
	 * 删除节点
	 * @param t 待处理的树
	 * @param z 待删除的节点
	 */
	private void treeDelete(TreeW t, TreeW z)
	{
		TreeW y = null;
		if (z.getLeft() == null)
		{
			transplant(t, z, z.getRight());
		}
		else if (z.getRight() == null)
		{
			transplant(t, z, z.getLeft());
		}
		else
		{
			y = TreeUtils.treeMininum(z);
			if (y.getP() != z)
			{
				transplant(t, y, y.getRight()); // 当前位置移动到z
				y.setRight(z.getRight()); //
				y.getRight().setP(y); // 把右子树位置提升
			}
			transplant(t, z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setP(y);
		}
	}

	@Test
	public void testDelete()
	{
		TreeW treeW = TreeUtils.buildTreeW();
		//		TreeUtils.outputTree(treeW);
		System.out.println(JSONObject.toJSONString(treeW));
		TreeW z = InorderTreeWalk.treeSearch(treeW, 5);
		treeDelete(treeW, z);
		System.out.println(JSONObject.toJSONString(treeW));
	}
}
