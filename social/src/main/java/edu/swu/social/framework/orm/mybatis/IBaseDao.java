package edu.swu.social.framework.orm.mybatis;

import java.io.Serializable;

/**
 * Created by neusoft on 15-6-1.
 */
public interface IBaseDao<T, PK extends Serializable> {
    public abstract int insert(T entity);
    public abstract int insertSelective(T entity);
    public abstract int updateByPrimaryKey(T entity);
    public abstract int updateByPrimaryKeySelective(T entity);
    public abstract int deleteByPrimaryKey(PK key);
    public abstract T selectByPrimaryKey(PK key);
}
