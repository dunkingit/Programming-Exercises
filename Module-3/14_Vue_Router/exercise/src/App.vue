<template>
  <div id="book-app">
      <router-link v-bind:to="{name: 'HomeView'}">Home</router-link> |
      <router-link v-bind:to="{name: 'myBooks'}">My Books</router-link>
    <router-view></router-view>
  </div>
</template>
<script>

import BookCard from "@/components/BookCard.vue";
import BookView from "@/views/BookView.vue";
import NewBookView from "@/views/NewBookView.vue";
import HomeView from "@/views/HomeView.vue";
import MyBooksView from "@/views/MyBooksView.vue";

export default {
  components:{
    BookView,
    HomeView,
    MyBooksView,
    NewBookView
  }

}
</script>

<style>
#book-app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>
