package com.atguigu.atnewmall.common;

import com.atguigu.atnewmall.bean.AJAXResult;

public abstract class BaseController {

	private ThreadLocal<AJAXResult> result = new ThreadLocal<AJAXResult>();
	
	protected void start() {
		result.set(new AJAXResult());
	}
	
	protected Object end() {
		Object obj = result.get();
		result.remove();
		return obj;
	}
	
	protected void data( Object data ) {
		AJAXResult r = result.get();
		r.setData(data);
	}
	
	protected void success(boolean flg) {
		AJAXResult r = result.get();
		r.setSuccess(flg);
	}
	
	protected void success() {
		success(true);
	}
	
	protected void fail() {
		success(false);
	}
}
