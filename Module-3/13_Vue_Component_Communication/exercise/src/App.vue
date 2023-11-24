<template>
  <div id="book-app">
    <h1>Reading List</h1>
    <reading-list/>
    <new-book-form/>
  </div>
</template>


<script>
import readingList from "@/components/ReadingList.vue";
import bookCard from "@/components/BookCard.vue";
import newBookForm from "@/components/NewBookForm.vue";

export default {
  components:{
    readingList,
    bookCard,
    newBookForm
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
