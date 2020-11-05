<template>
  <div id="app" class="hello">
    <img alt="Vue logo" src="./assets/NOSOLOSOFTWARE.png">
    <HelloWorld msg="Reserva de Hotel"/>
    <hr>
    <GetHotels></GetHotels>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import GetHotels from './components/GetHotels.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    GetHotels
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
