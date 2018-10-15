package com.springcloud.cn.servicehi.test;

import com.springcloud.cn.servicehi.entity.People;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class UnitTest {
	@Test
	public void test() {
		People people = new People();
		people.setNameList(null);
		List<String> list = people.getNameList();
		for(String string: list) {
			System.out.println(string);
		}
	}
	@Test
	public void testStock() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		List<Integer> result = new ArrayList<>();
		stack.peek();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
	}
	@Test
	public void offer() {
		int[][] matrix = {{1}};
		ArrayList<Integer>res = new ArrayList<>();
		if(matrix.length == 0) {
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int circle = ((row > col ? col : row) - 1) / 2 + 1;
		for(int i = 0; i < circle; i++) {
			for(int y = i; i < col - i; y++) {
				res.add(matrix[i][y]);
			}
			for(int x = i + 1; x < row - i; x++) {
				res.add(matrix[x][col-i-1]);
			}
			for(int y = col-i-2; y >= i && (row-1-i != i); y--) {
				res.add(matrix[row-i-1][y]);
			}
			for(int x = row-i-2; x > i && (col-1-i != i); x--) {
				res.add(matrix[x][i]);
			}
		}
		
	}
	
	
}
