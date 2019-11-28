package cn.cnic.xiandao.model;

import lombok.Data;

import java.util.List;

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

	public static <T> SimpleApiModel<T> OK(List<T> data, Long count) {
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
}
