package com.zhou.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.zhou.dto.ResultDTO;
import com.zhou.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ZhouXiang on 2017/6/28 14:56.
 */
@Api(value = "welcome", description = "欢迎", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @ApiOperation(value = "根据用户名获取数据", httpMethod = "GET", response = ResultDTO.class, notes = "根据用户名获取数据")
    @RequestMapping(value = "/getData/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getData(@ApiParam(required = true, name = "name", value = "用户名") @PathVariable String name) {
        return new ResultDTO("200", "获取成功", ResultDTO.SUCCESS, new User(name,25));
    }
}
