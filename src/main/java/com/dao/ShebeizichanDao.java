package com.dao;

import com.entity.ShebeizichanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeizichanVO;
import com.entity.view.ShebeizichanView;


/**
 * 设备资产
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ShebeizichanDao extends BaseMapper<ShebeizichanEntity> {
	
	List<ShebeizichanVO> selectListVO(@Param("ew") Wrapper<ShebeizichanEntity> wrapper);
	
	ShebeizichanVO selectVO(@Param("ew") Wrapper<ShebeizichanEntity> wrapper);
	
	List<ShebeizichanView> selectListView(@Param("ew") Wrapper<ShebeizichanEntity> wrapper);

	List<ShebeizichanView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeizichanEntity> wrapper);
	
	ShebeizichanView selectView(@Param("ew") Wrapper<ShebeizichanEntity> wrapper);
	

}
