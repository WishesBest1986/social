package edu.swu.social.web.controller;

import edu.swu.social.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neusoft on 15-6-1.
 */
@Controller
public class PassportController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login")
    public String login() {
        return "passport/login";
    }

}
