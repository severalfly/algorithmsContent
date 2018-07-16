package com.leon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class TTTTTTT {
	@Test
	public void test18ForEach() {
		List<Det> strs = new ArrayList<Det>();
		strs.add(new Det());
		strs.forEach(a -> setStr(a));
		System.out.println(strs);
	}

	private void setStr(Det a) {
		a.setS(new Date().toString());
	}
}

class Det {
	private String s;

	public String getS() {
		return this.s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return s;
	}

}
