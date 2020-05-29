package com.aaa.liuhao.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/13 10:47
 * @Version
 * @Description //TODO
 */
public abstract class CommonController<T> extends BaseController {

    /**
     * @Description: 钩子函数，在新增之前所执行的内容
     * @author:Liu Hao
     * @param:[map]
     * @return:void
     * @exception:
     * @date:2020/5/13 10:48
     */
    protected void beforeAdd(Map map) {
        // TODO 钩子函数，也就是说如果在插入之前你需要执行某些业务的时候，则需要编写内容
    }

    /**
     * @Description: 钩子函数，在新增之后所执行的内容
     * @author:Liu Hao
     * @param:[map]
     * @return:void
     * @exception:
     * @date:2020/5/13 10:49
     */
    protected void afterAdd(Map map) {
        // TODO 钩子函数，也就是说如果在插入之后你需要执行某些业务的时候，则需要编写内容
    }



    public abstract BaseSerivce<T> getBaseService();



    /**
     * @Description: 新增数据
     * @author:Liu Hao
     * @param:[map]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:49
     */
    public ResultData add(@RequestBody Map map) {
        ResultData resultData = new ResultData();
        //钩子函数
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer insertResult = getBaseService().add(instance);
            if (insertResult > 0) {
                // 说明保存成功
                //钩子函数
                afterAdd(map);
                return addSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addFailed();
    }




    // TODO delete, batchDelete, update, getOne, getList, getListByPage(不带条件的分页查询)
    /**
     * @Description: 删除数据
     * @author:Liu Hao
     * @param:[map]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:49
     */
    public ResultData delete(@RequestBody Map map) {
        ResultData resultData = new ResultData();
        //钩子函数
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer insertResult = getBaseService().delete(instance);
            if (insertResult > 0) {
                // 说明删除成功
                //钩子函数
                afterAdd(map);
                return deleteSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFailed();
    }

    /**
     * @Description: 批量删除数据
     * @author:Liu Hao
     * @param:[map]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:49
     */
    public ResultData batchDelete(@RequestBody Map map) {
        ResultData resultData = new ResultData();
        List<Object> list=null;
        //钩子函数
        beforeAdd(map);
       list.add(map);
        try {
            Integer insertResult = getBaseService().batchDelete(list);
            if (insertResult > 0) {
                // 说明批量删除成功
                //钩子函数
                afterAdd(map);
                return deleteSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFailed();
    }


    /**
     * @Description: 修改数据
     * @author:Liu Hao
     * @param:[map]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:49
     */
    public ResultData update(@RequestBody Map map) {
        ResultData resultData = new ResultData();
        //钩子函数
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            Integer insertResult = getBaseService().update(instance);
            if (insertResult > 0) {
                // 说明修改成功
                //钩子函数
                afterAdd(map);
                return updateSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFailed();
    }




    // getOne, getList, getListByPage(不带条件的分页查询)
    /**
     * @Description: 查询一条数据
     * @author:Liu Hao
     * @param:[map]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:49
     */
    public ResultData getOne(@RequestBody Map map) {
        ResultData resultData = new ResultData();
        //钩子函数
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            T t=getBaseService().queryOne(instance);

            if (null!=t && !"".equals(t)) {
                // 说明查询一条数据成功
                //钩子函数
                afterAdd(map);
                resultData.setData(t);
                return selectSuccess(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectFailed();
    }


    /**
     * @Description: 查询多条条数据
     * @author:Liu Hao
     * @param:[map]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:49
     */
    public ResultData getList(@RequestBody Map map) {
        ResultData resultData = new ResultData();
        //钩子函数
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {

            List<T> t=getBaseService().queryList(instance);

            if (null!=t && !"".equals(t)&&0 < t.size()) {
                // 说明查询多条数据成功
                //钩子函数
                afterAdd(map);
                resultData.setData(t);
                return selectSuccess(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectFailed();
    }


    /**
     * @Description: getListByPage(不带条件的分页查询)
     * @author:Liu Hao
     * @param:[map]
     * @return:com.aaa.liuhao.base.ResultData
     * @exception:
     * @date:2020/5/13 10:49
     */
    public ResultData getListByPage(@RequestBody Map map,Integer pageNo,Integer pageSize) {
        ResultData resultData = new ResultData();
        //钩子函数
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        try {
            PageInfo<T> t=getBaseService().queryListByPage(instance,pageNo,pageSize);

            if (null!=t && !"".equals(t)&&0 < t.getSize()) {
                // 说明查询多条数据成功
                //钩子函数
                afterAdd(map);
                resultData.setData(t);
                return selectSuccess(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectFailed();
    }

    /**
     * @Description: 防止数据不安全，所以不能直接在controller某个方法中直接接收HttpServletRequest对象
     * 必须要从本地当前线程中获取对象
     * @author:Liu Hao
     * @param:[]
     * @return:javax.servlet.http.HttpServletRequest
     * @exception:
     * @date:2020/5/13 10:49
     */
    public HttpServletRequest getServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }

    /**
     * @Description: 获取当前客户端的session对象(如果不存在 ， 则会重新创建一个)
     * @author:Liu Hao
     * @param:[]
     * @return:javax.servlet.http.HttpSession
     * @exception:
     * @date:2020/5/13 10:49
     */
    public HttpSession getSession() {
        return getServletRequest().getSession();
    }

    /**
     * @param
     * @return javax.servlet.http.HttpSession
     * @throws
     * @author Liu Hao
     * @description 获取当前客户端的session对象(如果不存在 ， 则直接返回为null)
     * @date 2020/5/12
     **/
    public HttpSession getExistSession() {
        return getServletRequest().getSession(false);

    }
}