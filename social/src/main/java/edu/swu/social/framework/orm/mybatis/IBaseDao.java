package edu.swu.social.framework.orm.mybatis;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.io.Serializable;
import java.util.List;

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
    public abstract List<T> selectAll();
    public abstract List<T> selectSelective(T entity);
    public abstract PageList<T> selectAllByPage(PageBounds pageBounds);
    public abstract PageList<T> selectSelectiveByPage(T entity, PageBounds pageBounds);
}
