package com.springcloud.cn.servicehi.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.springcloud.cn.servicehi.utils.ResultCode.DeleteCode.EMPTY_DATA_DELETED;
import static com.springcloud.cn.servicehi.utils.ResultCode.DeleteCode.HAVE_DELETED;
import static com.springcloud.cn.servicehi.utils.ResultCode.DeleteCode.SUCCESS_DELETE;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class ConditionJudgeUtil {
	public static Map<Integer, ResultBodyFunction> conditionMap = new HashMap<>();
	
	{
		conditionMap.put(HAVE_DELETED, () -> System.out.println("数据已删除"));
		conditionMap.put(EMPTY_DATA_DELETED, () -> System.out.println("所删除的数据为空"));
		conditionMap.put(SUCCESS_DELETE, () -> System.out.println("操作成功"));
	}
}
