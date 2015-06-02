package edu.swu.social.framework.orm.mybatis;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.io.Serializable;
import java.util.List;

/**
 * Created by neusoft on 15-6-2.
 */
public abstract class BaseServiceImpl<T, PK extends Serializable> implements IBaseService<T, PK> {
    protected IBaseDao<T, PK> baseDao;

    public abstract void setBaseDao(IBaseDao<T, PK> baseDao);

    @Override
    public int insert(T entity) {
        return baseDao.insert(entity);
    }

    @Override
    public int insertSelective(T entity) {
        return baseDao.insertSelective(entity);
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        return baseDao.updateByPrimaryKey(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return baseDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteByPrimaryKey(PK key) {
        return baseDao.deleteByPrimaryKey(key);
    }

    @Override
    public T selectByPrimaryKey(PK key) {
        return baseDao.selectByPrimaryKey(key);
    }

    @Override
    public List<T> selectAll() {
        return baseDao.selectAll();
    }

    @Override
    public List<T> selectSelective(T entity) {
        return baseDao.selectSelective(entity);
    }

    @Override
    public PageList<T> selectAllByPage(PageBounds pageBounds) {
        return baseDao.selectAllByPage(pageBounds);
    }

    @Override
    public PageList<T> selectSelectiveByPage(T entity, PageBounds pageBounds) {
        return baseDao.selectSelectiveByPage(entity, pageBounds);
    }

    @Override
    public List<Object> selectCondition(String selectId, Object obj) {
        return baseDao.selectCondition(selectId, obj);
    }

    @Override
    public PageList<Object> selectConditionByPage(String selectId, Object obj, PageBounds pageBounds) {
        return baseDao.selectConditionByPage(selectId, obj, pageBounds);
    }
}
