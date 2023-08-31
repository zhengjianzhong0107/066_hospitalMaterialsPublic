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

import com.entity.ShebeizichanEntity;
import com.entity.view.ShebeizichanView;

import com.service.ShebeizichanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 设备资产
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-10 19:54:46
 */
@RestController
@RequestMapping("/shebeizichan")
public class ShebeizichanController {
    @Autowired
    private ShebeizichanService shebeizichanService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeizichanEntity shebeizichan,
		HttpServletRequest request){
        EntityWrapper<ShebeizichanEntity> ew = new EntityWrapper<ShebeizichanEntity>();

		PageUtils page = shebeizichanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeizichan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebeizichanEntity shebeizichan, 
		HttpServletRequest request){
        EntityWrapper<ShebeizichanEntity> ew = new EntityWrapper<ShebeizichanEntity>();

		PageUtils page = shebeizichanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeizichan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeizichanEntity shebeizichan){
       	EntityWrapper<ShebeizichanEntity> ew = new EntityWrapper<ShebeizichanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeizichan, "shebeizichan")); 
        return R.ok().put("data", shebeizichanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeizichanEntity shebeizichan){
        EntityWrapper< ShebeizichanEntity> ew = new EntityWrapper< ShebeizichanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeizichan, "shebeizichan")); 
		ShebeizichanView shebeizichanView =  shebeizichanService.selectView(ew);
		return R.ok("查询设备资产成功").put("data", shebeizichanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeizichanEntity shebeizichan = shebeizichanService.selectById(id);
        return R.ok().put("data", shebeizichan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeizichanEntity shebeizichan = shebeizichanService.selectById(id);
        return R.ok().put("data", shebeizichan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeizichanEntity shebeizichan, HttpServletRequest request){
    	shebeizichan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shebeizichan);
        shebeizichanService.insert(shebeizichan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShebeizichanEntity shebeizichan, HttpServletRequest request){
    	shebeizichan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shebeizichan);
        shebeizichanService.insert(shebeizichan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShebeizichanEntity shebeizichan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeizichan);
        shebeizichanService.updateById(shebeizichan);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shebeizichanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ShebeizichanEntity> wrapper = new EntityWrapper<ShebeizichanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = shebeizichanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	





    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    ShebeizichanEntity shebeizichanEntity =new ShebeizichanEntity();
                    shebeizichanEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
                    String zichanbianhao = CommonUtil.getCellValue(row.getCell(0));
                    shebeizichanEntity.setZichanbianhao(zichanbianhao);
                    String zichanmingcheng = CommonUtil.getCellValue(row.getCell(1));
                    shebeizichanEntity.setZichanmingcheng(zichanmingcheng);
                    String shiyongbumen = CommonUtil.getCellValue(row.getCell(2));
                    shebeizichanEntity.setShiyongbumen(shiyongbumen);
                    String guigexinghao = CommonUtil.getCellValue(row.getCell(3));
                    shebeizichanEntity.setGuigexinghao(guigexinghao);
                    String shiyongnianxian = CommonUtil.getCellValue(row.getCell(4));
                    shebeizichanEntity.setShiyongnianxian(shiyongnianxian);
                    String zerenren = CommonUtil.getCellValue(row.getCell(5));
                    shebeizichanEntity.setZerenren(zerenren);
                     
                    //想数据库中添加新对象
                    shebeizichanService.insert(shebeizichanEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }




}
