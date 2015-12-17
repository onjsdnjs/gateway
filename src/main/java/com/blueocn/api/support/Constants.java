/*
 * Copyright (c) 2008, 2015, OneAPM and/or its affiliates. All rights reserved. 
 */
package com.blueocn.api.support;

import java.util.regex.Pattern;

/**
 * Title: Constants
 * Description: 基础常量类
 *
 * @author Yufan
 * @version 1.0.0
 * @since 2015-12-16 10:53
 */
public interface Constants {

    // 逗号分割符
    Pattern COMMA_SPLIT_PATTERN = Pattern.compile("\\s*[,]+\\s*");

    // 用户Session信息标识
    String LOGIN_USER_IN_SESSION = "current_login_user";

    // 登录页URI
    String LOGIN_URI = "/login";

    // 模板标题定义符
    String PAGE_TITLE = "pageTitle";
}