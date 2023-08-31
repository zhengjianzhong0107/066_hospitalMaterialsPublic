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

import com.entity.ZhaobiaogonggaoEntity;
import com.entity.view.ZhaobiaogonggaoView;

import com.service.ZhaobiaogonggaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 招标公告
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
@RestController
@RequestMapping("/zhaobiaogonggao")
public class ZhaobiaogonggaoController {
    @Autowired
    private ZhaobiaogonggaoService zhaobiaogonggaoService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhaobiaogonggaoEntity zhaobiaogonggao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yiyuan")) {
			zhaobiaogonggao.setYiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhaobiaogonggaoEntity> ew = new EntityWrapper<ZhaobiaogonggaoEntity>();

		PageUtils page = zhaobiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaogonggao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhaobiaogonggaoEntity zhaobiaogonggao, 
		HttpServletRequest request){
        EntityWrapper<ZhaobiaogonggaoEntity> ew = new EntityWrapper<ZhaobiaogonggaoEntity>();

		PageUtils page = zhaobiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaogonggao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhaobiaogonggaoEntity zhaobiaogonggao){
       	EntityWrapper<ZhaobiaogonggaoEntity> ew = new EntityWrapper<ZhaobiaogonggaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhaobiaogonggao, "zhaobiaogonggao")); 
        return R.ok().put("data", zhaobiaogonggaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaobiaogonggaoEntity zhaobiaogonggao){
        EntityWrapper< ZhaobiaogonggaoEntity> ew = new EntityWrapper< ZhaobiaogonggaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhaobiaogonggao, "zhaobiaogonggao")); 
		ZhaobiaogonggaoView zhaobiaogonggaoView =  zhaobiaogonggaoService.selectView(ew);
		return R.ok("查询招标公告成功").put("data", zhaobiaogonggaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhaobiaogonggaoEntity zhaobiaogonggao = zhaobiaogonggaoService.selectById(id);
		zhaobiaogonggao.setClicknum(zhaobiaogonggao.getClicknum()+1);
		zhaobiaogonggao.setClicktime(new Date());
		zhaobiaogonggaoService.updateById(zhaobiaogonggao);
        return R.ok().put("data", zhaobiaogonggao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhaobiaogonggaoEntity zhaobiaogonggao = zhaobiaogonggaoService.selectById(id);
		zhaobiaogonggao.setClicknum(zhaobiaogonggao.getClicknum()+1);
		zhaobiaogonggao.setClicktime(new Date());
		zhaobiaogonggaoService.updateById(zhaobiaogonggao);
        return R.ok().put("data", zhaobiaogonggao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaobiaogonggaoEntity zhaobiaogonggao, HttpServletRequest request){
    	zhaobiaogonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaobiaogonggao);
        zhaobiaogonggaoService.insert(zhaobiaogonggao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaobiaogonggaoEntity zhaobiaogonggao, HttpServletRequest request){
    	zhaobiaogonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaobiaogonggao);
        zhaobiaogonggaoService.insert(zhaobiaogonggao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaobiaogonggaoEntity zhaobiaogonggao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhaobiaogonggao);
        zhaobiaogonggaoService.updateById(zhaobiaogonggao);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhaobiaogonggaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhaobiaogonggaoEntity> wrapper = new EntityWrapper<ZhaobiaogonggaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yiyuan")) {
			wrapper.eq("yiyuanzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zhaobiaogonggaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhaobiaogonggaoEntity zhaobiaogonggao, HttpServletRequest request,String pre){
        EntityWrapper<ZhaobiaogonggaoEntity> ew = new EntityWrapper<ZhaobiaogonggaoEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = zhaobiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaobiaogonggao), params), params));
        return R.ok().put("data", page);
    }









}
