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


import com.dao.ShebeizichanDao;
import com.entity.ShebeizichanEntity;
import com.service.ShebeizichanService;
import com.entity.vo.ShebeizichanVO;
import com.entity.view.ShebeizichanView;

@Service("shebeizichanService")
public class ShebeizichanServiceImpl extends ServiceImpl<ShebeizichanDao, ShebeizichanEntity> implements ShebeizichanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeizichanEntity> page = this.selectPage(
                new Query<ShebeizichanEntity>(params).getPage(),
                new EntityWrapper<ShebeizichanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeizichanEntity> wrapper) {
		  Page<ShebeizichanView> page =new Query<ShebeizichanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeizichanVO> selectListVO(Wrapper<ShebeizichanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeizichanVO selectVO(Wrapper<ShebeizichanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeizichanView> selectListView(Wrapper<ShebeizichanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeizichanView selectView(Wrapper<ShebeizichanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
