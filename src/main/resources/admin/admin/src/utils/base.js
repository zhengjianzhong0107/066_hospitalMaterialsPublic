const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootg3334/",
            name: "springbootg3334",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootg3334/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "医院HRP物资管理系统"
        } 
    }
}
export default base
