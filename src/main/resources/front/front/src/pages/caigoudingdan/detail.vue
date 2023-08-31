<template>
<div>
	<div :style='{"width":"1200px","padding":"10px 20px","margin":"10px auto","borderRadius":"12px","background":"radial-gradient(circle, rgba(132,218,110,1) 0%, rgba(63,187,33,1) 81%, rgba(82,182,70,1) 100%)"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item>首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	
	<div class="detail-preview" :style='{"width":"1200px","padding":"0 0 20px","margin":"20px auto 0","position":"relative"}'>
		<div class="attr" :style='{"padding":"20px","borderColor":"#52b646","borderRadius":"12px","flexWrap":"wrap","background":"#fff","borderWidth":"3px","display":"flex","position":"relative","borderStyle":"dotted dashed solid double","justifyContent":"center"}'>
			<el-carousel :style='{"width":"100%","margin":"0 0 20px 0","height":"400px","order":"1"}' trigger="click" indicator-position="inside" arrow="always" type="card" direction="horizontal" height="400px" autoplay="true" interval="3000" loop="true">
				<el-carousel-item :style='{"borderRadius":"10px","width":"50%","height":"100%"}' v-for="item in detailBanner" :key="item.id">
					<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-if="item.substr(0,4)=='http'" :src="item" fit="cover" class="image"></el-image>
					<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-else :src="baseUrl + item" fit="cover" class="image"></el-image>
				</el-carousel-item>
			</el-carousel>
	
			
			<div class="info" :style='{"width":"50%","padding":"10px","margin":"0 2% 0 0px","background":"#fff","order":"2"}'>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","alignItems":"center","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"space-between"}'>
					<div :style='{"padding":"0 10px","fontSize":"16px","color":"#333","fontWeight":"600"}'>
                    </div>
				</div>

				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>订单编号</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.dingdanbianhao}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>产品名称</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.chanpinmingcheng}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>产品规格</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.chanpinguige}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>产品价格</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.chanpinjiage}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>采购数量</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.caigoushuliang}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>总金额</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.zongjine}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>供应商账号</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.gongyingshangzhanghao}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>供应商名称</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.gongyingshangmingcheng}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>联系电话</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.lianxidianhua}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>医院账号</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.yiyuanzhanghao}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>医院名称</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.yiyuanmingcheng}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>医院电话</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.yiyuandianhua}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #88d67e","padding":"6px 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","margin":"0 0 10px 0","borderRadius":"4px","background":"#fff","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","width":"120px","fontSize":"14px","lineHeight":"40px","minWidth":"120px"}'>采购时间</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","height":"auto"}'>{{detail.caigoushijian}}</div>
				</div>
				<div class="btn" :style='{"padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"radial-gradient(circle, rgba(132,218,110,1) 0%, rgba(63,187,33,1) 81%, rgba(82,182,70,1) 100%)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="isAuth('caigoudingdan','配送')" @click="onAcross('dingdanpeisong','是','','')" type="warning">配送</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"radial-gradient(circle, rgba(252,189,189,1) 0%, rgba(223,75,75,1) 100%)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="isAuth('caigoudingdan','审核')" @click="onSH" type="warning">审核</el-button>
				</div>
			</div>
			
		</div>
		
		
		<el-tabs class="detail" :style='{"boxShadow":"0 1px 6px 0 rgba(0, 0, 0, .1)","borderColor":"#52b646","borderRadius":"12px","borderStyle":"solid double solid double","background":"#fff","borderWidth":"3px"}' v-model="activeName" type="border-card">
		</el-tabs>
		<el-dialog title="审核" :visible.sync="sfshVisiable" width="50%">
			<el-form ref="shForm" :model="shForm" label-width="80px">
				<el-form-item label="审核状态">
					<el-select v-model="shForm.sfsh" placeholder="审核状态">
						<el-option label="通过" value="是"></el-option>
						<el-option label="不通过" value="否"></el-option>
						<el-option label="待审核" value="待审核"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="内容">
					<el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="sfshVisiable = false">取 消</el-button>
				<el-button type="primary" @click="shHandler">确 定</el-button>
			</div>
		</el-dialog>
	</div>
</div>
</template>

<script>
  import CountDown from '@/components/CountDown';
  export default {
    //数据集合
    data() {
      return {
        tablename: 'caigoudingdan',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '详情信息'
          }
        ],
        title: '',
        detailBanner: [],
        endTime: 0,
        detail: {},
        activeName: 'first',
        total: 1,
        pageSize: 5,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ]
        },
        buynumber: 1,
        sfshVisiable: false,
        shForm: {
          sfsh: '是',
          shhf: ''
        },
      }
    },
    created() {
        this.init();
    },
    //方法集合
    methods: {
        init() {
          this.baseUrl = this.$config.baseUrl;
          if(this.$route.query.detailObj) {
            this.detail = JSON.parse(this.$route.query.detailObj);
          }
          this.$http.get(this.tablename + '/detail/'  + this.detail.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
              this.$forceUpdate();
            }
          });


        },
      onAcross(acrossTable,crossOptAudit,statusColumnName,tips,statusColumnValue){
        localStorage.setItem('crossTable',`caigoudingdan`);
        localStorage.setItem('crossObj', JSON.stringify(this.detail));
        localStorage.setItem('statusColumnName',statusColumnName);
        localStorage.setItem('statusColumnValue',statusColumnValue);
        localStorage.setItem('tips',tips);
        if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
            var obj = JSON.parse(localStorage.getItem('crossObj'));
            for (var o in obj){
                if(o==statusColumnName && obj[o]==statusColumnValue){
                    this.$message({
                        type: 'success',
                        message: tips,
                        duration: 1500
                    });
                    return
                }
            }
        }
        this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
      },
      onSH() {
        this.sfshVisiable = true;
      },
      shHandler(){
        this.$confirm(`确定操作?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.detail.sfsh = this.shForm.sfsh;
          this.detail.shhf = this.shForm.shhf;
          this.$http.post(`${this.tablename}/update`, this.detail).then(res => {
            if (res.data.code == 0) {
              this.sfshVisiable = false;
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
              });
            }
          });
        });
      },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
      // 下载
      download(file){
        if(!file) {
            this.$message({
              type: 'error',
              message: '文件不存在',
              duration: 1500,
            });
            return;
        }
        window.open(this.baseUrl+file)
      },


    },
    components: {
      CountDown
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #52b646;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #52b646;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0 0 12px;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 100%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 4px 0 0 4px;
		top: 1px;
		left: 1px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 1px 0 0;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #666;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		right: 1px;
		border-radius: 0 4px 4px 0;
		top: 1px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 0 0 1px;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #666;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		border-radius: 4px;
		padding: 0 40px;
		outline: none;
		color: #666;
		background: #FFF;
		display: inline-block;
		width: 100%;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		border-radius: 8px 8px 0 0;
		margin: 1px 0 0;
		background: url(http://codegen.caihongy.cn/20221114/1fde69930e764ee1acd7026e05e4c7ee.jpg) no-repeat center top;
		border-color: #E4E7ED;
		border-width: 0 0 0px 0;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		border: 0;
		padding: 0 20px;
		margin: 0 6px 0;
		color: #fff;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		line-height: 40px;
		border-radius: 8px 8px 0 0;
		background: transparent;
		position: relative;
		list-style: none;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		border: 0;
		border-radius: 8px 8px 0 0;
		margin: 0 6px 0;
		color: #fff;
		background: rgba(0,0,0,0.2);
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 0;
		border-radius: 8px 8px 0 0;
		margin: 0 6px 0;
		color: #fff;
		background: rgba(0,0,0,0.2);
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
		border: 1px solid #88d67e;
		border-radius: 4px;
		padding: 0 12px;
		box-shadow: inset 0px 0px 48px 0px #def5db;
		outline: none;
		color: #333;
		width: 1058px;
		font-size: 14px;
		min-height: 120px;
		line-height: 32px;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #eee;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner a {
		color: #fff;
		display: inline-block;
	}

	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner {
		color: #eee;
		display: inline-block;
	}
	
	.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #52b646;
		text-align: center;
		min-width: 30px;
		height: 28px;
}

.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #52b646;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}

	.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
</style>
