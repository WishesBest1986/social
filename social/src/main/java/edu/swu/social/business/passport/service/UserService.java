package edu.swu.social.business.passport.service;

import edu.swu.social.business.passport.entity.User;
import edu.swu.social.framework.orm.mybatis.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neusoft on 15-6-1.
 */
@Service
public class UserService {
    @Autowired
    private BaseDaoImpl<User, Integer> userDao;


    public int insert(User user) {
        return userDao.insert(user);
    }

    public List<User> list() {
        return userDao.select();
    }
}
