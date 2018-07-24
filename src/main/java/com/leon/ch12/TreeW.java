package com.leon.ch12;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TreeW
{
	private int key;

	private TreeW p; // 父节点引用
	private TreeW left; // 左子节点引用
	private TreeW right; // 右子节点引用

	public TreeW(int key)
	{
		this.key = key;
		this.p = null;
		this.left = null;
		this.right = null;
	}

}
