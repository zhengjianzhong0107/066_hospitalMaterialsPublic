<template>
  <div>
    <el-form
	  :style='{"padding":"30px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","margin":"-30px 0 0","borderRadius":"0 0 30px 30px","flexWrap":"wrap","background":"#F8F6F7","display":"flex","width":"100%"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="120px"
    >  
     <el-row>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='gongyingshang'"  label="供应商账号" prop="gongyingshangzhanghao">
          <el-input v-model="ruleForm.gongyingshangzhanghao" readonly              placeholder="供应商账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='gongyingshang'"  label="供应商名称" prop="gongyingshangmingcheng">
          <el-input v-model="ruleForm.gongyingshangmingcheng"               placeholder="供应商名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-if="flag=='gongyingshang'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="gongyingshangtupianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='gongyingshang'"  label="联系人" prop="lianxiren">
          <el-input v-model="ruleForm.lianxiren"               placeholder="联系人" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='gongyingshang'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='gongyingshang'"  label="供应商地址" prop="gongyingshangdizhi">
          <el-input v-model="ruleForm.gongyingshangdizhi"               placeholder="供应商地址" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'  v-if="flag=='gongyingshang'" label="资质证照" prop="zizhizhengzhao">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.zizhizhengzhao" 
                type="date"
                placeholder="资质证照">
            </el-date-picker> 
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='yiyuan'"  label="医院账号" prop="yiyuanzhanghao">
          <el-input v-model="ruleForm.yiyuanzhanghao" readonly              placeholder="医院账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='yiyuan'"  label="医院名称" prop="yiyuanmingcheng">
          <el-input v-model="ruleForm.yiyuanmingcheng"               placeholder="医院名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-if="flag=='yiyuan'" label="医院封面" prop="yiyuanfengmian">
          <file-upload
          tip="点击上传医院封面"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.yiyuanfengmian?ruleForm.yiyuanfengmian:''"
          @change="yiyuanyiyuanfengmianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='yiyuan'"  label="医院地址" prop="yiyuandizhi">
          <el-input v-model="ruleForm.yiyuandizhi"               placeholder="医院地址" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='yiyuan'"  label="医院等级" prop="yiyuandengji">
          <el-input v-model="ruleForm.yiyuandengji"               placeholder="医院等级" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}'   v-if="flag=='yiyuan'"  label="医院电话" prop="yiyuandianhua">
          <el-input v-model="ruleForm.yiyuandianhua"               placeholder="医院电话" clearable></el-input>
        </el-form-item>
		<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"width":"100%","padding":"0","margin":"0"}'>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"0","background":"#67D4B2","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">修 改</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
  },
  methods: {
    gongyingshangtupianUploadChange(fileUrls) {
        this.ruleForm.tupian = fileUrls;
    },
    yiyuanyiyuanfengmianUploadChange(fileUrls) {
        this.ruleForm.yiyuanfengmian = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.gongyingshangzhanghao)&& 'gongyingshang'==this.flag){
        this.$message.error('供应商账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'gongyingshang'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.gongyingshangmingcheng)&& 'gongyingshang'==this.flag){
        this.$message.error('供应商名称不能为空');
        return
      }
        if(this.ruleForm.tupian!=null) {
                this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'gongyingshang' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
      if((!this.ruleForm.yiyuanzhanghao)&& 'yiyuan'==this.flag){
        this.$message.error('医院账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'yiyuan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.yiyuanmingcheng)&& 'yiyuan'==this.flag){
        this.$message.error('医院名称不能为空');
        return
      }
        if(this.ruleForm.yiyuanfengmian!=null) {
                this.ruleForm.yiyuanfengmian = this.ruleForm.yiyuanfengmian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.yiyuandizhi)&& 'yiyuan'==this.flag){
        this.$message.error('医院地址不能为空');
        return
      }
      if((!this.ruleForm.yiyuandengji)&& 'yiyuan'==this.flag){
        this.$message.error('医院等级不能为空');
        return
      }
      if( 'yiyuan' ==this.flag && this.ruleForm.yiyuandianhua&&(!isPhone(this.ruleForm.yiyuandianhua))){
        this.$message.error(`医院电话应输入电话格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 120px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: center;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px solid #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px solid #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
