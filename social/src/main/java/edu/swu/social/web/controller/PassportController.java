package edu.swu.social.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neusoft on 15-6-1.
 */
@Controller
public class PassportController {

    @RequestMapping(value = "login")
    public String login() {
        return "passport/login";
    }

}
