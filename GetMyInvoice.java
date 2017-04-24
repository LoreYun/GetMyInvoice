package com.ctvit.collect.service;

import java.util.ArrayList;

/**
 * Created by LoreYun on 2017/4/24.
 */
public class GetMyInvoice {
	private static int min = 550;
	private static int offset = 0;


	public static void main(String[] args) {
		int invoice[] = {300, 50, 53, 112, 118, 120, 128, 130, 154, 228, 248, 300, 300};
		combiantion(invoice);
	}

	/**
	 * 参考字符串的组合
	 * 	http://www.cnblogs.com/565261641-fzh/p/5398454.html
	 * @param array
	 */
	private static void combiantion(int array[]) {
		if (array == null || array.length == 0) {
			return;
		}
		ComList<Integer> list = new ComList<Integer>();
		for (int i = 1; i <= array.length; i++) {
			combine(array, 0, i, list);
		}
		return;
	}

	//从字符数组中第begin个字符开始挑选number个字符加入list中
	public static void combine(int[] cs, int begin, int number, ComList<Integer> list) {
		if (number == 0) {
			//			System.out.println(list.toString());
			int sum = list.total();
			
			if (sum >= min && sum <= (min+offset)) {
				System.out.println(list.toString() + " sum:" + sum);
			}
			return;
		}
		if (begin == cs.length) {
			return;
		}
		list.add(cs[begin]);
		combine(cs, begin + 1, number - 1, list);
		list.remove((Integer) cs[begin]);
		combine(cs, begin + 1, number, list);
	}

	private static class ComList<Interger> extends ArrayList<Integer>{
		public int total(){
			int sum = 0;
			for(int i=0;i<size();i++){
				sum += get(i);
			}
			return sum;
		}
	}
}
