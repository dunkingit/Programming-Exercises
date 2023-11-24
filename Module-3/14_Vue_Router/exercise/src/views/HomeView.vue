<template>
  <best-seller-list></best-seller-list>
  <new-releases-list></new-releases-list>
</template>

<script>

import newReleasesList from "../components/NewReleasesList.vue";
import bestSellerList from "../components/BestSellerList.vue";
export default {
  components:{
    newReleasesList,
    bestSellerList,
  }
}

</script>

<style>

</style>