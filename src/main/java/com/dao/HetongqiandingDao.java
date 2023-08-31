package com.dao;

import com.entity.HetongqiandingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HetongqiandingVO;
import com.entity.view.HetongqiandingView;


/**
 * 合同签订
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface HetongqiandingDao extends BaseMapper<HetongqiandingEntity> {
	
	List<HetongqiandingVO> selectListVO(@Param("ew") Wrapper<HetongqiandingEntity> wrapper);
	
	HetongqiandingVO selectVO(@Param("ew") Wrapper<HetongqiandingEntity> wrapper);
	
	List<HetongqiandingView> selectListView(@Param("ew") Wrapper<HetongqiandingEntity> wrapper);

	List<HetongqiandingView> selectListView(Pagination page,@Param("ew") Wrapper<HetongqiandingEntity> wrapper);
	
	HetongqiandingView selectView(@Param("ew") Wrapper<HetongqiandingEntity> wrapper);
	

}
