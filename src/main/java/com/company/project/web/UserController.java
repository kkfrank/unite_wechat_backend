package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SessionResult;
import com.company.project.model.User;
import com.company.project.model.WechatConfig;
import com.company.project.service.RedisService;
import com.company.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/03/11.
*/
@RestController
@RequestMapping("/v1/users")
@EnableConfigurationProperties({WechatConfig.class})
public class UserController {
    @Resource
    private UserService userService;

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private RedisService redisService;

    @PostMapping
    public Result add(@RequestBody User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/code2session")
    public Result code2Session(@RequestParam(value= "code") String code){
        String appId = wechatConfig.getAppid();
        String secret = wechatConfig.getSecret();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret="
                + secret + "&js_code=" + code + "&grant_type=authorization_code";

        SessionResult  result = new SessionResult();
        try{
            HttpResponse<JsonNode> response = Unirest.get(url).header("accept", "application/json")
                             .header("Content-Type", "application/json")
                             .asJson();
            JSONObject jsonObject = response.getBody().getObject();

            String openId = jsonObject.getString("openid");
            String sessionKey  = jsonObject.getString("session_key");
            if(StringUtils.isEmpty(openId) || StringUtils.isEmpty(sessionKey)){
                return ResultGenerator.genFailResult("openId or sessionKey is null");
            }

            redisService.set(openId,sessionKey);

            result.setOpenId(openId);
            result.setSessionKey(sessionKey);

        }catch (Exception e){

        }
        return ResultGenerator.genSuccessResult(result);
    }

}
