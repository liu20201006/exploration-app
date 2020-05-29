package com.aaa.liuhao.base;

import com.aaa.liuhao.utils.Map2BeanUtils;
import com.aaa.liuhao.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @Company
 * @Author liuhao
 * @Date 2020/5/13 9:33
 * @Version
 * @Description
 * 通用service，这个泛型T指的是实体类
 *       也就是说传递什么样的实体类进来，最终所注入的mapper就是什么类型
 */
public abstract class BaseSerivce<T> {

    private Class<T> cache = null; // 本地缓存池

    @Autowired
    private Mapper<T> mapper;

   /**
    * @Description:
    * 上面的这个Mapper为了保证安全性，必须要是private类型，那么他的子类(UserService)就调用不到
    *            所以需要提供方法给子类用
    * @author:Liu Hao
    * @param:[]
    * @return:tk.mybatis.mapper.common.Mapper
    * @exception:
    * @date:2020/5/13 10:56
    */
    protected Mapper getMapper() {
        return mapper;
    }

   /**
    * @Description:
    * 新增功能
    * @author:Liu Hao
    * @param:[t]
    * @return:java.lang.Integer
    * @exception:
    * @date:2020/5/13 10:56
    */
    public Integer add(T t) throws Exception {
        return mapper.insertSelective(t);
    }

    /**
     * @Description:
     * 通过主键删除
     * @author:Liu Hao
     * @param:[t]
     * @return:java.lang.Integer
     * @exception:
     * @date:2020/5/13 10:57
     */
    public Integer delete(T t) throws Exception {
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * @Description:
     * 通过主键批量删除
     *           能用java代码来搞定的东西，千万不要上子查询
     *           阿里巴巴代码规约手册:
     *               如果联查的时候超过两张表，那么你一定要把这个联查拆开，放在java代码中实现
     * @author:Liu Hao
     * @param:[ids]
     * @return:java.lang.Integer
     * @exception:
     * @date:2020/5/13 10:57
     */
    public Integer batchDelete(List<Object> ids) throws Exception {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }

   /**
    * @Description:
    * 更新功能
    * @author:Liu Hao
    * @param:[t]
    * @return:java.lang.Integer
    * @exception:
    * @date:2020/5/13 10:57
    */
    public Integer update(T t) throws Exception {
        return mapper.updateByPrimaryKeySelective(t);
    }

   /**
    * @Description:
    * 批量更新
    *            t:所要更新的数据(t代表实体类，只能存放一个id)
    *            ids:通用主键来进行更新
    * @author:Liu Hao
    * @param:[t, ids]
    * @return:java.lang.Integer
    * @exception:
    * @date:2020/5/13 10:57
    */
    public Integer batchUpdate(T t, Object[] ids) throws Exception {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t, example);
    }

   /**
    * @Description:
    * 查询一条数据
    * @author:Liu Hao
    * @param:[t]
    * @return:T
    * @exception:
    * @date:2020/5/13 10:57
    */
    public T queryOne(T t) throws Exception {
        return mapper.selectOne(t);
    }

    /**
     * @Description:
     * 通过指定字段查询一条数据
     *           (有些表中有唯一键(username, iphone_num...))
     * @author:Liu Hao
     * @param:[where, orderByField, fields]
     * @return:T
     * @exception:
     * @date:2020/5/13 10:58
     */
    public T queryByField(Sqls where, String orderByField, String... fields) throws Exception {
        return (T) queryByFieldsBase(null, null, where, orderByField, fields).get(0);
    }

    /**
     * @Description:
     * 条件查询集合
     * @author:Liu Hao
     * @param:[where, orderByField, fields]
     * @return:java.util.List<T>
     * @exception:
     * @date:2020/5/13 10:58
     */

    public List<T> queryListByFields(Sqls where, String orderByField, String... fields) throws Exception {
        return queryByFieldsBase(null, null, where, orderByField, fields);
    }

   /**
    * @Description:
    * 条件查询分页
    * @author:Liu Hao
    * @param:[pageNo, pageSize, where, orderByFileds, fields]
    * @return:com.github.pagehelper.PageInfo<T>
    * @exception:
    * @date:2020/5/13 10:58
    */
    public PageInfo<T> queryListByPageAndFields(Integer pageNo, Integer pageSize, Sqls where, String orderByFileds, String... fields) throws Exception {
        return new PageInfo<T>(queryByFieldsBase(pageNo, pageSize, where, orderByFileds, fields));
    }

   /**
    * @Description:
    * 条件查询(查询多条数据)
    * @author:Liu Hao
    * @param:[t]
    * @return:java.util.List<T>
    * @exception:
    * @date:2020/5/13 10:58
    */
    public List<T> queryList(T t) throws Exception {
        return mapper.select(t);
    }

   /**
    * @Description:
    *  分页查询
    * @author:Liu Hao
    * @param:[t, pageNo, pageSize]
    * @return:com.github.pagehelper.PageInfo<T>
    * @exception:
    * @date:2020/5/13 10:58
    */
    public PageInfo<T> queryListByPage(T t, Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     * @Description:
     *  根据反射获取实例对象
     * @author:Liu Hao
     * @param:[map]
     * @return:T
     * @exception:
     * @date:2020/5/13 10:59
     */
    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArguement());
    }

    /**
     * @Description:
     * 封装条件查询，分页查询以及排序查询的通用方法(多条件查询)
     * @author:Liu Hao
     * @param:[pageNo, pageSize, where, orderByField, field]
     * @return:java.util.List<T>
     * @exception:
     * @date:2020/5/13 10:59
     */
    private List<T> queryByFieldsBase(Integer pageNo, Integer pageSize, Sqls where, String orderByField, String... field) {
        Example.Builder builder = null;
        if(null == field || field.length == 0) {
            // 没有条件查询，说明查询的是所有数据
            builder = Example.builder(getTypeArguement());
        } else {
            // 指定某些/某个字段进行查询
            builder = Example.builder(getTypeArguement())
                    .select(field);
        }
        if(null != where) {
            builder = builder.where(where);
        }

        if(null != orderByField) {
            builder = builder.orderByDesc(orderByField);
        }

        Example example = builder.build();

        if(null != pageNo && null != pageSize) { // pageHelper通用分页插件
            PageHelper.startPage(pageNo, pageSize);
        }

        List list = getMapper().selectByExample(example);
        return list;
    }

    /**
     * @Description:
     * 获取子类泛型类型
     * @author:Liu Hao
     * @param:[]
     * @return:java.lang.Class<T>
     * @exception:
     * @date:2020/5/13 10:59
     */
    private Class<T> getTypeArguement() {
        if(null == cache) {
            cache = (Class<T>) ((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        }
        return cache;
    }

   /**
    * @Description:
    *  获取String容器
    *           TODO 咱们用不到，有待补充
    * @author:Liu Hao
    * @param:[]
    * @return:org.springframework.context.ApplicationContext
    * @exception:
    * @date:2020/5/13 10:59
    */
    public ApplicationContext getApplicationContext() {
        return SpringContextUtils.getApplicationContext();
    }

}
