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

import com.entity.TiaomaweihuEntity;
import com.entity.view.TiaomaweihuView;

import com.service.TiaomaweihuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 条码维护
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
@RestController
@RequestMapping("/tiaomaweihu")
public class TiaomaweihuController {
    @Autowired
    private TiaomaweihuService tiaomaweihuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TiaomaweihuEntity tiaomaweihu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("gongyingshang")) {
			tiaomaweihu.setGongyingshangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yiyuan")) {
			tiaomaweihu.setYiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TiaomaweihuEntity> ew = new EntityWrapper<TiaomaweihuEntity>();

		PageUtils page = tiaomaweihuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiaomaweihu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TiaomaweihuEntity tiaomaweihu, 
		HttpServletRequest request){
        EntityWrapper<TiaomaweihuEntity> ew = new EntityWrapper<TiaomaweihuEntity>();

		PageUtils page = tiaomaweihuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiaomaweihu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TiaomaweihuEntity tiaomaweihu){
       	EntityWrapper<TiaomaweihuEntity> ew = new EntityWrapper<TiaomaweihuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tiaomaweihu, "tiaomaweihu")); 
        return R.ok().put("data", tiaomaweihuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TiaomaweihuEntity tiaomaweihu){
        EntityWrapper< TiaomaweihuEntity> ew = new EntityWrapper< TiaomaweihuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tiaomaweihu, "tiaomaweihu")); 
		TiaomaweihuView tiaomaweihuView =  tiaomaweihuService.selectView(ew);
		return R.ok("查询条码维护成功").put("data", tiaomaweihuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TiaomaweihuEntity tiaomaweihu = tiaomaweihuService.selectById(id);
        return R.ok().put("data", tiaomaweihu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TiaomaweihuEntity tiaomaweihu = tiaomaweihuService.selectById(id);
        return R.ok().put("data", tiaomaweihu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TiaomaweihuEntity tiaomaweihu, HttpServletRequest request){
    	tiaomaweihu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tiaomaweihu);
        tiaomaweihuService.insert(tiaomaweihu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TiaomaweihuEntity tiaomaweihu, HttpServletRequest request){
    	tiaomaweihu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tiaomaweihu);
        tiaomaweihuService.insert(tiaomaweihu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TiaomaweihuEntity tiaomaweihu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tiaomaweihu);
        tiaomaweihuService.updateById(tiaomaweihu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tiaomaweihuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<TiaomaweihuEntity> wrapper = new EntityWrapper<TiaomaweihuEntity>();
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

		int count = tiaomaweihuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
