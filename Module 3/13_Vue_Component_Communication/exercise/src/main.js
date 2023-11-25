import { createApp } from 'vue'
import MyApp from './App.vue'
import { createStore } from './store'
import bookCard from "@/components/BookCard.vue";
import readingList from "@/components/ReadingList.vue";

const store = createStore();

const app = createApp(MyApp);
app.use(store);
app.component("reading-list", readingList)
app.component("book-card", bookCard)
app.mount('#app');