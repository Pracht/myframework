package com.example.myframework.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Tag;
import lombok.Data;

import java.io.Serializable;

/**
 * @author HuRongHua
 * @date 2020/10/4 5:01 下午
 */
@Data
@TableName("MANAGE_USER")
@ApiModel(value = "用户实体类")
public class ManageUser implements Serializable {

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value = "主键ID")
    private String id;

    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    private Long userNo;

    /**
     * 用户登录账号
     */
    @ApiModelProperty(value = "用户登录账号")
    private String userLoginNo;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "用户性别")
    private Integer sex;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private String roleId;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private String departmentId;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id")
    private String platformId;

    /**
     * 照片id
     */
    @ApiModelProperty(value = "照片id")
    private String photoId;

    /**
     * 岗位id
     */
    @ApiModelProperty(value = "岗位id")
    private String postId;
}
