package com.blueocn.api.controller.ui.user;

import com.blueocn.api.controller.ui.AbstractUIController;
import com.blueocn.api.response.UserResponse;
import com.blueocn.api.service.UserService;
import com.blueocn.api.support.session.SessionManager;
import com.blueocn.api.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.blueocn.api.support.Constants.LOGIN_URI;
import static com.blueocn.api.support.utils.Asserts.checkNotBlank;

/**
 * Title: LoginController
 * Description: 用户登录控制器
 *
 * @author Yufan
 * @version 1.0.0
 * @since 2016-01-04 22:05
 */
@Controller
public class UserController extends AbstractUIController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = LOGIN_URI, method = RequestMethod.GET)
    public String login(Model model) {
        setPageTitle(model, "登录");
        return "user/login";
    }

    @RequestMapping(value = LOGIN_URI, method = RequestMethod.POST)
    public String login(UserVo userVo, HttpServletRequest request, Model model) {
        try {
            checkNotBlank(userVo.getUserIdentity(), "用户登录名不能为空");
            checkNotBlank(userVo.getUserPassword(), "用户密码不能为空");
            UserResponse response = userService.login(userVo.getUserIdentity(), userVo.getUserPassword());
            if (response.isSuccess()) {
                SessionManager.INSTANCE.login(userVo, request.getSession());
                return "redirect:/index";
            }
            setErrorMessage(model, response.getResponse());
        } catch (Exception e) {
            LOGGER.warn("", e);
            setErrorMessage(model, e.getMessage());
        }
        return login(model);
    }

    @RequestMapping(value = "/user/logout")
    public String logout(HttpServletRequest request) {
        SessionManager.INSTANCE.logout(request.getSession());
        return "redirect:" + LOGIN_URI;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register(Model model) {
        setPageTitle(model, "用户注册");
        return "user/register";
    }

    @RequestMapping(value = "/user/{item}/reset", method = RequestMethod.GET)
    public String resetPassword(UserVo userVo, @PathVariable("item") String item) {
        // TODO
        return null;
    }
}
