package edu.swu.social.framework.orm.mybatis;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.swu.social.utils.ReflectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by neusoft on 15-6-1.
 */
public class BaseDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<T, PK> {
    public static final String SQLID_INSERT = "insert";
    public static final String SQLID_INSERT_SELECTIVE = "insertSelective";
    public static final String SQLID_UPDATE = "updateByPrimaryKey";
    public static final String SQLID_UPDATE_SELECTIVE = "updateByPrimaryKeySelective";
    public static final String SQLID_DELETE = "deleteByPrimaryKey";
    public static final String SQLID_SELECT = "selectByPrimaryKey";
    public static final String SQLID_SELECT_ALL = "selectAll";
    public static final String SQLID_SELECT_SELECTIVE = "selectSelective";

    protected String basePackage = "edu.swu.social.mapper";
    protected String mapperSuffix = "Mapper";
    protected String sqlNameSpace = "";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public BaseDaoImpl() {
        sqlNameSpace = ReflectionUtils.getSuperClassGenericType(getClass()).getSimpleName();
    }

    private String statementName(String sqlId) {
        return (StringUtils.isNotBlank(basePackage) ? basePackage + "." : "") + sqlNameSpace + mapperSuffix + "." + sqlId;
    }

    @Override
    public int insert(T entity) {
        return getSqlSession().insert(statementName(SQLID_INSERT), entity);
    }

    @Override
    public int insertSelective(T entity) {
        return getSqlSession().insert(statementName(SQLID_INSERT_SELECTIVE), entity);
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        return getSqlSession().update(statementName(SQLID_UPDATE), entity);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return getSqlSession().update(statementName(SQLID_UPDATE_SELECTIVE), entity);
    }

    @Override
    public int deleteByPrimaryKey(PK key) {
        return getSqlSession().delete(statementName(SQLID_DELETE), key);
    }

    @Override
    public T selectByPrimaryKey(PK key) {
        return getSqlSession().selectOne(statementName(SQLID_SELECT), key);
    }

    @Override
    public List<T> selectAll() {
        return getSqlSession().selectList(statementName(SQLID_SELECT_ALL));
    }

    @Override
    public List<T> selectSelective(T entity) {
        return getSqlSession().selectList(statementName(SQLID_SELECT_SELECTIVE), entity);
    }

    @Override
    public PageList<T> selectAllByPage(PageBounds pageBounds) {
        return (PageList<T>) getSqlSession().selectList(statementName(SQLID_SELECT_ALL), null, pageBounds);
    }

    @Override
    public PageList<T> selectSelectiveByPage(T entity, PageBounds pageBounds) {
        return (PageList<T>) getSqlSession().selectList(statementName(SQLID_SELECT_SELECTIVE), entity, pageBounds);
    }

    @Override
    public List<Object> selectCondition(String selectId, Object obj) {
        return getSqlSession().selectList(statementName(selectId), obj);
    }

    @Override
    public PageList<Object> selectConditionByPage(String selectId, Object obj, PageBounds pageBounds) {
        return (PageList<Object>) getSqlSession().selectList(statementName(selectId), obj, pageBounds);
    }
}
