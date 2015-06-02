package edu.swu.social.framework.orm.mybatis;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by neusoft on 15-6-1.
 */
public class BaseDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<T, PK> {
    public static final String SQLID_INSERT = "insert";
    public static final String SQLID_UPDATE = "update";
    public static final String SQLID_SELECT = "select";

    private String sqlNamespace = "USER";

    @Override
    public int insert(T entity) {
        getSqlSession().insert(sqlNamespace + "." + SQLID_INSERT, entity);
        return 0;
    }

    @Override
    public int update(T entity) {
        return 0;
    }

    @Override
    public int delete(PK key) {
        return 0;
    }

    @Override
    public int truncate() {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public T get(PK key) {
        return null;
    }

    @Override
    public List<T> select() {
        return getSqlSession().selectList(sqlNamespace + "." + SQLID_SELECT);
    }
}
