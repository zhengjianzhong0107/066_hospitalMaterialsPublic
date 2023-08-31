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


import com.dao.ZhuanjiachouquDao;
import com.entity.ZhuanjiachouquEntity;
import com.service.ZhuanjiachouquService;
import com.entity.vo.ZhuanjiachouquVO;
import com.entity.view.ZhuanjiachouquView;

@Service("zhuanjiachouquService")
public class ZhuanjiachouquServiceImpl extends ServiceImpl<ZhuanjiachouquDao, ZhuanjiachouquEntity> implements ZhuanjiachouquService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanjiachouquEntity> page = this.selectPage(
                new Query<ZhuanjiachouquEntity>(params).getPage(),
                new EntityWrapper<ZhuanjiachouquEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuanjiachouquEntity> wrapper) {
		  Page<ZhuanjiachouquView> page =new Query<ZhuanjiachouquView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuanjiachouquVO> selectListVO(Wrapper<ZhuanjiachouquEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanjiachouquVO selectVO(Wrapper<ZhuanjiachouquEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanjiachouquView> selectListView(Wrapper<ZhuanjiachouquEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanjiachouquView selectView(Wrapper<ZhuanjiachouquEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
