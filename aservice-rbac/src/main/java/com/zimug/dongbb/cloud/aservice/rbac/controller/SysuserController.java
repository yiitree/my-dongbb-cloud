package com.zimug.dongbb.cloud.aservice.rbac.controller;

import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zimug.dongbb.cloud.aservice.rbac.service.SysuserService;
import com.zimug.dongbb.cloud.starter.persistence.auto.model.SysUser;
import com.zimug.dongbb.cloud.starter.persistence.rbac.model.SysUserOrg;
import com.zimug.dongbb.cloud.starter.web.exception.AjaxResponse;
import com.zimug.dongbb.cloud.starter.web.exception.CustomExceptionType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

// 指定一个类中所有放回大fallback方法，之后在需要的方法上只需要添加@HystrixCommand即可
@DefaultProperties(defaultFallback = "commonFallbackMethod")
@RestController
@RequestMapping("/sysuser")
public class SysuserController extends BaseController{
  @Resource
  private SysuserService sysuserService;

  @GetMapping(value = "/info")
  public SysUser info(@RequestParam("username") String username) {

      return sysuserService.getUserByUserName(username);
  }

  @PostMapping("/query")
  public PageInfo<SysUserOrg> query(@RequestParam("orgId") Integer orgId ,
                                    @RequestParam("username") String username ,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("email") String email,
                                    @RequestParam("enabled") Boolean enabled,
                                    @RequestParam("createStartTime") Date createStartTime,
                                    @RequestParam("createEndTime") Date createEndTime,
                                    @RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize) {

    return sysuserService.queryUser(orgId,username,phone,email,enabled,
                                    createStartTime, createEndTime,
                                    pageNum,pageSize);
  }


  @PostMapping(value = "/update")
  public AjaxResponse update(@RequestBody SysUser sysUser) {
    sysuserService.updateUser(sysUser);
    return AjaxResponse.success("更新用户成功！");
  }

  @PostMapping(value = "/add")
  public AjaxResponse add(@RequestBody SysUser sysUser) {
    sysuserService.addUser(sysUser);
    return AjaxResponse.success("新增用户成功！");
  }

  // 添加熔断注解，走全局配置
  @HystrixCommand
  @PostMapping(value = "/delete")
  public AjaxResponse delete(@RequestParam Integer userId) {
    sysuserService.deleteUser(userId);
    return AjaxResponse.success("删除用户成功!");
  }

  // 在方法上添加注解
  @PostMapping(value = "/pwd/reset")
//  @HystrixCommand(
//          // 指定熔断后返回函数
//          fallbackMethod = "pwdResetFallback",
//          commandProperties = {
//          @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"), //统计窗口时间
//          @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //启用熔断功能
//          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),  //20个请求失败触发熔断
//          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //请求错误率超过60%触发熔断
//          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "300000"),//熔断后开始尝试恢复的时间
//  }
//  )
  // 因为controller类上面已经添加@DefaultProperties(defaultFallback = "commonFallbackMethod")
  // 指定所有返回了，所以只需要直接添加这个注解即可
  @HystrixCommand
  public AjaxResponse pwdreset(@RequestParam Integer userId) {
    sysuserService.pwdreset(userId);
    return AjaxResponse.success("重置密码成功!");
  }

  @PostMapping(value = "/pwd/isdefault")
  public Boolean isdefault(@RequestParam String username) {

    return sysuserService.isdefault(username);
  }

  @PostMapping(value = "/pwd/change")
  public AjaxResponse pwdchange(@RequestParam String username,
                                @RequestParam String oldPass,
                                @RequestParam String newPass) {
    sysuserService.changePwd(username,oldPass,newPass);
    return AjaxResponse.success("修改密码成功!");
  }

  // 指定fallback
    public AjaxResponse pwdResetFallback(@RequestParam Integer userId) {
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR,"系统繁忙!");
    }

}
