package com.dao;

import com.entity.ZhaobiaogonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhaobiaogonggaoVO;
import com.entity.view.ZhaobiaogonggaoView;


/**
 * 招标公告
 * 
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
public interface ZhaobiaogonggaoDao extends BaseMapper<ZhaobiaogonggaoEntity> {
	
	List<ZhaobiaogonggaoVO> selectListVO(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);
	
	ZhaobiaogonggaoVO selectVO(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);
	
	List<ZhaobiaogonggaoView> selectListView(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);

	List<ZhaobiaogonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);
	
	ZhaobiaogonggaoView selectView(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);
	

}
