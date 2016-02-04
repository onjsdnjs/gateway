package com.blueocn.api.kong.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.blueocn.api.kong.request.ApiReq;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Title: ApiRes
 * Description: Kong API 响应信息实体, 参见 https://getkong.org/docs/0.6.x/admin-api/#request-querystring-parameters
 *
 * @author Yufan
 * @version 1.0.0
 * @since 2016-02-03 17:27
 */
@Setter
@Getter
public class ApiResp implements Serializable {
    private static final long serialVersionUID = 8473584357526776595L;

    @JSONField(name = "data")
    private List<ApiReq> data;

    @JSONField(name = "total")
    private Integer total;

    @JSONField(name = "next")
    private String next;
}
