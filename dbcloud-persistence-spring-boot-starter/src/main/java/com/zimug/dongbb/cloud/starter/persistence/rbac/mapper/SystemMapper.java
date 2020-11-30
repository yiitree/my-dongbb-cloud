package com.zimug.dongbb.cloud.starter.persistence.rbac.mapper;


import com.zimug.dongbb.cloud.starter.persistence.auto.model.SysApi;
import com.zimug.dongbb.cloud.starter.persistence.auto.model.SysMenu;
import com.zimug.dongbb.cloud.starter.persistence.auto.model.SysOrg;
import com.zimug.dongbb.cloud.starter.persistence.rbac.model.SysUserOrg;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SystemMapper {
  List<SysOrg> selectOrgTree(@Param("rootOrgId") Integer rootOrgId,
                             @Param("orgNameLike") String orgNameLike,
                             @Param("orgStatus") Boolean orgStatus);

  List<SysMenu> selectMenuTree(@Param("rootMenuId") Integer rootMenuId,
                               @Param("menuNameLike") String menuNameLike,
                               @Param("menuStatus") Boolean menuStatus);

  List<SysApi> selectApiTree(@Param("rootApiId") Integer rootApiId,
                             @Param("apiNameLike") String apiNameLike,
                             @Param("apiStatus") Boolean apiStatus);


  Integer insertRoleMenuIds(@Param("roleId") Integer roleId,
                            @Param("checkedIds") List<Integer> checkedIds);

  Integer insertRoleApiIds(@Param("roleId") Integer roleId,
                           @Param("checkedIds") List<Integer> checkedIds);

  List<Integer> selectApiExpandedKeys();

  List<Integer> selectMenuExpandedKeys();

  List<Integer> selectApiCheckedKeys(Integer roleId);

  List<Integer> selectMenuCheckedKeys(Integer roleId);

  List<SysUserOrg> selectUser(@Param("orgId") Integer orgId,
                              @Param("username") String username,
                              @Param("phone") String phone,
                              @Param("email") String email,
                              @Param("enabled") Boolean enabled,
                              @Param("createStartTime") Date createStartTime,
                              @Param("createEndTime") Date createEndTime);

  List<Integer> getCheckedRoleIds(Integer userId);

  Integer insertUserRoleIds(@Param("userId") Integer userId,
                            @Param("checkedIds") List<Integer> checkedIds);

  List<SysMenu> selectMenuByUsername(@Param("username") String username);
}
