package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZichanzhuankeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZichanzhuankeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZichanzhuankeView;


/**
 * 资产转科
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ZichanzhuankeService extends IService<ZichanzhuankeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZichanzhuankeVO> selectListVO(Wrapper<ZichanzhuankeEntity> wrapper);
   	
   	ZichanzhuankeVO selectVO(@Param("ew") Wrapper<ZichanzhuankeEntity> wrapper);
   	
   	List<ZichanzhuankeView> selectListView(Wrapper<ZichanzhuankeEntity> wrapper);
   	
   	ZichanzhuankeView selectView(@Param("ew") Wrapper<ZichanzhuankeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZichanzhuankeEntity> wrapper);
   	

}

