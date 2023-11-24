<template>
  <div class="book-container">
    <book-card v-for="book in this.$store.state.books" :id="book.isbn" :book="book"></book-card>
  </div>
</template>
<script>

export default {

  computed:{
    books(){
      return this.$store.state.books
    }
  }
}
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>