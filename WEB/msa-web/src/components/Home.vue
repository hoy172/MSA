<template>
  <div class="container" >
    <button v-on:click="connect" class="conn-btn">connect</button>
    <button v-on:click="clear" class="clear-btn">clear</button>
  <div class="msgContainer" >
    <ul class="messages" v-chat-scroll>
      <li class="message" v-for="n in recvData" v-bind:key="n">{{ n }}</li>
    </ul>  
  </div>
</div>
  
</template>
 /*eslint-disable*/
<script>
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'

export default {


  name: 'Home',
  data() {
    return {
      content: '',
      message: "",
      recvData :[]
    }
  },
  mounted() {
  },
  created(){
  },
  methods:{
    scrollToEnd() {    	
      window.scrollTo(0, document.body.scrollHeight || document.documentElement.scrollHeight);
    },
    clear(){

    },
    connect() {
          this.socket = new SockJS("http://localhost:8903/ws");
          this.stompClient = Stomp.over(this.socket);
          this.stompClient.connect(
            {},
            frame => {
              this.connected = true;
              frame
              // console.log(frame.body)
              this.stompClient.subscribe("/send", tick=>{
                
                console.log(tick.body)
                this.recvData.push(tick.body);
                this.scrollToEnd()
              })
            },
            error=>{
              console.log(error)
              this.connected=false
            }
          )
    }
  }
}
</script>
<style scoped>
body {
  padding: 1rem;
  background-color: lightgrey;
}
.conn-btn, .clear-btn {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}
.output {
  width: 40rem;
  min-height: 20rem;
  display: block;
  font-size: 0.5rem;
  font-family: Consolas,monaco,monospace; 
}
</style>