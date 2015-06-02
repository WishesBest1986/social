package edu.swu.social.business.service;

import edu.swu.social.business.dao.UserDao;
import edu.swu.social.business.entity.User;
import edu.swu.social.framework.orm.mybatis.BaseServiceImpl;
import edu.swu.social.framework.orm.mybatis.IBaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by neusoft on 15-6-2.
 */
@Service
public class UserService extends BaseServiceImpl<User, Integer> {
    @Override
    @Resource(type = UserDao.class)
    public void setBaseDao(IBaseDao<User, Integer> baseDao) {
        this.baseDao = baseDao;
    }
}
