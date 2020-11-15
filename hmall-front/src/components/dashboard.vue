<!--  -->
<template>
  <div class="container">
        <el-form
          label-position="left"
          label-width="0px"
          status-icon
        >
          <h2 class="title">图书查询</h2>
          <el-form-item prop="account">
            <el-input
              type="text"
              v-model="bookId"
              auto-complete="off"
              placeholder="请输入图书ID"
            ></el-input>
          </el-form-item>
        </el-form>
        <el-button type="primary" @click="search">查询</el-button>
        <div style="height: 20px;">

        </div>
        <el-card>
            <div slot="header" class="clearfix">
                <span> {{ title }}</span>
            </div>
        
            <div class="item">
                价格：{{ price }}
            </div>
            <div class="item">
                销量：{{ sales }}
            </div>
        </el-card>
  </div>
</template>

<script>
export default {
  data () {
    return {
        bookId:'',
        title: '',
        price: '',
        sales: '',
    };
  },
  methods:{
      search(){
          if (this.bookId != '') {
            let _this = this
            this.$axios({
                url: "http://localhost:8081/getBook/" + _this.bookId,
                method: 'get',
            }) .then(res => {
                _this.title = res.data.title
                _this.price = res.data.price
                _this.sales = res.data.sales
            }) .catch(error => {
                console.log(error)
            })
          }
      }
  }
}
</script>
<style>
.container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 10% auto;
  height: 400px;
  width: 500px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
.item {
    display: flex;
    float: left;
    width: 100%;
    height: 50px;
}
</style>
