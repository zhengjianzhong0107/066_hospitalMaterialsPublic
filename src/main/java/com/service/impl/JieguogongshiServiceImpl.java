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


import com.dao.JieguogongshiDao;
import com.entity.JieguogongshiEntity;
import com.service.JieguogongshiService;
import com.entity.vo.JieguogongshiVO;
import com.entity.view.JieguogongshiView;

@Service("jieguogongshiService")
public class JieguogongshiServiceImpl extends ServiceImpl<JieguogongshiDao, JieguogongshiEntity> implements JieguogongshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JieguogongshiEntity> page = this.selectPage(
                new Query<JieguogongshiEntity>(params).getPage(),
                new EntityWrapper<JieguogongshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JieguogongshiEntity> wrapper) {
		  Page<JieguogongshiView> page =new Query<JieguogongshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JieguogongshiVO> selectListVO(Wrapper<JieguogongshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JieguogongshiVO selectVO(Wrapper<JieguogongshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JieguogongshiView> selectListView(Wrapper<JieguogongshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JieguogongshiView selectView(Wrapper<JieguogongshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
