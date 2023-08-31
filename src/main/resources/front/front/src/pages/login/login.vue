<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221115/d968ab69ddc8495282963cb2dab971cb.jpg) no-repeat center top","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"40px 20px 20px","boxShadow":"0 1px 6px rgba(0, 0, 0, .1)","margin":"0","borderRadius":"16px","background":"url(http://codegen.caihongy.cn/20221115/2f997573ef7545c39f9e0eff917cbd30.png) no-repeat left top,url(http://codegen.caihongy.cn/20221115/30139400df864d7eaddf9c3da399146c.png) no-repeat right bottom,#fff","width":"800px","height":"auto"}' :rules="rules">
			<div v-if="true" :style='{"margin":"0 0 10px 0","color":"#52b646","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(82, 182, 70, .3)"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"0 auto 20px auto","borderColor":"#52b646","color":"#52b646","textAlign":"center","borderWidth":"3px","width":"50%","letterSpacing":"2px","lineHeight":"44px","fontSize":"24px","borderStyle":"dotted dashed solid double","fontWeight":"600"}'>医院HRP物资管理系统登录</div>
			<el-form-item class="list-item" :style='{"width":"80%","margin":"0 auto 10px"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"#333"}'>账号：</div>
				<input :style='{"border":"1px solid #88d67e","padding":"0 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","color":"#666","borderRadius":"4px","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item class="list-item" :style='{"width":"80%","margin":"0 auto 10px"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"#333"}'>密码：</div>
				<input :style='{"border":"1px solid #88d67e","padding":"0 10px","boxShadow":"inset 0px 0px 48px 0px #def5db","color":"#666","borderRadius":"4px","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"80%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"20px auto"}'>
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0 34px","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"4px","background":"radial-gradient(circle, rgba(132,218,110,1) 0%, rgba(63,187,33,1) 81%, rgba(82,182,70,1) 100%)","width":"auto","fontSize":"14px","height":"44px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button :style='{"border":"1px solid #52b646","cursor":"pointer","padding":"0 34px","margin":"0 5px","outline":"none","color":"#52b646","borderRadius":"4px","background":"#ecfaea","width":"auto","fontSize":"14px","height":"44px"}' @click="resetForm('loginForm')">重置</el-button>
			</el-form-item>
			<div :style='{"width":"80%","margin":"20px auto"}'>
			<router-link :style='{"cursor":"pointer","margin":"0 5px","fontSize":"14px","textDecoration":"none","color":"#52b646","background":"#fff"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>


export default {
	//数据集合
	data() {
		return {
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"供应商","menuJump":"列表","tableName":"gongyingshang"}],"menu":"供应商管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["新增","查看","修改","删除"],"menu":"医院","menuJump":"列表","tableName":"yiyuan"}],"menu":"医院管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"招标公告","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除"],"menu":"招标信息","menuJump":"列表","tableName":"zhaobiaoxinxi"}],"menu":"招标信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改","删除"],"menu":"专家抽取","menuJump":"列表","tableName":"zhuanjiachouqu"}],"menu":"专家抽取管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除"],"menu":"结果公示","menuJump":"列表","tableName":"jieguogongshi"}],"menu":"结果公示管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","修改","删除"],"menu":"合同签订","menuJump":"列表","tableName":"hetongqianding"}],"menu":"合同签订管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","修改","删除"],"menu":"产品信息","menuJump":"列表","tableName":"chanpinxinxi"}],"menu":"产品信息管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","修改","删除"],"menu":"采购订单","menuJump":"列表","tableName":"caigoudingdan"}],"menu":"采购订单管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改","删除"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除"],"menu":"条码维护","menuJump":"列表","tableName":"tiaomaweihu"}],"menu":"条码维护管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","修改","删除"],"menu":"物资信息","menuJump":"列表","tableName":"wuzixinxi"}],"menu":"物资信息管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"物资入库","menuJump":"列表","tableName":"wuziruku"}],"menu":"物资入库管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","修改","删除"],"menu":"物资出库","menuJump":"列表","tableName":"wuzichuku"}],"menu":"物资出库管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除"],"menu":"设备资产","menuJump":"列表","tableName":"shebeizichan"}],"menu":"设备资产管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","修改","删除"],"menu":"设备折旧","menuJump":"列表","tableName":"shebeizhejiu"}],"menu":"设备折旧管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除"],"menu":"资产转科","menuJump":"列表","tableName":"zichanzhuanke"}],"menu":"资产转科管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","删除","修改"],"menu":"资产入库","menuJump":"列表","tableName":"zichanruku"}],"menu":"资产入库管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"资产报废","menuJump":"列表","tableName":"zichanbaofei"}],"menu":"资产报废管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看","修改","删除"],"menu":"预备账户","menuJump":"列表","tableName":"yubeizhanghu"}],"menu":"预备账户管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"},{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","招标"],"menu":"招标公告列表","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"招标信息","menuJump":"列表","tableName":"zhaobiaoxinxi"}],"menu":"招标信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看"],"menu":"结果公示","menuJump":"列表","tableName":"jieguogongshi"}],"menu":"结果公示管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看"],"menu":"合同签订","menuJump":"列表","tableName":"hetongqianding"}],"menu":"合同签订管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["新增","查看","修改","删除"],"menu":"产品信息","menuJump":"列表","tableName":"chanpinxinxi"}],"menu":"产品信息管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","删除","审核","配送"],"menu":"采购订单","menuJump":"列表","tableName":"caigoudingdan"}],"menu":"采购订单管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除","条码维护"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除"],"menu":"条码维护","menuJump":"列表","tableName":"tiaomaweihu"}],"menu":"条码维护管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","招标"],"menu":"招标公告列表","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"供应商","tableName":"gongyingshang"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["新增","查看","修改","删除"],"menu":"招标公告","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除","审核","专家抽取"],"menu":"招标信息","menuJump":"列表","tableName":"zhaobiaoxinxi"}],"menu":"招标信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改","删除","结果公示"],"menu":"专家抽取","menuJump":"列表","tableName":"zhuanjiachouqu"}],"menu":"专家抽取管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除","合同签订"],"menu":"结果公示","menuJump":"列表","tableName":"jieguogongshi"}],"menu":"结果公示管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","删除"],"menu":"合同签订","menuJump":"列表","tableName":"hetongqianding"}],"menu":"合同签订管理"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","采购"],"menu":"产品信息","menuJump":"列表","tableName":"chanpinxinxi"}],"menu":"产品信息管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","删除","支付"],"menu":"采购订单","menuJump":"列表","tableName":"caigoudingdan"}],"menu":"采购订单管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看"],"menu":"条码维护","menuJump":"列表","tableName":"tiaomaweihu"}],"menu":"条码维护管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除","入库","出库"],"menu":"物资信息","menuJump":"列表","tableName":"wuzixinxi"}],"menu":"物资信息管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"物资入库","menuJump":"列表","tableName":"wuziruku"}],"menu":"物资入库管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","修改","删除"],"menu":"物资出库","menuJump":"列表","tableName":"wuzichuku"}],"menu":"物资出库管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除","导出","导入","折旧","转科","报废"],"menu":"设备资产","menuJump":"列表","tableName":"shebeizichan"}],"menu":"设备资产管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","修改","删除","导出","导入"],"menu":"设备折旧","menuJump":"列表","tableName":"shebeizhejiu"}],"menu":"设备折旧管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除","导出","导入"],"menu":"资产转科","menuJump":"列表","tableName":"zichanzhuanke"}],"menu":"资产转科管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除","导出","导入"],"menu":"资产入库","menuJump":"列表","tableName":"zichanruku"}],"menu":"资产入库管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除","导出","导入"],"menu":"资产报废","menuJump":"列表","tableName":"zichanbaofei"}],"menu":"资产报废管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除","导出","导入"],"menu":"预备账户","menuJump":"列表","tableName":"yubeizhanghu"}],"menu":"预备账户管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看","招标"],"menu":"招标公告列表","menuJump":"列表","tableName":"zhaobiaogonggao"}],"menu":"招标公告模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"医院","tableName":"yiyuan"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: '登录成功',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20221115/d968ab69ddc8495282963cb2dab971cb.jpg) no-repeat center top;
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid #88d67e;
			border-radius: 4px;
			padding: 0 10px;
			box-shadow: inset 0px 0px 48px 0px #def5db;
			color: #666;
			width: 100%;
			font-size: 14px;
			height: 44px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid #88d67e;
			border-radius: 4px;
			padding: 0 10px;
			box-shadow: inset 0px 0px 48px 0px #def5db;
			outline: none;
			color: #666;
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 156px);
			font-size: 14px;
			height: 44px;
		}
		
		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #52b646;
			border-color: #52b646;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #52b646;
			font-size: 14px;
		}
	}
</style>
