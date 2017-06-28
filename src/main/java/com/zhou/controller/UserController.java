package com.zhou.controller;


import com.zhou.dto.ResultDTO;
import com.zhou.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Created by ZhouXiang on 2017/6/28 19:14.
 */
@Api(value = "user", description = "用户管理", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("user")
public class UserController {

    // 列出某个类目的所有规格
    @ApiOperation(value = "获得用户列表", notes = "列表信息", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultDTO list(
            @ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId,
            @ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId2,
            @ApiParam(value = "token", required = true) @RequestParam String token) {
        return new ResultDTO("200", "获取用户列表成功!", ResultDTO.SUCCESS, new User(token, 25));
    }

    @ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    // @RequestBody只能有1个
    // 使用了@RequestBody，不能在拦截器中，获得流中的数据，再json转换，拦截器中，也不清楚数据的类型，无法转换成java对象
    // 只能手动调用方法
    public ResultDTO add(@RequestBody User user) {
        String u = findUser(user);
        System.out.println(u);
        return new ResultDTO("200", "保存成功!", ResultDTO.SUCCESS, user);
    }

    @ApiOperation(value = "update用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultDTO update(@RequestBody User user) {
        String u = findUser(user);
        System.out.println(u);
        return new ResultDTO("200", "修改成功!", ResultDTO.SUCCESS, user);
    }

    private String findUser(User user) {
        return user.toString();
    }
}