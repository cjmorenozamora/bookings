<template>
  <div id="app" class="hello">
    <slider :width="300" format="push" direction="left" :opacity="0.15" :links="[{'id': 1, 'text': 'Mostrar Hoteles', 'url': 'https://github.com'}, {'id': 2, 'text': 'Haz una reserva', 'url': 'https://github.com'}, {'id': 2, 'text': 'Consultar Reservas', 'url': 'https://github.com'}]"></slider>
    <img alt="Vue logo" src="./assets/NOSOLOSOFTWARE.png">
    <HelloWorld msg="Reserva de Hotel"/>
    <hr>
    <GetHotels></GetHotels>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import GetHotels from './components/GetHotels.vue'
import Slider from '@jeremyhamm/vue-slider'
export default {
  name: 'App',
  components: {
    HelloWorld,
    GetHotels,
    'slider': Slider
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
