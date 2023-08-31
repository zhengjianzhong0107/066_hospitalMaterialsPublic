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


import com.dao.ZhaobiaoxinxiDao;
import com.entity.ZhaobiaoxinxiEntity;
import com.service.ZhaobiaoxinxiService;
import com.entity.vo.ZhaobiaoxinxiVO;
import com.entity.view.ZhaobiaoxinxiView;

@Service("zhaobiaoxinxiService")
public class ZhaobiaoxinxiServiceImpl extends ServiceImpl<ZhaobiaoxinxiDao, ZhaobiaoxinxiEntity> implements ZhaobiaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaobiaoxinxiEntity> page = this.selectPage(
                new Query<ZhaobiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhaobiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaoxinxiEntity> wrapper) {
		  Page<ZhaobiaoxinxiView> page =new Query<ZhaobiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhaobiaoxinxiVO> selectListVO(Wrapper<ZhaobiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhaobiaoxinxiVO selectVO(Wrapper<ZhaobiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhaobiaoxinxiView> selectListView(Wrapper<ZhaobiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaobiaoxinxiView selectView(Wrapper<ZhaobiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
