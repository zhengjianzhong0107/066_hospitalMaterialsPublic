package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieguogongshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JieguogongshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JieguogongshiView;


/**
 * 结果公示
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface JieguogongshiService extends IService<JieguogongshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JieguogongshiVO> selectListVO(Wrapper<JieguogongshiEntity> wrapper);
   	
   	JieguogongshiVO selectVO(@Param("ew") Wrapper<JieguogongshiEntity> wrapper);
   	
   	List<JieguogongshiView> selectListView(Wrapper<JieguogongshiEntity> wrapper);
   	
   	JieguogongshiView selectView(@Param("ew") Wrapper<JieguogongshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JieguogongshiEntity> wrapper);
   	

}

