package edu.swu.social.framework.orm.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 * Created by neusoft on 15-6-1.
 */
public interface IBaseDao<T, PK extends Serializable> {
    public abstract int insert(T entity);

    public abstract int update(T entity);

    public abstract int delete(PK key);

    public abstract int truncate();

    public abstract int count();

    public abstract T get(PK key);

    public abstract List<T> select();
}
