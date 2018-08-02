package com.leon.ch15;

public class MatrixMultiply
{
	private void matrixMultipy(MatrixModel a, MatrixModel b) throws Exception
	{
		if (a.getColumn() != b.getRow())
		{
			throw new Exception("incompatible dimensions");
		}

	}
}
