package edu.swu.social.business.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.swu.social.business.dao.UserDao;
import edu.swu.social.business.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neusoft on 15-6-2.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

}
