package com.dao;

import com.entity.TiaomaweihuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TiaomaweihuVO;
import com.entity.view.TiaomaweihuView;


/**
 * 条码维护
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface TiaomaweihuDao extends BaseMapper<TiaomaweihuEntity> {
	
	List<TiaomaweihuVO> selectListVO(@Param("ew") Wrapper<TiaomaweihuEntity> wrapper);
	
	TiaomaweihuVO selectVO(@Param("ew") Wrapper<TiaomaweihuEntity> wrapper);
	
	List<TiaomaweihuView> selectListView(@Param("ew") Wrapper<TiaomaweihuEntity> wrapper);

	List<TiaomaweihuView> selectListView(Pagination page,@Param("ew") Wrapper<TiaomaweihuEntity> wrapper);
	
	TiaomaweihuView selectView(@Param("ew") Wrapper<TiaomaweihuEntity> wrapper);
	

}
