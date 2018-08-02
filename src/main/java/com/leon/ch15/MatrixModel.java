package com.leon.ch15;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatrixModel
{
	private int[][] data;
	private int row;
	private int column;

	public MatrixModel(int row, int column)
	{
		this.data = new int[row][column];
		this.row = row;
		this.column = column;
	}
}
