package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TiaomaweihuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TiaomaweihuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TiaomaweihuView;


/**
 * 条码维护
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface TiaomaweihuService extends IService<TiaomaweihuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TiaomaweihuVO> selectListVO(Wrapper<TiaomaweihuEntity> wrapper);
   	
   	TiaomaweihuVO selectVO(@Param("ew") Wrapper<TiaomaweihuEntity> wrapper);
   	
   	List<TiaomaweihuView> selectListView(Wrapper<TiaomaweihuEntity> wrapper);
   	
   	TiaomaweihuView selectView(@Param("ew") Wrapper<TiaomaweihuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TiaomaweihuEntity> wrapper);
   	

}

