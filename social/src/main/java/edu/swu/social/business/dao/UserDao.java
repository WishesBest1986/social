package edu.swu.social.business.dao;

import edu.swu.social.business.entity.User;
import edu.swu.social.framework.orm.mybatis.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by neusoft on 15-6-2.
 */
@Repository
public class UserDao extends BaseDaoImpl<User, Integer> {
}
