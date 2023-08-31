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


import com.dao.HetongqiandingDao;
import com.entity.HetongqiandingEntity;
import com.service.HetongqiandingService;
import com.entity.vo.HetongqiandingVO;
import com.entity.view.HetongqiandingView;

@Service("hetongqiandingService")
public class HetongqiandingServiceImpl extends ServiceImpl<HetongqiandingDao, HetongqiandingEntity> implements HetongqiandingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HetongqiandingEntity> page = this.selectPage(
                new Query<HetongqiandingEntity>(params).getPage(),
                new EntityWrapper<HetongqiandingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HetongqiandingEntity> wrapper) {
		  Page<HetongqiandingView> page =new Query<HetongqiandingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HetongqiandingVO> selectListVO(Wrapper<HetongqiandingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HetongqiandingVO selectVO(Wrapper<HetongqiandingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HetongqiandingView> selectListView(Wrapper<HetongqiandingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HetongqiandingView selectView(Wrapper<HetongqiandingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
