package com.company.project.service.impl;

import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.RedisService;
import com.company.project.service.UserService;
import com.company.project.core.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/11.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;
    @Override
    public boolean checkUserInfo(String openId, String sessionKey) {
        if(StringUtils.isBlank(openId) || StringUtils.isBlank(sessionKey)){
            return false;
        }
        System.out.println(sessionKey);
        System.out.println(redisService.get(openId).toString());
        System.out.println(sessionKey.equals(redisService.get(openId)));
        if(!sessionKey.equals(redisService.get(openId))){
            return false;
        }
        return true;
    }
}
