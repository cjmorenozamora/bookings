<template>
  <div v-if="response" class="content">
    <ul id="v-for-object" class="content">
  <li v-for="hotel in response" :key="hotel.id" style="list-style: none;">
    <h1>Identificador del Hotel :{{ hotel.idHotel }}</h1>
    <h1>Nombre del hotel : {{ hotel.name }}</h1>
    <h1>Categoría :{{ hotel.idHotel }} estrellas.</h1>
    <hr>
  </li>
</ul>
  </div>
</template>

<script>
import hotels from "@/services/Hotel";
export default {
    name: 'GetHotels',
    data: () => ({
    response: null
  }),
  async created() {
  let response = await hotels.get();
  this.response = response.data;
  console.log(response.data);
}
};
</script>

<style scoped lang="scss">
</style>