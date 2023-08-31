<template>
	<div class="navbar">
		<div class="title" :style='{"display":"block"}'>
			<el-image v-if="false" class="title-img" :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover" />
			<span class="title-name" :style='{"padding":"0 0 0 12px","lineHeight":"44px","fontSize":"20px","color":"#000","float":"left","fontWeight":"bold"}'>{{this.$project.projectName}}</span>
		</div>
		<div class="right" :style='{"position":"absolute","right":"20px","top":"8px","display":"flex"}'>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#000"}' class="nickname">{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#000"}' v-if="this.$storage.get('role')!='管理员'" class="logout" @click="onIndexTap">退出到前台</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#000"}' v-if="this.$storage.get('role')=='管理员'" class="backUp" @click="backUp">数据备份</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#000"}' class="logout" @click="onLogout">退出登录</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: {},
			};
		},
		created() {
			
		},
		mounted() {
			let sessionTable = this.$storage.get("sessionTable")
			this.$http({
				url: sessionTable + '/session',
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.user = data.data;
					this.$storage.set('userid',data.data.id);
				} else {
					let message = this.$message
					message.error(data.msg);
				}
			});
		},
		methods: {
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				router.replace({
					name: "login"
				});
			},
			onIndexTap(){
				window.location.href = `${this.$base.indexUrl}`
			},
            backUp() {
                this.$confirm('是否备份数据库?', '数据备份提示', {
                    confirmButtonText: '是',
                    cancelButtonText: '否',
                    type: 'warning'
                }).then(() => {
                    this.$http({
                        url: '/mysqldump',
                        method: "get"
                    }).then(({
                        data
                    }) => {
                        if (data) {
                            const binaryData = [];
                            binaryData.push(data);
                            const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
                                type: 'application/pdf;chartset=UTF-8'
                            }))
                            const a = document.createElement('a')
                            a.href = objectUrl
                            a.download = 'mysql.dmp'
                            // a.click()
                            // 下面这个写法兼容火狐
                            a.dispatchEvent(new MouseEvent('click', {
                                bubbles: true,
                                cancelable: true,
                                view: window
                            }))
                            window.URL.revokeObjectURL(data)
                            message.message("数据备份成功")
                        } else {
                            let message = this.$message
                            message.error(data.msg);
                        }
                    });
                });
            },
		}
	};
</script>


<style lang="scss" scoped>
	.navbar {
	
	}
</style>
