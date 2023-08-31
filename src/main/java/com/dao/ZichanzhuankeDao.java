package com.dao;

import com.entity.ZichanzhuankeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZichanzhuankeVO;
import com.entity.view.ZichanzhuankeView;


/**
 * 资产转科
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ZichanzhuankeDao extends BaseMapper<ZichanzhuankeEntity> {
	
	List<ZichanzhuankeVO> selectListVO(@Param("ew") Wrapper<ZichanzhuankeEntity> wrapper);
	
	ZichanzhuankeVO selectVO(@Param("ew") Wrapper<ZichanzhuankeEntity> wrapper);
	
	List<ZichanzhuankeView> selectListView(@Param("ew") Wrapper<ZichanzhuankeEntity> wrapper);

	List<ZichanzhuankeView> selectListView(Pagination page,@Param("ew") Wrapper<ZichanzhuankeEntity> wrapper);
	
	ZichanzhuankeView selectView(@Param("ew") Wrapper<ZichanzhuankeEntity> wrapper);
	

}
