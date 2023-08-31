package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebeizhejiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebeizhejiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeizhejiuView;


/**
 * 设备折旧
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ShebeizhejiuService extends IService<ShebeizhejiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeizhejiuVO> selectListVO(Wrapper<ShebeizhejiuEntity> wrapper);
   	
   	ShebeizhejiuVO selectVO(@Param("ew") Wrapper<ShebeizhejiuEntity> wrapper);
   	
   	List<ShebeizhejiuView> selectListView(Wrapper<ShebeizhejiuEntity> wrapper);
   	
   	ShebeizhejiuView selectView(@Param("ew") Wrapper<ShebeizhejiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeizhejiuEntity> wrapper);
   	

}

