package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Sponsor;
import com.company.project.service.SponsorService;
import com.company.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/03/11.
*/
@RestController
@RequestMapping("/v1/sponsors")
public class SponsorController {
    @Resource
    private SponsorService sponsorService;

    @Autowired
    private UserService userService;
    @PostMapping
    public Result add(@RequestBody Sponsor sponsor) {
        sponsorService.save(sponsor);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sponsorService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Sponsor sponsor) {
        sponsorService.update(sponsor);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id, @RequestParam(defaultValue = "") String openId, @RequestParam(defaultValue = "") String sessionKey) {
        if(!userService.checkUserInfo(openId,sessionKey)){
            return ResultGenerator.genFailResult("验证失败");
        }

        Sponsor sponsor = sponsorService.findById(id);
        return ResultGenerator.genSuccessResult(sponsor);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
        @RequestParam(defaultValue = "") String openId, @RequestParam(defaultValue = "") String sessionKey
    ) {
        if(!userService.checkUserInfo(openId,sessionKey)){
            return ResultGenerator.genFailResult("验证失败");
        }
        PageHelper.startPage(page, size);
        List<Sponsor> list = sponsorService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
