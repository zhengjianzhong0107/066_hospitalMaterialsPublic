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


import com.dao.YubeizhanghuDao;
import com.entity.YubeizhanghuEntity;
import com.service.YubeizhanghuService;
import com.entity.vo.YubeizhanghuVO;
import com.entity.view.YubeizhanghuView;

@Service("yubeizhanghuService")
public class YubeizhanghuServiceImpl extends ServiceImpl<YubeizhanghuDao, YubeizhanghuEntity> implements YubeizhanghuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YubeizhanghuEntity> page = this.selectPage(
                new Query<YubeizhanghuEntity>(params).getPage(),
                new EntityWrapper<YubeizhanghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YubeizhanghuEntity> wrapper) {
		  Page<YubeizhanghuView> page =new Query<YubeizhanghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YubeizhanghuVO> selectListVO(Wrapper<YubeizhanghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YubeizhanghuVO selectVO(Wrapper<YubeizhanghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YubeizhanghuView> selectListView(Wrapper<YubeizhanghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YubeizhanghuView selectView(Wrapper<YubeizhanghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
