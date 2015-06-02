package edu.swu.social.web.controller;

import edu.swu.social.business.entity.User;
import edu.swu.social.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by neusoft on 15-6-1.
 */
@Controller
public class PassportController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login")
    public String login() {
//        User user = new User();
//        user.setName("张三");
//
//        userService.insert(user);
//        List<User> lists = userService.list();
        User user = userService.select();

        return "passport/login";
    }

}
