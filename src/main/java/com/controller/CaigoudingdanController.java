package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CaigoudingdanEntity;
import com.entity.view.CaigoudingdanView;

import com.service.CaigoudingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 采购订单
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
@RestController
@RequestMapping("/caigoudingdan")
public class CaigoudingdanController {
    @Autowired
    private CaigoudingdanService caigoudingdanService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaigoudingdanEntity caigoudingdan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongyingshang")) {
			caigoudingdan.setGongyingshangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yiyuan")) {
			caigoudingdan.setYiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CaigoudingdanEntity> ew = new EntityWrapper<CaigoudingdanEntity>();

		PageUtils page = caigoudingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caigoudingdan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaigoudingdanEntity caigoudingdan, 
		HttpServletRequest request){
        EntityWrapper<CaigoudingdanEntity> ew = new EntityWrapper<CaigoudingdanEntity>();

		PageUtils page = caigoudingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caigoudingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaigoudingdanEntity caigoudingdan){
       	EntityWrapper<CaigoudingdanEntity> ew = new EntityWrapper<CaigoudingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caigoudingdan, "caigoudingdan")); 
        return R.ok().put("data", caigoudingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaigoudingdanEntity caigoudingdan){
        EntityWrapper< CaigoudingdanEntity> ew = new EntityWrapper< CaigoudingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caigoudingdan, "caigoudingdan")); 
		CaigoudingdanView caigoudingdanView =  caigoudingdanService.selectView(ew);
		return R.ok("查询采购订单成功").put("data", caigoudingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaigoudingdanEntity caigoudingdan = caigoudingdanService.selectById(id);
        return R.ok().put("data", caigoudingdan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaigoudingdanEntity caigoudingdan = caigoudingdanService.selectById(id);
        return R.ok().put("data", caigoudingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaigoudingdanEntity caigoudingdan, HttpServletRequest request){
    	caigoudingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caigoudingdan);
        caigoudingdanService.insert(caigoudingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaigoudingdanEntity caigoudingdan, HttpServletRequest request){
    	caigoudingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caigoudingdan);
        caigoudingdanService.insert(caigoudingdan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaigoudingdanEntity caigoudingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caigoudingdan);
        caigoudingdanService.updateById(caigoudingdan);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caigoudingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<CaigoudingdanEntity> wrapper = new EntityWrapper<CaigoudingdanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongyingshang")) {
			wrapper.eq("gongyingshangzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yiyuan")) {
			wrapper.eq("yiyuanzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = caigoudingdanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
