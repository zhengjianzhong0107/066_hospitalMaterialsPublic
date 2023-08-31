package com.dao;

import com.entity.CaigoudingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaigoudingdanVO;
import com.entity.view.CaigoudingdanView;


/**
 * 采购订单
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface CaigoudingdanDao extends BaseMapper<CaigoudingdanEntity> {
	
	List<CaigoudingdanVO> selectListVO(@Param("ew") Wrapper<CaigoudingdanEntity> wrapper);
	
	CaigoudingdanVO selectVO(@Param("ew") Wrapper<CaigoudingdanEntity> wrapper);
	
	List<CaigoudingdanView> selectListView(@Param("ew") Wrapper<CaigoudingdanEntity> wrapper);

	List<CaigoudingdanView> selectListView(Pagination page,@Param("ew") Wrapper<CaigoudingdanEntity> wrapper);
	
	CaigoudingdanView selectView(@Param("ew") Wrapper<CaigoudingdanEntity> wrapper);
	

}
