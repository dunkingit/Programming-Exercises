<template>
  <book-details v-bind:book="getBook"></book-details>
</template>

<script>
import BookDetails from "@/components/BookDetails.vue";
export default {
  components:{
    BookDetails
  },
  computed:{
    getBook(){
      let id = this.$route.params.id
      console.log("ID =" + id)
      let array = [this.$store.state.books, this.$store.state.popularBooks].flat(1)
      let item = array.find((p) => {
        console.log(p.isbn)
        console.log(typeof p.isbn + "p.isbn and id" + typeof id )
        console.log(p.isbn == id)
        return p.isbn == id
      })
      console.log(item.toString())
      return item
    }
  }
}
</script>
<style>
</style>