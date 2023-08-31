<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","backgroundAttachment":"fixed","alignItems":"center","background":"url(http://codegen.caihongy.cn/20220722/a5a9809d7bce4ca795483bb67cfd60c8.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"padding":"20px","boxShadow":"0 0px 0px rgba(64, 158, 255, .8)","margin":"0 0 0 660px","borderRadius":"0","background":"transparent","width":"calc(100vw - 660px)","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"margin":"0 0 10px 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"24px","textShadow":"4px 4px 2px rgba(0, 0, 0, .2)"}' class="title">医院HRP物资管理系统注册</div>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">供应商账号</div>
					<el-input  v-model="ruleForm.gongyingshangzhanghao"  autocomplete="off" placeholder="供应商账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">供应商名称</div>
					<el-input  v-model="ruleForm.gongyingshangmingcheng"  autocomplete="off" placeholder="供应商名称"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">图片</div>
                    <file-upload
                        tip="点击上传图片"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
                        @change="gongyingshangtupianUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">联系人</div>
					<el-input  v-model="ruleForm.lianxiren"  autocomplete="off" placeholder="联系人"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">联系电话</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">供应商地址</div>
					<el-input  v-model="ruleForm.gongyingshangdizhi"  autocomplete="off" placeholder="供应商地址"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='gongyingshang'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">资质证照</div>
                    <el-date-picker
                        format="yyyy 年 MM 月 dd 日"
                        value-format="yyyy-MM-dd"
                        v-model="ruleForm.zizhizhengzhao"
                        type="date"
                        placeholder="资质证照"
                    ></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yiyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">医院账号</div>
					<el-input  v-model="ruleForm.yiyuanzhanghao"  autocomplete="off" placeholder="医院账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yiyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yiyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yiyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">医院名称</div>
					<el-input  v-model="ruleForm.yiyuanmingcheng"  autocomplete="off" placeholder="医院名称"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yiyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">医院封面</div>
                    <file-upload
                        tip="点击上传医院封面"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.yiyuanfengmian?ruleForm.yiyuanfengmian:''"
                        @change="yiyuanyiyuanfengmianUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yiyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">医院地址</div>
					<el-input  v-model="ruleForm.yiyuandizhi"  autocomplete="off" placeholder="医院地址"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yiyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">医院等级</div>
					<el-input  v-model="ruleForm.yiyuandengji"  autocomplete="off" placeholder="医院等级"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"500px","padding":"0","margin":"0 auto 15px","height":"auto"}' class="list-item" v-if="tableName=='yiyuan'">
					<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">医院电话</div>
					<el-input  v-model="ruleForm.yiyuandianhua"  autocomplete="off" placeholder="医院电话"  type="text"  />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#fff","display":"block","outline":"none","borderRadius":"5px","background":"#67D4B2","width":"30%","fontSize":"16px","height":"44px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","color":"rgba(159, 159, 159, 1)","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
			},

            pageFlag : '',
			tableName:"",
			rules: {},
		};
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
	},
	created() {
    
	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        gongyingshangtupianUploadChange(fileUrls) {
            this.ruleForm.tupian = fileUrls;
        },
        yiyuanyiyuanfengmianUploadChange(fileUrls) {
            this.ruleForm.yiyuanfengmian = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.gongyingshangzhanghao) && `gongyingshang` == this.tableName){
						this.$message.error(`供应商账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `gongyingshang` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `gongyingshang` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.gongyingshangmingcheng) && `gongyingshang` == this.tableName){
						this.$message.error(`供应商名称不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.tupian!=null) {
                this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`gongyingshang` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.yiyuanzhanghao) && `yiyuan` == this.tableName){
						this.$message.error(`医院账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `yiyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yiyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.yiyuanmingcheng) && `yiyuan` == this.tableName){
						this.$message.error(`医院名称不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.yiyuanfengmian!=null) {
                this.ruleForm.yiyuanfengmian = this.ruleForm.yiyuanfengmian.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.yiyuandizhi) && `yiyuan` == this.tableName){
						this.$message.error(`医院地址不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.yiyuandengji) && `yiyuan` == this.tableName){
						this.$message.error(`医院等级不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`yiyuan` == this.tableName && this.ruleForm.yiyuandianhua&&(!this.$validate.isPhone(this.ruleForm.yiyuandianhua))){
						this.$message.error(`医院电话应输入电话格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
			
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
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
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20220722/a5a9809d7bce4ca795483bb67cfd60c8.png);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #67D4B2;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #000;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #67D4B2;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #000;
						width: 500px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #67D4B2;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #000;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #67D4B2;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #000;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px dashed #67D4B2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #67D4B2;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed #67D4B2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #67D4B2;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed #67D4B2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #67D4B2;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
	}
</style>
