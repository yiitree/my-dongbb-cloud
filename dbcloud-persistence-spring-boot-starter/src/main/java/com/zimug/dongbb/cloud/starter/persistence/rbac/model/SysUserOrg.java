package com.zimug.dongbb.cloud.starter.persistence.rbac.model;

import com.zimug.dongbb.cloud.starter.persistence.auto.model.SysUser;

public class SysUserOrg extends SysUser {

  private String orgName;

  public String getOrgName() {
    return orgName;
  }
  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }
}
