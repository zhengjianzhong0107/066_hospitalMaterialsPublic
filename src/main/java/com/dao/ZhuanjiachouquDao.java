package com.dao;

import com.entity.ZhuanjiachouquEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuanjiachouquVO;
import com.entity.view.ZhuanjiachouquView;


/**
 * 专家抽取
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ZhuanjiachouquDao extends BaseMapper<ZhuanjiachouquEntity> {
	
	List<ZhuanjiachouquVO> selectListVO(@Param("ew") Wrapper<ZhuanjiachouquEntity> wrapper);
	
	ZhuanjiachouquVO selectVO(@Param("ew") Wrapper<ZhuanjiachouquEntity> wrapper);
	
	List<ZhuanjiachouquView> selectListView(@Param("ew") Wrapper<ZhuanjiachouquEntity> wrapper);

	List<ZhuanjiachouquView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuanjiachouquEntity> wrapper);
	
	ZhuanjiachouquView selectView(@Param("ew") Wrapper<ZhuanjiachouquEntity> wrapper);
	

}
