package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HetongqiandingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HetongqiandingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HetongqiandingView;


/**
 * 合同签订
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface HetongqiandingService extends IService<HetongqiandingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HetongqiandingVO> selectListVO(Wrapper<HetongqiandingEntity> wrapper);
   	
   	HetongqiandingVO selectVO(@Param("ew") Wrapper<HetongqiandingEntity> wrapper);
   	
   	List<HetongqiandingView> selectListView(Wrapper<HetongqiandingEntity> wrapper);
   	
   	HetongqiandingView selectView(@Param("ew") Wrapper<HetongqiandingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HetongqiandingEntity> wrapper);
   	

}

