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


import com.dao.TiaomaweihuDao;
import com.entity.TiaomaweihuEntity;
import com.service.TiaomaweihuService;
import com.entity.vo.TiaomaweihuVO;
import com.entity.view.TiaomaweihuView;

@Service("tiaomaweihuService")
public class TiaomaweihuServiceImpl extends ServiceImpl<TiaomaweihuDao, TiaomaweihuEntity> implements TiaomaweihuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TiaomaweihuEntity> page = this.selectPage(
                new Query<TiaomaweihuEntity>(params).getPage(),
                new EntityWrapper<TiaomaweihuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TiaomaweihuEntity> wrapper) {
		  Page<TiaomaweihuView> page =new Query<TiaomaweihuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TiaomaweihuVO> selectListVO(Wrapper<TiaomaweihuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TiaomaweihuVO selectVO(Wrapper<TiaomaweihuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TiaomaweihuView> selectListView(Wrapper<TiaomaweihuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TiaomaweihuView selectView(Wrapper<TiaomaweihuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
