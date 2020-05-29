package com.aaa.liuhao.base;

import static com.aaa.liuhao.status.LoginStatus.*;
import static com.aaa.liuhao.status.CrudStatus.*;
/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/13 10:25
 * @Version
 * @Description 通用controller，就是实现consumer和provider统一返回值
 */
public class BaseController {



  /**-----------------------------------登录----------------------------------------------*/
  /**
   * @Description:
   * 登录成功，使用系统消息
   * @author:Liu Hao
   * @param:[]
   * @return:com.aaa.liuhao.base.ResultData
   * @exception:
   * @date:2020/5/13 10:26
   */
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

   /**
    * @Description:
    * 登录成功，使用自定义消息
    * @author:Liu Hao
    * @param:[msg]
    * @return:com.aaa.liuhao.base.ResultData
    * @exception:
    * @date:2020/5/13 10:26
    */
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

   /**
    * @Description:
    * 登录成功，使用系统消息，自定义返回值
    * @author:Liu Hao
    * @param:[data]
    * @return:com.aaa.liuhao.base.ResultData
    * @exception:
    * @date:2020/5/13 10:26
    */
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

   /**
    * @Description:
    * 登录成功，自定义消息，自定义返回值
    * @author:Liu Hao
    * @param:[msg, data]
    * @return:com.aaa.liuhao.base.ResultData
    * @exception:
    * @date:2020/5/13 10:27
    */
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

   /**
    * @Description:
    *  登录失败，使用系统消息
    * @author:Liu Hao
    * @param:[]
    * @return:com.aaa.liuhao.base.ResultData
    * @exception:
    * @date:2020/5/13 10:27
    */
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description:
     * 登录失败，使用自定义消息
     * @author:Liu Hao
     * @param:[msg]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData loginFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description:
     * 登录失败，使用系统消息，自定义返回值
     * @author:Liu Hao
     * @param:[data]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData loginFailed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description:
     * 登录失败，自定义消息，自定义返回值
     * @author:Liu Hao
     * @param:[msg, data]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData loginFailed(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    //TODO 登录

    /**-----------------------------------新增----------------------------------------------*/
    /**
     * @Description:
     *  新增成功，使用系统消息
     * @author:Liu Hao
     * @param:[]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData addSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(ADD_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description:
     * 新增成功，使用自定义消息
     * @author:Liu Hao
     * @param:[msg]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData addSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description:
     *  新增失败，使用系统消息
     * @author:Liu Hao
     * @param:[]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData addFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(ADD_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description:
     * 新增失败，使用自定义消息
     * @author:Liu Hao
     * @param:[msg]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData addFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }




/**-----------------------------------删除----------------------------------------------*/
    /**
     * @Description:
     *  删除成功，使用系统消息
     * @author:Liu Hao
     * @param:[]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData deleteSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description:
     * 删除成功，使用自定义消息
     * @author:Liu Hao
     * @param:[msg]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData deleteSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description:
     *  删除失败，使用系统消息
     * @author:Liu Hao
     * @param:[]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData deleteFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description:
     * 删除失败，使用自定义消息
     * @author:Liu Hao
     * @param:[msg]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData deleteFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }



    /**-----------------------------------修改---------------------------------------------*/
    /**
     * @Description:
     *  修改成功，使用系统消息
     * @author:Liu Hao
     * @param:[]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData updateSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description:
     * 修改成功，使用自定义消息
     * @author:Liu Hao
     * @param:[msg]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData updateSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description:
     *  修改失败，使用系统消息
     * @author:Liu Hao
     * @param:[]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData updateFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description:
     * 修改失败，使用自定义消息
     * @author:Liu Hao
     * @param:[msg]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData updateFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }


    /**-----------------------------------查询---------------------------------------------*/
    /**
     * @Description:
     * 查询成功，使用系统消息，自定义返回值
     * @author:Liu Hao
     * @param:[data]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData selectSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description:
     * 查询成功，自定义消息，自定义返回值
     * @author:Liu Hao
     * @param:[msg, data]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData selectSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description:
     * 查询失败，使用系统消息，自定义返回值
     * @author:Liu Hao
     * @param:[data]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:26
     */
    protected ResultData selectFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description:
     * 查询失败，自定义消息，自定义返回值
     * @author:Liu Hao
     * @param:[msg, data]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:27
     */
    protected ResultData selectFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
}
