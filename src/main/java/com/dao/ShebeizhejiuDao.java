package com.dao;

import com.entity.ShebeizhejiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeizhejiuVO;
import com.entity.view.ShebeizhejiuView;


/**
 * 设备折旧
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ShebeizhejiuDao extends BaseMapper<ShebeizhejiuEntity> {
	
	List<ShebeizhejiuVO> selectListVO(@Param("ew") Wrapper<ShebeizhejiuEntity> wrapper);
	
	ShebeizhejiuVO selectVO(@Param("ew") Wrapper<ShebeizhejiuEntity> wrapper);
	
	List<ShebeizhejiuView> selectListView(@Param("ew") Wrapper<ShebeizhejiuEntity> wrapper);

	List<ShebeizhejiuView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeizhejiuEntity> wrapper);
	
	ShebeizhejiuView selectView(@Param("ew") Wrapper<ShebeizhejiuEntity> wrapper);
	

}
