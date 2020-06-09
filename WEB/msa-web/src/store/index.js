import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)

const resourceHost = 'http://localhost:8083'

export default new Vuex.Store({
  state:{
    accessToken: null
  },
  mutations: {
    LOGIN(state, accessToken, refreshToken){
      console.log(accessToken)
      console.log(refreshToken)
      state.accessToken = accessToken

    },
    LOGOUT(state){
      state.accessToken = null
    }
  },
  actions: {
    LOGIN(commit, user ){
      console.log("login action")
      var querystring = require('querystring');
      let config ={
        headers:{
          "Content-Type": "application/x-www-form-urlencoded",
          "Authorization": "Basic Y2xpZW50X2lkOnNlY3JldA==",
        }
      }
      let data = querystring.stringify({
          username:user.username,
          password:user.password,
          grant_type:'password',
          scope:'webclient'
      })
      return axios.post(resourceHost+'/oauth/token',data, config )
      .then(response => {
        this.commit('LOGIN', response.data.access_token, response.data.refresh_token)
        console.log(response)
        console.log(response.data.access_token);
        axios.defaults.headers.common['Authorization'] = 'Bearer' + response.data.access_token;
      })

    }
  }

})