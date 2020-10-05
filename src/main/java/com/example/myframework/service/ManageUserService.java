package com.example.myframework.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframework.entity.ManageUser;

import java.util.List;

/**
 * @author HuRongHua
 * @date 2020/10/4 5:01 下午
 */
public interface ManageUserService {

    List<ManageUser> selectlist();

    IPage<ManageUser> selectbyUser(Page<ManageUser> page, ManageUser manageUser);
}
