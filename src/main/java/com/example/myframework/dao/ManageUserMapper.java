package com.example.myframework.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myframework.entity.ManageUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HuRongHua
 * @describe
 * @date 2020/10/4 5:22 下午
 */
public interface ManageUserMapper extends BaseMapper<ManageUser> {

    List<ManageUser> selectUserList();

}
