<template>
  <form class="new-book-form" @submit.prevent="addBook">
    <div>
      <label for="title">Title:</label>
      <input type="text" id="title" class="title-input" v-model="newBook.title">
    </div>
    <div>
      <label for="author">Author:</label>
      <input type="text" id="author" class="author-input" v-model="newBook.author">
    </div>
    <div>
      <label for="isbn">ISBN:</label>
      <input type="text" id="isbn" class="isbn-input" v-model="newBook.isbn">
    </div>
    <button type="submit">Add Book</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      newBook: {
        title: '',
        author: '',
        isbn: ''
      }
    };
  },
  methods: {
    addBook() {
      console.log("Adding book:", this.newBook);
      this.$store.commit("addBook", this.newBook);
      this.newBook = { title: '', author: '', isbn: '' };
    }
  }
};
</script>

<style>
.new-book-form {
}
.title-input{

}

.author-input{


}

.isbn-input {

}
</style
>