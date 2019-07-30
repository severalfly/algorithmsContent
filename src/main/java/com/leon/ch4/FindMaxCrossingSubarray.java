package com.leon.ch4;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

public class FindMaxCrossingSubarray
{
	private SubArrayRes findMaxCrossingSubarray(int[] A, int low, int mid, int high)
	{
		int leftSum = 0 - Integer.MAX_VALUE;
		int maxLeft = 0;
		int maxRight = 0;
		int rightSum;
		int sum = 0;
		for (int i = mid; i >= low; i--)
		{
			sum += A[i];
			if (sum > leftSum)
			{
				leftSum = sum;
				maxLeft = i;
			}
		}
		rightSum = 0 - Integer.MAX_VALUE;
		sum = 0;
		for (int j = mid + 1; j <= high; j++)
		{
			sum += A[j];
			if (sum > rightSum)
			{
				rightSum = sum;
				maxRight = j;
			}
		}

		SubArrayRes res = new SubArrayRes(maxLeft, maxRight, leftSum + rightSum);
		return res;
	}

	@Test
	public void testFind()
	{
		int[] A = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, -4, 7 };
		SubArrayRes res = findMaxCrossingSubarray(A, 0, A.length / 2, A.length);
		System.out.println(JSONObject.toJSONString(res));
	}

	private SubArrayRes findMaxmumSubarray(int[] A, int low, int high)
	{
		if (high == low)
		{
			return new SubArrayRes(low, high, A[low]);
		}
		int mid = (low + high) / 2;
		SubArrayRes leftRes = findMaxmumSubarray(A, low, mid);
		SubArrayRes rightRes = findMaxmumSubarray(A, mid + 1, high);
		SubArrayRes crossRes = findMaxCrossingSubarray(A, low, mid, high);

		if (leftRes.getSum() > rightRes.getSum() && leftRes.getSum() > crossRes.getSum())
		{
			return leftRes;
		}
		else if (rightRes.getSum() > leftRes.getSum() && rightRes.getSum() > crossRes.getSum())
		{
			return rightRes;
		}
		else
		{
			return crossRes;
		}

	}

	@Test
	public void testFindMax()
	{
		int[] A = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, -4, 7 };
		SubArrayRes res = findMaxmumSubarray(A, 0, A.length - 1);
		System.out.println(JSONObject.toJSONString(res));
	}

	@Test
	public void testFindMaxV2()
	{
		int[] A = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, -4, 7 };
		int maxsofar = 0;
		int maxendinghere = 0;
		for (int i = 0; i < A.length; i++)
		{
			maxendinghere = Math.max(maxendinghere + A[i], 0);
			maxsofar = Math.max(maxsofar, maxendinghere);
		}
		System.out.println(maxendinghere + "  " + maxsofar);
	}

}

@Setter
@Getter
class SubArrayRes
{
	public SubArrayRes(int left, int right, int sum)
	{
		this.left = left;
		this.right = right;
		this.sum = sum;
	}

	private int left;
	private int right;
	private int sum;
}
