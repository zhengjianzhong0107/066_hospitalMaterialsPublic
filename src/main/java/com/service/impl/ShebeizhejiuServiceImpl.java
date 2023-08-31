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


import com.dao.ShebeizhejiuDao;
import com.entity.ShebeizhejiuEntity;
import com.service.ShebeizhejiuService;
import com.entity.vo.ShebeizhejiuVO;
import com.entity.view.ShebeizhejiuView;

@Service("shebeizhejiuService")
public class ShebeizhejiuServiceImpl extends ServiceImpl<ShebeizhejiuDao, ShebeizhejiuEntity> implements ShebeizhejiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeizhejiuEntity> page = this.selectPage(
                new Query<ShebeizhejiuEntity>(params).getPage(),
                new EntityWrapper<ShebeizhejiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeizhejiuEntity> wrapper) {
		  Page<ShebeizhejiuView> page =new Query<ShebeizhejiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeizhejiuVO> selectListVO(Wrapper<ShebeizhejiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeizhejiuVO selectVO(Wrapper<ShebeizhejiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeizhejiuView> selectListView(Wrapper<ShebeizhejiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeizhejiuView selectView(Wrapper<ShebeizhejiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
