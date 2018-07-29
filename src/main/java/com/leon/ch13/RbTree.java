package com.leon.ch13;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RbTree
{
	private RbColor color;
	private int key;
	private RbTree p;
	private RbTree left;
	private RbTree right;

	public RbTree(int key)
	{
		this.color = RbColor.BLACK;
		this.key = key;
		this.p = null;
		this.left = null;
		this.right = null;
	}

	public RbTree(int key, RbColor color)
	{
		this.color = color;
		this.key = key;
		this.p = null;
		this.left = null;
		this.right = null;
	}

}
