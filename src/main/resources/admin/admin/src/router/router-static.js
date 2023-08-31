import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import jieguogongshi from '@/views/modules/jieguogongshi/list'
    import news from '@/views/modules/news/list'
    import zhaobiaoxinxi from '@/views/modules/zhaobiaoxinxi/list'
    import chanpinxinxi from '@/views/modules/chanpinxinxi/list'
    import gongyingshang from '@/views/modules/gongyingshang/list'
    import zhuanjiachouqu from '@/views/modules/zhuanjiachouqu/list'
    import yiyuan from '@/views/modules/yiyuan/list'
    import shebeizhejiu from '@/views/modules/shebeizhejiu/list'
    import tiaomaweihu from '@/views/modules/tiaomaweihu/list'
    import wuzixinxi from '@/views/modules/wuzixinxi/list'
    import wuziruku from '@/views/modules/wuziruku/list'
    import wuzichuku from '@/views/modules/wuzichuku/list'
    import caigoudingdan from '@/views/modules/caigoudingdan/list'
    import zichanbaofei from '@/views/modules/zichanbaofei/list'
    import hetongqianding from '@/views/modules/hetongqianding/list'
    import zichanruku from '@/views/modules/zichanruku/list'
    import shebeizichan from '@/views/modules/shebeizichan/list'
    import config from '@/views/modules/config/list'
    import zhaobiaogonggao from '@/views/modules/zhaobiaogonggao/list'
    import zichanzhuanke from '@/views/modules/zichanzhuanke/list'
    import dingdanpeisong from '@/views/modules/dingdanpeisong/list'
    import yubeizhanghu from '@/views/modules/yubeizhanghu/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/jieguogongshi',
        name: '结果公示',
        component: jieguogongshi
      }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/zhaobiaoxinxi',
        name: '招标信息',
        component: zhaobiaoxinxi
      }
      ,{
	path: '/chanpinxinxi',
        name: '产品信息',
        component: chanpinxinxi
      }
      ,{
	path: '/gongyingshang',
        name: '供应商',
        component: gongyingshang
      }
      ,{
	path: '/zhuanjiachouqu',
        name: '专家抽取',
        component: zhuanjiachouqu
      }
      ,{
	path: '/yiyuan',
        name: '医院',
        component: yiyuan
      }
      ,{
	path: '/shebeizhejiu',
        name: '设备折旧',
        component: shebeizhejiu
      }
      ,{
	path: '/tiaomaweihu',
        name: '条码维护',
        component: tiaomaweihu
      }
      ,{
	path: '/wuzixinxi',
        name: '物资信息',
        component: wuzixinxi
      }
      ,{
	path: '/wuziruku',
        name: '物资入库',
        component: wuziruku
      }
      ,{
	path: '/wuzichuku',
        name: '物资出库',
        component: wuzichuku
      }
      ,{
	path: '/caigoudingdan',
        name: '采购订单',
        component: caigoudingdan
      }
      ,{
	path: '/zichanbaofei',
        name: '资产报废',
        component: zichanbaofei
      }
      ,{
	path: '/hetongqianding',
        name: '合同签订',
        component: hetongqianding
      }
      ,{
	path: '/zichanruku',
        name: '资产入库',
        component: zichanruku
      }
      ,{
	path: '/shebeizichan',
        name: '设备资产',
        component: shebeizichan
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/zhaobiaogonggao',
        name: '招标公告',
        component: zhaobiaogonggao
      }
      ,{
	path: '/zichanzhuanke',
        name: '资产转科',
        component: zichanzhuanke
      }
      ,{
	path: '/dingdanpeisong',
        name: '订单配送',
        component: dingdanpeisong
      }
      ,{
	path: '/yubeizhanghu',
        name: '预备账户',
        component: yubeizhanghu
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
