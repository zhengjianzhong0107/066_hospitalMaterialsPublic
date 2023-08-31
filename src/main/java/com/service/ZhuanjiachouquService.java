package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuanjiachouquEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuanjiachouquVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuanjiachouquView;


/**
 * 专家抽取
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ZhuanjiachouquService extends IService<ZhuanjiachouquEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuanjiachouquVO> selectListVO(Wrapper<ZhuanjiachouquEntity> wrapper);
   	
   	ZhuanjiachouquVO selectVO(@Param("ew") Wrapper<ZhuanjiachouquEntity> wrapper);
   	
   	List<ZhuanjiachouquView> selectListView(Wrapper<ZhuanjiachouquEntity> wrapper);
   	
   	ZhuanjiachouquView selectView(@Param("ew") Wrapper<ZhuanjiachouquEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuanjiachouquEntity> wrapper);
   	

}

