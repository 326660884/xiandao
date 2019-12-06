package cn.cnic.xiandao.model;

import lombok.Data;

import java.util.List;
import java.util.Stack;

/**
    *  响应模型
 * @author xuhuipeng
 *
 */
@Data
public class SimpleApiModel<T> {
	
	private int code;//响应码
	private String msg;
	private List<T> data;//数据
	private Long count;//总条数

	public static SimpleApiModel OK(String msg) {
		SimpleApiModel simpleApimModel = new SimpleApiModel<>();
		simpleApimModel.setCode(0);
		simpleApimModel.setMsg(msg);
		return simpleApimModel;
	}

	public static <T> SimpleApiModel<T> OK(List<T> data,Long count) {
		SimpleApiModel<T> simpleApimModel = new SimpleApiModel<>();
		simpleApimModel.setCode(0);
		simpleApimModel.setData(data);
		simpleApimModel.setCount(count);
		return simpleApimModel;
	}

	public static SimpleApiModel FAIL(String msg) {
		SimpleApiModel simpleApimModel = new SimpleApiModel<>();
		simpleApimModel.setCode(-1);
		simpleApimModel.setMsg(msg);
		return simpleApimModel;
	}
	
}
