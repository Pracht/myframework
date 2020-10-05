package com.example.myframework.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframework.common.utils.RedisUtil;
import com.example.myframework.dao.ManageUserMapper;
import com.example.myframework.entity.ManageUser;
import com.example.myframework.service.ManageUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HuRongHua
 * @describe
 * @date 2020/10/4 5:05 下午
 */
//@Slf4j该注解可直接使用log对象进行打印日志
@Slf4j
@Service("manageUserService")
public class ManageUserServiceImpl implements ManageUserService {


    @Autowired
    private ManageUserMapper manageUserMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<ManageUser> selectlist() {
        log.info("胡{}荣{}华","111","222");
        List<ManageUser> list = null;
        redisUtil.remove("183859240477492186a1e09665302a6f");
        if(!redisUtil.exists("183859240477492186a1e09665302a6f")){
            //        manageUserMapper.selectList();
            list = manageUserMapper.selectList(new QueryWrapper<ManageUser>().lambda()
                    .eq(ManageUser::getId, "183859240477492186a1e09665302a6f"));
            log.info(JSON.toJSONString(list));
            redisUtil.set("183859240477492186a1e09665302a6f",list);
        }else {
            list = (List<ManageUser>) redisUtil.get("183859240477492186a1e09665302a6f");
        }
        return list;
    }


    @Override
    public IPage<ManageUser> selectbyUser(Page<ManageUser> page, ManageUser manageUser) {
//        List<ManageUser> list = manageUserMapper.selectList(new QueryWrapper<ManageUser>().lambda()
//                .eq(ManageUser::getUserNo, manageUser.getUserNo()));
        IPage<ManageUser> list = manageUserMapper.selectPage(page,new QueryWrapper<ManageUser>());
        //manageUserMapper.selectMapsPage(page,new QueryWrapper<ManageUser>());
        return list;
    }
}
