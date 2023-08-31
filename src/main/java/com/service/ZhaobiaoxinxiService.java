package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaobiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhaobiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaobiaoxinxiView;


/**
 * 招标信息
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ZhaobiaoxinxiService extends IService<ZhaobiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaobiaoxinxiVO> selectListVO(Wrapper<ZhaobiaoxinxiEntity> wrapper);
   	
   	ZhaobiaoxinxiVO selectVO(@Param("ew") Wrapper<ZhaobiaoxinxiEntity> wrapper);
   	
   	List<ZhaobiaoxinxiView> selectListView(Wrapper<ZhaobiaoxinxiEntity> wrapper);
   	
   	ZhaobiaoxinxiView selectView(@Param("ew") Wrapper<ZhaobiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaobiaoxinxiEntity> wrapper);
   	

}

