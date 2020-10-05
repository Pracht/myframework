package com.example.myframework.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframework.common.ResultEntity;
import com.example.myframework.entity.ManageUser;
import com.example.myframework.service.ManageUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HuRongHua
 * @date 2020/10/4 4:37 下午
 */
@RestController
@Api(tags = "测试接口")
public class TestController {

    @Autowired
    private ManageUserService manageUserService;

    @GetMapping("/hello")
    @ApiOperation(value = "测试方法")
    public String hello(){
        List<ManageUser> list = manageUserService.selectlist();
        return JSONArray.fromObject(list).toString();
    }

    @PostMapping("/selectbyUser")
    @ResponseBody
    @ApiOperation(value = "测试方法2")
    public ResultEntity<IPage<ManageUser>> hello2(Page<ManageUser> page, @RequestBody ManageUser manageUser){
        IPage<ManageUser> list = manageUserService.selectbyUser(page,manageUser);
        return ResultEntity.ok(list);
    }
}
