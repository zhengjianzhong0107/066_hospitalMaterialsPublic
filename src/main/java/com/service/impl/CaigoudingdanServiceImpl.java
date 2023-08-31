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


import com.dao.CaigoudingdanDao;
import com.entity.CaigoudingdanEntity;
import com.service.CaigoudingdanService;
import com.entity.vo.CaigoudingdanVO;
import com.entity.view.CaigoudingdanView;

@Service("caigoudingdanService")
public class CaigoudingdanServiceImpl extends ServiceImpl<CaigoudingdanDao, CaigoudingdanEntity> implements CaigoudingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaigoudingdanEntity> page = this.selectPage(
                new Query<CaigoudingdanEntity>(params).getPage(),
                new EntityWrapper<CaigoudingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaigoudingdanEntity> wrapper) {
		  Page<CaigoudingdanView> page =new Query<CaigoudingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaigoudingdanVO> selectListVO(Wrapper<CaigoudingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaigoudingdanVO selectVO(Wrapper<CaigoudingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaigoudingdanView> selectListView(Wrapper<CaigoudingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaigoudingdanView selectView(Wrapper<CaigoudingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
