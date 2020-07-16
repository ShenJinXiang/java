package com.shenjinxiang.spb.rpc.entity;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/5/9 17:29
 */
public class RpcResult {

    private boolean success = true;
    private String msg;
    private Object result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
