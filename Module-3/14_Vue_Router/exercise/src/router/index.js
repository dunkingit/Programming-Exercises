import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import homeView from "../views/HomeView.vue";
import MyBooksView from "../views/MyBooksView.vue";
import NewBookView from "../views/NewBookView.vue";
import BookView from "../views/BookView.vue";
const routes = [

    {
    path: '/',
    name: 'HomeView',
    component: homeView
  },
    {
        path: '/myBooks',
        name: 'myBooks',
        component: MyBooksView
    },
    {
        path: '/addBook',
        name: 'addBook',
        component: NewBookView
    },

    {
        path: '/book/:id',
        name: 'BookDetails',
        component: BookView
    },
];
export function createRouter () {
    return _createRouter({
        history: createWebHistory(),
        routes: routes
    })
}

