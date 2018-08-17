package com.leon.exe;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		//		Scanner in = new Scanner(System.in);
		//		while (in.hasNext())
		//		{

		//			int n = in.nextInt(), x = in.nextInt(), sum = 0;
		//			int price[] = new int[n];
		//			for (int i = 0; i < n; i++)
		//			{
		//				price[i] = in.nextInt();
		//				sum += price[i];
		//			}
		int n = 10, x = 50, sum = 0;
		int price[] = new int[n + 1];
		String data = "9 9 9 9 9 9 9 9 9 8";
		int ii = 0;
		for (String str : data.split(" "))
		{
			price[ii] = Integer.parseInt(str);
			sum += price[ii++];
		}

		if (sum < x)
		{
			System.out.println("-1");
			//				continue;
		}

		//背包情境：尽可能多放，相当于从差值中去掉没必要加入的菜品
		int m = sum - x;
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; i++)
		{
			for (int j = m; j >= 0; j--)
			{
				if (price[i] > j)
					break;//该菜品必须添加
				dp[j] = Math.max(dp[j - price[i]] + price[i], dp[j]);
			}
		}
		System.out.println(sum - dp[m]);
		//		}
	}

}
