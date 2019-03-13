package com.company.project.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.Resource;

@ConfigurationProperties(prefix = "wechat")
@Resource
public class WechatConfig {
    private String appid;
    private String secret;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
