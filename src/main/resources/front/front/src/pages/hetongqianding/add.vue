<template>
<div :style='{"padding":"20px 20px 40px","margin":"10px auto 0","borderColor":"#52b646","borderRadius":"12px","background":"#fff","borderWidth":"3px","width":"1200px","position":"relative","borderStyle":"solid dashed double double"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="招标项目" prop="zhaobiaoxiangmu">
            <el-input v-model="ruleForm.zhaobiaoxiangmu" 
                placeholder="招标项目" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="医院账号" prop="yiyuanzhanghao">
            <el-input v-model="ruleForm.yiyuanzhanghao" 
                placeholder="医院账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="医院名称" prop="yiyuanmingcheng">
            <el-input v-model="ruleForm.yiyuanmingcheng" 
                placeholder="医院名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="医院电话" prop="yiyuandianhua">
            <el-input v-model="ruleForm.yiyuandianhua" 
                placeholder="医院电话" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="供应商账号" prop="gongyingshangzhanghao">
            <el-input v-model="ruleForm.gongyingshangzhanghao" 
                placeholder="供应商账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="供应商名称" prop="gongyingshangmingcheng">
            <el-input v-model="ruleForm.gongyingshangmingcheng" 
                placeholder="供应商名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="联系电话" prop="lianxidianhua">
            <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="合同文件" prop="hetongwenjian">
            <file-upload
            tip="点击上传合同文件"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.hetongwenjian?ruleForm.hetongwenjian:''"
            @change="hetongwenjianUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="签订日期" prop="qiandingriqi" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.qiandingriqi" 
                  type="date"
                  placeholder="签订日期">
              </el-date-picker> 
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"radial-gradient(circle, rgba(132,218,110,1) 0%, rgba(63,187,33,1) 81%, rgba(82,182,70,1) 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #52b646","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#52b646","borderRadius":"4px","background":"#ecfaea","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            zhaobiaoxiangmu : false,
            yiyuanzhanghao : false,
            yiyuanmingcheng : false,
            yiyuandianhua : false,
            gongyingshangzhanghao : false,
            gongyingshangmingcheng : false,
            lianxidianhua : false,
            hetongwenjian : false,
            qiandingriqi : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          zhaobiaoxiangmu: '',
          yiyuanzhanghao: '',
          yiyuanmingcheng: '',
          yiyuandianhua: '',
          gongyingshangzhanghao: '',
          gongyingshangmingcheng: '',
          lianxidianhua: '',
          hetongwenjian: '',
          qiandingriqi: '',
        },
        rules: {
          zhaobiaoxiangmu: [
          ],
          yiyuanzhanghao: [
          ],
          yiyuanmingcheng: [
          ],
          yiyuandianhua: [
          ],
          gongyingshangzhanghao: [
          ],
          gongyingshangmingcheng: [
          ],
          lianxidianhua: [
          ],
          hetongwenjian: [
          ],
          qiandingriqi: [
          ],
        },
      };
    },
    computed: {



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.qiandingriqi = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='zhaobiaoxiangmu'){
              this.ruleForm.zhaobiaoxiangmu = obj[o];
              this.ro.zhaobiaoxiangmu = true;
              continue;
            }
            if(o=='yiyuanzhanghao'){
              this.ruleForm.yiyuanzhanghao = obj[o];
              this.ro.yiyuanzhanghao = true;
              continue;
            }
            if(o=='yiyuanmingcheng'){
              this.ruleForm.yiyuanmingcheng = obj[o];
              this.ro.yiyuanmingcheng = true;
              continue;
            }
            if(o=='yiyuandianhua'){
              this.ruleForm.yiyuandianhua = obj[o];
              this.ro.yiyuandianhua = true;
              continue;
            }
            if(o=='gongyingshangzhanghao'){
              this.ruleForm.gongyingshangzhanghao = obj[o];
              this.ro.gongyingshangzhanghao = true;
              continue;
            }
            if(o=='gongyingshangmingcheng'){
              this.ruleForm.gongyingshangmingcheng = obj[o];
              this.ro.gongyingshangmingcheng = true;
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
              continue;
            }
            if(o=='hetongwenjian'){
              this.ruleForm.hetongwenjian = obj[o];
              this.ro.hetongwenjian = true;
              continue;
            }
            if(o=='qiandingriqi'){
              this.ruleForm.qiandingriqi = obj[o];
              this.ro.qiandingriqi = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('hetongqianding/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('hetongqianding/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('hetongqianding/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('hetongqianding/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
      hetongwenjianUploadChange(fileUrls) {
          this.ruleForm.hetongwenjian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #88d67e;
	  border-radius: 4px;
	  padding: 0 12px;
	  box-shadow: inset 0px 0px 48px 0px #def5db;
	  outline: none;
	  color: #666;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #88d67e;
	  border-radius: 4px;
	  padding: 0 10px;
	  box-shadow: inset 0px 0px 48px 0px #def5db;
	  outline: none;
	  color: #666;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #88d67e;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  box-shadow: inset 0px 0px 48px 0px #def5db;
	  outline: none;
	  color: #666;
	  width: 200px;
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
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #88d67e;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #def5db;
	  color: #88d67e;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #88d67e;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #def5db;
	  color: #88d67e;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #88d67e;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #def5db;
	  color: #88d67e;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #88d67e;
	  border-radius: 4px;
	  padding: 12px;
	  box-shadow: inset 0px 0px 48px 0px #def5db;
	  outline: none;
	  color: #666;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
