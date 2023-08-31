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


import com.dao.ZhaobiaogonggaoDao;
import com.entity.ZhaobiaogonggaoEntity;
import com.service.ZhaobiaogonggaoService;
import com.entity.vo.ZhaobiaogonggaoVO;
import com.entity.view.ZhaobiaogonggaoView;

@Service("zhaobiaogonggaoService")
public class ZhaobiaogonggaoServiceImpl extends ServiceImpl<ZhaobiaogonggaoDao, ZhaobiaogonggaoEntity> implements ZhaobiaogonggaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaobiaogonggaoEntity> page = this.selectPage(
                new Query<ZhaobiaogonggaoEntity>(params).getPage(),
                new EntityWrapper<ZhaobiaogonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaogonggaoEntity> wrapper) {
		  Page<ZhaobiaogonggaoView> page =new Query<ZhaobiaogonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhaobiaogonggaoVO> selectListVO(Wrapper<ZhaobiaogonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhaobiaogonggaoVO selectVO(Wrapper<ZhaobiaogonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhaobiaogonggaoView> selectListView(Wrapper<ZhaobiaogonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaobiaogonggaoView selectView(Wrapper<ZhaobiaogonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
