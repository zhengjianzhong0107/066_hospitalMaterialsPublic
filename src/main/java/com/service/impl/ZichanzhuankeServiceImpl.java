package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZichanzhuankeDao;
import com.entity.ZichanzhuankeEntity;
import com.service.ZichanzhuankeService;
import com.entity.vo.ZichanzhuankeVO;
import com.entity.view.ZichanzhuankeView;

@Service("zichanzhuankeService")
public class ZichanzhuankeServiceImpl extends ServiceImpl<ZichanzhuankeDao, ZichanzhuankeEntity> implements ZichanzhuankeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZichanzhuankeEntity> page = this.selectPage(
                new Query<ZichanzhuankeEntity>(params).getPage(),
                new EntityWrapper<ZichanzhuankeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZichanzhuankeEntity> wrapper) {
		  Page<ZichanzhuankeView> page =new Query<ZichanzhuankeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZichanzhuankeVO> selectListVO(Wrapper<ZichanzhuankeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZichanzhuankeVO selectVO(Wrapper<ZichanzhuankeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZichanzhuankeView> selectListView(Wrapper<ZichanzhuankeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZichanzhuankeView selectView(Wrapper<ZichanzhuankeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
