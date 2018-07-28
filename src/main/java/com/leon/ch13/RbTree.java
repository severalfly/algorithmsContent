package com.leon.ch13;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RbTree
{
	private RbColor color;
	private int key;
	private RbTree p;
	private RbTree left;
	private RbTree right;

	public RbTree(int key, RbColor color)
	{
		this.color = color;
		this.key = key;
		this.p = null;
		this.left = null;
		this.right = null;
		List
	}

	public RbTree(int key)
	{
		RbTree(key, RbColor.BLACK);
	}

}
