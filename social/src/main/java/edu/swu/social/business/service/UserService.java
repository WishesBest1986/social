package edu.swu.social.business.service;

import edu.swu.social.business.dao.UserDao;
import edu.swu.social.business.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by neusoft on 15-6-2.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User select() {
        return userDao.selectByPrimaryKey(1);
    }

}
