import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import gongyingshangList from '../pages/gongyingshang/list'
import gongyingshangDetail from '../pages/gongyingshang/detail'
import gongyingshangAdd from '../pages/gongyingshang/add'
import yiyuanList from '../pages/yiyuan/list'
import yiyuanDetail from '../pages/yiyuan/detail'
import yiyuanAdd from '../pages/yiyuan/add'
import zhaobiaogonggaoList from '../pages/zhaobiaogonggao/list'
import zhaobiaogonggaoDetail from '../pages/zhaobiaogonggao/detail'
import zhaobiaogonggaoAdd from '../pages/zhaobiaogonggao/add'
import zhaobiaoxinxiList from '../pages/zhaobiaoxinxi/list'
import zhaobiaoxinxiDetail from '../pages/zhaobiaoxinxi/detail'
import zhaobiaoxinxiAdd from '../pages/zhaobiaoxinxi/add'
import zhuanjiachouquList from '../pages/zhuanjiachouqu/list'
import zhuanjiachouquDetail from '../pages/zhuanjiachouqu/detail'
import zhuanjiachouquAdd from '../pages/zhuanjiachouqu/add'
import jieguogongshiList from '../pages/jieguogongshi/list'
import jieguogongshiDetail from '../pages/jieguogongshi/detail'
import jieguogongshiAdd from '../pages/jieguogongshi/add'
import hetongqiandingList from '../pages/hetongqianding/list'
import hetongqiandingDetail from '../pages/hetongqianding/detail'
import hetongqiandingAdd from '../pages/hetongqianding/add'
import chanpinxinxiList from '../pages/chanpinxinxi/list'
import chanpinxinxiDetail from '../pages/chanpinxinxi/detail'
import chanpinxinxiAdd from '../pages/chanpinxinxi/add'
import caigoudingdanList from '../pages/caigoudingdan/list'
import caigoudingdanDetail from '../pages/caigoudingdan/detail'
import caigoudingdanAdd from '../pages/caigoudingdan/add'
import dingdanpeisongList from '../pages/dingdanpeisong/list'
import dingdanpeisongDetail from '../pages/dingdanpeisong/detail'
import dingdanpeisongAdd from '../pages/dingdanpeisong/add'
import tiaomaweihuList from '../pages/tiaomaweihu/list'
import tiaomaweihuDetail from '../pages/tiaomaweihu/detail'
import tiaomaweihuAdd from '../pages/tiaomaweihu/add'
import wuzixinxiList from '../pages/wuzixinxi/list'
import wuzixinxiDetail from '../pages/wuzixinxi/detail'
import wuzixinxiAdd from '../pages/wuzixinxi/add'
import wuzirukuList from '../pages/wuziruku/list'
import wuzirukuDetail from '../pages/wuziruku/detail'
import wuzirukuAdd from '../pages/wuziruku/add'
import wuzichukuList from '../pages/wuzichuku/list'
import wuzichukuDetail from '../pages/wuzichuku/detail'
import wuzichukuAdd from '../pages/wuzichuku/add'
import shebeizichanList from '../pages/shebeizichan/list'
import shebeizichanDetail from '../pages/shebeizichan/detail'
import shebeizichanAdd from '../pages/shebeizichan/add'
import shebeizhejiuList from '../pages/shebeizhejiu/list'
import shebeizhejiuDetail from '../pages/shebeizhejiu/detail'
import shebeizhejiuAdd from '../pages/shebeizhejiu/add'
import zichanzhuankeList from '../pages/zichanzhuanke/list'
import zichanzhuankeDetail from '../pages/zichanzhuanke/detail'
import zichanzhuankeAdd from '../pages/zichanzhuanke/add'
import zichanrukuList from '../pages/zichanruku/list'
import zichanrukuDetail from '../pages/zichanruku/detail'
import zichanrukuAdd from '../pages/zichanruku/add'
import zichanbaofeiList from '../pages/zichanbaofei/list'
import zichanbaofeiDetail from '../pages/zichanbaofei/detail'
import zichanbaofeiAdd from '../pages/zichanbaofei/add'
import yubeizhanghuList from '../pages/yubeizhanghu/list'
import yubeizhanghuDetail from '../pages/yubeizhanghu/detail'
import yubeizhanghuAdd from '../pages/yubeizhanghu/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'gongyingshang',
					component: gongyingshangList
				},
				{
					path: 'gongyingshangDetail',
					component: gongyingshangDetail
				},
				{
					path: 'gongyingshangAdd',
					component: gongyingshangAdd
				},
				{
					path: 'yiyuan',
					component: yiyuanList
				},
				{
					path: 'yiyuanDetail',
					component: yiyuanDetail
				},
				{
					path: 'yiyuanAdd',
					component: yiyuanAdd
				},
				{
					path: 'zhaobiaogonggao',
					component: zhaobiaogonggaoList
				},
				{
					path: 'zhaobiaogonggaoDetail',
					component: zhaobiaogonggaoDetail
				},
				{
					path: 'zhaobiaogonggaoAdd',
					component: zhaobiaogonggaoAdd
				},
				{
					path: 'zhaobiaoxinxi',
					component: zhaobiaoxinxiList
				},
				{
					path: 'zhaobiaoxinxiDetail',
					component: zhaobiaoxinxiDetail
				},
				{
					path: 'zhaobiaoxinxiAdd',
					component: zhaobiaoxinxiAdd
				},
				{
					path: 'zhuanjiachouqu',
					component: zhuanjiachouquList
				},
				{
					path: 'zhuanjiachouquDetail',
					component: zhuanjiachouquDetail
				},
				{
					path: 'zhuanjiachouquAdd',
					component: zhuanjiachouquAdd
				},
				{
					path: 'jieguogongshi',
					component: jieguogongshiList
				},
				{
					path: 'jieguogongshiDetail',
					component: jieguogongshiDetail
				},
				{
					path: 'jieguogongshiAdd',
					component: jieguogongshiAdd
				},
				{
					path: 'hetongqianding',
					component: hetongqiandingList
				},
				{
					path: 'hetongqiandingDetail',
					component: hetongqiandingDetail
				},
				{
					path: 'hetongqiandingAdd',
					component: hetongqiandingAdd
				},
				{
					path: 'chanpinxinxi',
					component: chanpinxinxiList
				},
				{
					path: 'chanpinxinxiDetail',
					component: chanpinxinxiDetail
				},
				{
					path: 'chanpinxinxiAdd',
					component: chanpinxinxiAdd
				},
				{
					path: 'caigoudingdan',
					component: caigoudingdanList
				},
				{
					path: 'caigoudingdanDetail',
					component: caigoudingdanDetail
				},
				{
					path: 'caigoudingdanAdd',
					component: caigoudingdanAdd
				},
				{
					path: 'dingdanpeisong',
					component: dingdanpeisongList
				},
				{
					path: 'dingdanpeisongDetail',
					component: dingdanpeisongDetail
				},
				{
					path: 'dingdanpeisongAdd',
					component: dingdanpeisongAdd
				},
				{
					path: 'tiaomaweihu',
					component: tiaomaweihuList
				},
				{
					path: 'tiaomaweihuDetail',
					component: tiaomaweihuDetail
				},
				{
					path: 'tiaomaweihuAdd',
					component: tiaomaweihuAdd
				},
				{
					path: 'wuzixinxi',
					component: wuzixinxiList
				},
				{
					path: 'wuzixinxiDetail',
					component: wuzixinxiDetail
				},
				{
					path: 'wuzixinxiAdd',
					component: wuzixinxiAdd
				},
				{
					path: 'wuziruku',
					component: wuzirukuList
				},
				{
					path: 'wuzirukuDetail',
					component: wuzirukuDetail
				},
				{
					path: 'wuzirukuAdd',
					component: wuzirukuAdd
				},
				{
					path: 'wuzichuku',
					component: wuzichukuList
				},
				{
					path: 'wuzichukuDetail',
					component: wuzichukuDetail
				},
				{
					path: 'wuzichukuAdd',
					component: wuzichukuAdd
				},
				{
					path: 'shebeizichan',
					component: shebeizichanList
				},
				{
					path: 'shebeizichanDetail',
					component: shebeizichanDetail
				},
				{
					path: 'shebeizichanAdd',
					component: shebeizichanAdd
				},
				{
					path: 'shebeizhejiu',
					component: shebeizhejiuList
				},
				{
					path: 'shebeizhejiuDetail',
					component: shebeizhejiuDetail
				},
				{
					path: 'shebeizhejiuAdd',
					component: shebeizhejiuAdd
				},
				{
					path: 'zichanzhuanke',
					component: zichanzhuankeList
				},
				{
					path: 'zichanzhuankeDetail',
					component: zichanzhuankeDetail
				},
				{
					path: 'zichanzhuankeAdd',
					component: zichanzhuankeAdd
				},
				{
					path: 'zichanruku',
					component: zichanrukuList
				},
				{
					path: 'zichanrukuDetail',
					component: zichanrukuDetail
				},
				{
					path: 'zichanrukuAdd',
					component: zichanrukuAdd
				},
				{
					path: 'zichanbaofei',
					component: zichanbaofeiList
				},
				{
					path: 'zichanbaofeiDetail',
					component: zichanbaofeiDetail
				},
				{
					path: 'zichanbaofeiAdd',
					component: zichanbaofeiAdd
				},
				{
					path: 'yubeizhanghu',
					component: yubeizhanghuList
				},
				{
					path: 'yubeizhanghuDetail',
					component: yubeizhanghuDetail
				},
				{
					path: 'yubeizhanghuAdd',
					component: yubeizhanghuAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
