package com.leon.ch15;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class MatrixMultiply
{
	private MatrixModel a;
	private MatrixModel b;

	private void fillData()
	{

		a = new MatrixModel(2, 2);
		b = new MatrixModel(2, 1);
		int[][] data = a.getData();
		data[0][0] = 1;
		data[0][1] = 2;
		data[1][0] = 3;
		data[1][1] = 4;
		data = b.getData();
		data[0][0] = 5;
		data[1][0] = 6;
	}

	@Test
	public void testFillData()
	{
		fillData();
		System.out.println(JSONObject.toJSONString(a));

	}

	private MatrixModel matrixMultipy(MatrixModel a, MatrixModel b) throws Exception
	{
		if (a.getColumn() != b.getRow())
		{
			throw new Exception("incompatible dimensions");
		}
		int[][] aData = a.getData();
		int[][] bData = b.getData();
		MatrixModel c = new MatrixModel(a.getRow(), b.getColumn());
		int[][] cData = c.getData();
		for (int i = 0; i < a.getRow(); i++)
		{
			for (int j = 0; j < b.getColumn(); j++)
			{
				cData[i][j] = 0;
				for (int k = 0; k < a.getColumn(); k++)
				{
					cData[i][j] = cData[i][j] + aData[i][k] * bData[k][j];
				}
			}
		}
		return c;
	}

	@Test
	public void testMatrixMultipy()
	{
		try
		{
			fillData(); // 完善数据的
			MatrixModel matrixModel = matrixMultipy(a, b);
			System.out.println(JSONObject.toJSONString(matrixModel));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
