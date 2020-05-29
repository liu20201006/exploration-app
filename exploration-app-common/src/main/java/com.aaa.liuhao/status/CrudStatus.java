package com.aaa.liuhao.status;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/13 11:54
 * @Version
 * @Description //增删改查的状态
 */
public enum CrudStatus {

    ADD_SUCCESS("20001", "添加成功"),
    ADD_FAILED("10001", "添加失败"),

    DELETE_SUCCESS("20001", "删除成功"),
    DELETE_FAILED("10001", "删除失败"),

    UPDATE_SUCCESS("2001", "修改成功"),
    UPDATE_FAILED("10001", "修改失败"),

    SELECT_SUCCESS("2001", "查询成功"),
    SELECT_FAILED("10001", "查询失败");



    CrudStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
