package com.dao;

import com.entity.YubeizhanghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YubeizhanghuVO;
import com.entity.view.YubeizhanghuView;


/**
 * 预备账户
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface YubeizhanghuDao extends BaseMapper<YubeizhanghuEntity> {
	
	List<YubeizhanghuVO> selectListVO(@Param("ew") Wrapper<YubeizhanghuEntity> wrapper);
	
	YubeizhanghuVO selectVO(@Param("ew") Wrapper<YubeizhanghuEntity> wrapper);
	
	List<YubeizhanghuView> selectListView(@Param("ew") Wrapper<YubeizhanghuEntity> wrapper);

	List<YubeizhanghuView> selectListView(Pagination page,@Param("ew") Wrapper<YubeizhanghuEntity> wrapper);
	
	YubeizhanghuView selectView(@Param("ew") Wrapper<YubeizhanghuEntity> wrapper);
	

}
