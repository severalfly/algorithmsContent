package com.leon.ch12;

import lombok.Getter;
import lombok.Setter;
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
		TreeW treeW = new TreeW(1);
		TreeW treeW2 = new TreeW(2);
		TreeW treeW3 = new TreeW(3);
		treeW.setLeft(treeW2);
		treeW.setRight(treeW3);
		System.out.println("start to in order tree walk");
		new InorderTreeWalk().inOrderTreeWald(treeW);
		System.out.println("end to in order tree walk");
	}

}


