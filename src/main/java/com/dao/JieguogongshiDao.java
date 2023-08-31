package com.dao;

import com.entity.JieguogongshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JieguogongshiVO;
import com.entity.view.JieguogongshiView;


/**
 * 结果公示
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface JieguogongshiDao extends BaseMapper<JieguogongshiEntity> {
	
	List<JieguogongshiVO> selectListVO(@Param("ew") Wrapper<JieguogongshiEntity> wrapper);
	
	JieguogongshiVO selectVO(@Param("ew") Wrapper<JieguogongshiEntity> wrapper);
	
	List<JieguogongshiView> selectListView(@Param("ew") Wrapper<JieguogongshiEntity> wrapper);

	List<JieguogongshiView> selectListView(Pagination page,@Param("ew") Wrapper<JieguogongshiEntity> wrapper);
	
	JieguogongshiView selectView(@Param("ew") Wrapper<JieguogongshiEntity> wrapper);
	

}
