package com.springcloud.cn.servicehi.utils;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class ResultCode {
	
	public static class DeleteCode {
		// 数据已经被删除
		public static Integer HAVE_DELETED = -11;
		// 要删除的数据为空
		public static Integer EMPTY_DATA_DELETED = -12;
		// 删除成功
		public static Integer SUCCESS_DELETE = 0;
	}
}
