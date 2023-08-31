package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YubeizhanghuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YubeizhanghuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YubeizhanghuView;


/**
 * 预备账户
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface YubeizhanghuService extends IService<YubeizhanghuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YubeizhanghuVO> selectListVO(Wrapper<YubeizhanghuEntity> wrapper);
   	
   	YubeizhanghuVO selectVO(@Param("ew") Wrapper<YubeizhanghuEntity> wrapper);
   	
   	List<YubeizhanghuView> selectListView(Wrapper<YubeizhanghuEntity> wrapper);
   	
   	YubeizhanghuView selectView(@Param("ew") Wrapper<YubeizhanghuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YubeizhanghuEntity> wrapper);
   	

}

