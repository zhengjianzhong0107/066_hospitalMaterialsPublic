<template>
	<div class="main-containers">
		<div class="top-container" :style='{"boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","padding":"0 20px","margin":" auto","overflow":"hidden","alignItems":"center","background":"#ffffff","display":"flex","width":"1200px","position":"relative","justifyContent":"space-between","height":"64px","zIndex":"1002"}'>
			<img v-if='false' :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"block","height":"44px"}' src='http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg'>
			<div v-if="true" :style='{"color":"#000","fontSize":"28px"}'>医院HRP物资管理系统</div>
			<div>
				<div v-if="true" :style='{"color":"#666","fontSize":"14px","display":"inline-block"}'></div>
				<el-button v-if="!Token" @click="toLogin()" :style='{"padding":"0 12px","margin":"0 0 0 10px","color":"#f4f4f5","borderRadius":"2px","background":"#52b646","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>登录/注册</el-button>
                <el-button v-if="Token" @click="logout" :style='{"padding":"0 12px","margin":"0 0 0 10px","color":"#666","borderRadius":"2px","background":"#f4f4f5","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>退出</el-button>
			</div>
		</div>
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"minHeight":"100vh","padding":"0","margin":"0","position":"relative","background":"url(http://codegen.caihongy.cn/20221117/38e5e7b28ead44818736f496c2105696.jpg) no-repeat right 500px,url(http://codegen.caihongy.cn/20221117/84d9df1596cc43c28e3a36058c6a89da.png) no-repeat left bottom,#f7f8fc"}'>
			<div class="menu-preview" :style='{"padding":"0 20px","borderColor":"#efefef","background":"url(http://codegen.caihongy.cn/20221114/1fde69930e764ee1acd7026e05e4c7ee.jpg) no-repeat center top","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}'>
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0","listStyle":"none","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"auto","position":"relative","justifyContent":"center"}' :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<el-image v-if="false" :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					<el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item @click="goBackend">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-box"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>后台管理</span>
					</el-menu-item>
					<el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-user"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>个人中心</span>
					</el-menu-item>
				</el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"100%","height":"auto"}'>
				<el-carousel :style='{"width":"100%","margin":"0 auto"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="500px" :autoplay="true" :interval="3000" :loop="true">
					<el-carousel-item :style='{"borderRadius":"0px","width":"100%","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"padding":"20px 0","margin":"20px 0 0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221114/5ee2a2d898f04e6498db12f9e81d7350.jpg) repeat-y center top","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center"}'>
			    <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"供应商","menuJump":"列表","tableName":"gongyingshang"}],"menu":"供应商管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["新增","查看","修改","删除"],"menu":"医院","menuJump":"列表","tableName":"yiyuan"}],"menu":"医院管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"招标公告","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除"],"menu":"招标信息","menuJump":"列表","tableName":"zhaobiaoxinxi"}],"menu":"招标信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改","删除"],"menu":"专家抽取","menuJump":"列表","tableName":"zhuanjiachouqu"}],"menu":"专家抽取管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除"],"menu":"结果公示","menuJump":"列表","tableName":"jieguogongshi"}],"menu":"结果公示管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","修改","删除"],"menu":"合同签订","menuJump":"列表","tableName":"hetongqianding"}],"menu":"合同签订管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","修改","删除"],"menu":"产品信息","menuJump":"列表","tableName":"chanpinxinxi"}],"menu":"产品信息管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","修改","删除"],"menu":"采购订单","menuJump":"列表","tableName":"caigoudingdan"}],"menu":"采购订单管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改","删除"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除"],"menu":"条码维护","menuJump":"列表","tableName":"tiaomaweihu"}],"menu":"条码维护管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","修改","删除"],"menu":"物资信息","menuJump":"列表","tableName":"wuzixinxi"}],"menu":"物资信息管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"物资入库","menuJump":"列表","tableName":"wuziruku"}],"menu":"物资入库管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","修改","删除"],"menu":"物资出库","menuJump":"列表","tableName":"wuzichuku"}],"menu":"物资出库管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除"],"menu":"设备资产","menuJump":"列表","tableName":"shebeizichan"}],"menu":"设备资产管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","修改","删除"],"menu":"设备折旧","menuJump":"列表","tableName":"shebeizhejiu"}],"menu":"设备折旧管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除"],"menu":"资产转科","menuJump":"列表","tableName":"zichanzhuanke"}],"menu":"资产转科管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","删除","修改"],"menu":"资产入库","menuJump":"列表","tableName":"zichanruku"}],"menu":"资产入库管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"资产报废","menuJump":"列表","tableName":"zichanbaofei"}],"menu":"资产报废管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看","修改","删除"],"menu":"预备账户","menuJump":"列表","tableName":"yubeizhanghu"}],"menu":"预备账户管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"},{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","招标"],"menu":"招标公告列表","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"招标信息","menuJump":"列表","tableName":"zhaobiaoxinxi"}],"menu":"招标信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看"],"menu":"结果公示","menuJump":"列表","tableName":"jieguogongshi"}],"menu":"结果公示管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看"],"menu":"合同签订","menuJump":"列表","tableName":"hetongqianding"}],"menu":"合同签订管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["新增","查看","修改","删除"],"menu":"产品信息","menuJump":"列表","tableName":"chanpinxinxi"}],"menu":"产品信息管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","删除","审核","配送"],"menu":"采购订单","menuJump":"列表","tableName":"caigoudingdan"}],"menu":"采购订单管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除","条码维护"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除"],"menu":"条码维护","menuJump":"列表","tableName":"tiaomaweihu"}],"menu":"条码维护管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","招标"],"menu":"招标公告列表","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"供应商","tableName":"gongyingshang"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["新增","查看","修改","删除"],"menu":"招标公告","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除","审核","专家抽取"],"menu":"招标信息","menuJump":"列表","tableName":"zhaobiaoxinxi"}],"menu":"招标信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改","删除","结果公示"],"menu":"专家抽取","menuJump":"列表","tableName":"zhuanjiachouqu"}],"menu":"专家抽取管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除","合同签订"],"menu":"结果公示","menuJump":"列表","tableName":"jieguogongshi"}],"menu":"结果公示管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","删除"],"menu":"合同签订","menuJump":"列表","tableName":"hetongqianding"}],"menu":"合同签订管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","采购"],"menu":"产品信息","menuJump":"列表","tableName":"chanpinxinxi"}],"menu":"产品信息管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","删除","支付"],"menu":"采购订单","menuJump":"列表","tableName":"caigoudingdan"}],"menu":"采购订单管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"条码维护","menuJump":"列表","tableName":"tiaomaweihu"}],"menu":"条码维护管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除","入库","出库"],"menu":"物资信息","menuJump":"列表","tableName":"wuzixinxi"}],"menu":"物资信息管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"物资入库","menuJump":"列表","tableName":"wuziruku"}],"menu":"物资入库管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","修改","删除"],"menu":"物资出库","menuJump":"列表","tableName":"wuzichuku"}],"menu":"物资出库管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除","导出","导入","折旧","转科","报废"],"menu":"设备资产","menuJump":"列表","tableName":"shebeizichan"}],"menu":"设备资产管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","修改","删除","导出","导入"],"menu":"设备折旧","menuJump":"列表","tableName":"shebeizhejiu"}],"menu":"设备折旧管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除","导出","导入"],"menu":"资产转科","menuJump":"列表","tableName":"zichanzhuanke"}],"menu":"资产转科管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除","导出","导入"],"menu":"资产入库","menuJump":"列表","tableName":"zichanruku"}],"menu":"资产入库管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除","导出","导入"],"menu":"资产报废","menuJump":"列表","tableName":"zichanbaofei"}],"menu":"资产报废管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除","导出","导入"],"menu":"预备账户","menuJump":"列表","tableName":"yubeizhanghu"}],"menu":"预备账户管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","招标"],"menu":"招标公告列表","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"医院","tableName":"yiyuan"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],	
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出成功',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		border: 0;
		padding: 0 20px;
		color: #fff;
		white-space: nowrap;
		display: flex;
		font-size: 14px;
		line-height: 50px;
		background: none;
		align-items: center;
		position: relative;
		list-style: none;
		height: 50px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		border: 0;
		padding: 0 20px;
		color: #fff;
		white-space: nowrap;
		background: rgba(0,0,0,0.2);
		font-size: 14px;
		line-height: 50px;
		position: relative;
		list-style: none;
		height: 50px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		border: 0;
		padding: 0 20px;
		color: #fff;
		white-space: nowrap;
		background: rgba(0,0,0,0.2);
		font-size: 14px;
		line-height: 50px;
		position: relative;
		list-style: none;
		height: 50px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #52b646;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #52b646;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0 0 12PX;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
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
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
      .left-content {
          width: 100%;
          text-align: left;
      }
      .right-content {
          width: 100%;
          text-align: right;
      }
    }
</style>
