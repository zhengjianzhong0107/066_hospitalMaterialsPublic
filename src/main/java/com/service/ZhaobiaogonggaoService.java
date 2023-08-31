package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaobiaogonggaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhaobiaogonggaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaobiaogonggaoView;


/**
 * 招标公告
 *
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ZhaobiaogonggaoService extends IService<ZhaobiaogonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaobiaogonggaoVO> selectListVO(Wrapper<ZhaobiaogonggaoEntity> wrapper);
   	
   	ZhaobiaogonggaoVO selectVO(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);
   	
   	List<ZhaobiaogonggaoView> selectListView(Wrapper<ZhaobiaogonggaoEntity> wrapper);
   	
   	ZhaobiaogonggaoView selectView(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaobiaogonggaoEntity> wrapper);
   	

}

