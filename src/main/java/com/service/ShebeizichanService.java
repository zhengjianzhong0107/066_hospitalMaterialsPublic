package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebeizichanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebeizichanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeizichanView;


/**
 * 设备资产
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ShebeizichanService extends IService<ShebeizichanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeizichanVO> selectListVO(Wrapper<ShebeizichanEntity> wrapper);
   	
   	ShebeizichanVO selectVO(@Param("ew") Wrapper<ShebeizichanEntity> wrapper);
   	
   	List<ShebeizichanView> selectListView(Wrapper<ShebeizichanEntity> wrapper);
   	
   	ShebeizichanView selectView(@Param("ew") Wrapper<ShebeizichanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeizichanEntity> wrapper);
   	

}

