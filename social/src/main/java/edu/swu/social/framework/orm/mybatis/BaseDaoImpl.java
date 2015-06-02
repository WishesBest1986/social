package edu.swu.social.framework.orm.mybatis;

import edu.swu.social.utils.ReflectionUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

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

    private String basePackage = "";
    private String mapperSuffix = "";
    private String sqlNameSpace = "";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setMapperSuffix(String mapperSuffix) {
        this.mapperSuffix = mapperSuffix;
    }

    public void setSqlNameSpace(String sqlNameSpace) {
        this.sqlNameSpace = sqlNameSpace;
    }

    public BaseDaoImpl() {
        sqlNameSpace = ReflectionUtils.getSuperClassGenericType(getClass()).getSimpleName();
    }

    private String statementName(String sqlId) {
        return basePackage + "." + sqlNameSpace + mapperSuffix + "." + sqlId;
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
}
