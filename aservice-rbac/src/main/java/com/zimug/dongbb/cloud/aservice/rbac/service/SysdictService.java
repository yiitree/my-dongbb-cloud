package com.zimug.dongbb.cloud.aservice.rbac.service;

import com.zimug.dongbb.cloud.starter.persistence.auto.mapper.SysDictMapper;
import com.zimug.dongbb.cloud.starter.persistence.auto.model.SysDict;
import com.zimug.dongbb.cloud.starter.persistence.auto.model.SysDictExample;
import com.zimug.dongbb.cloud.starter.web.exception.CustomException;
import com.zimug.dongbb.cloud.starter.web.exception.CustomExceptionType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysdictService {

  @Resource
  private SysDictMapper sysDictMapper;

  //获取所有的数据字段数据
  public List<SysDict> all(){
    return  sysDictMapper.selectByExample(null);
  }


  public List<SysDict> queryDicts(String dictLik) {
    SysDictExample sysDictExample = new SysDictExample();
    if(!StringUtils.isEmpty(dictLik)){
      sysDictExample.or().andGroupNameLike("%"+ dictLik+ "%");
      sysDictExample.or().andGroupCodeLike("%"+ dictLik+ "%");
    }
    return sysDictMapper.selectByExample(sysDictExample);
  }

  public void updateDict(SysDict sysdict){
    if(sysdict.getId() == null){
      throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,
        "修改操作必须带主键");
    }else{
      sysDictMapper.updateByPrimaryKeySelective(sysdict);
    }
  }

  public void addDict(SysDict sysdict){
    sysdict.setCreateTime(new Date());
    sysDictMapper.insert(sysdict);
  }

  public void deleteDict(Integer dictId){
    sysDictMapper.deleteByPrimaryKey(dictId);
  }

}
