<template>
  <table id="tblUsers">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td><input type="text" id="firstNameFilter" v-model="search.firstName"></td>
        <td><input type="text" id="lastNameFilter" v-model="search.lastName"/></td>
        <td><input type="text" id="usernameFilter" v-model="search.username"/></td>
        <td><input type="text" id="emailFilter" v-model="search.emailAddress"/></td>
        <td>
          <select id="statusFilter" v-model="search.status" v-bind:class="search.status">
            <option disabled value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
          </select>
        </td>
      </tr>
<!--      v-bind:class="user.status"-->
      <tr v-for="(user, index) in users" v-bind:key="index" v-bind:class=user.status>
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.emailAddress }}</td>
        <td>{{ user.status }}</td>
      </tr>
    </tbody>
  </table>
  <p>{{filteredList}}</p>
</template>

<script>
import {computed} from "vue";

export default {
  data() {
    return {
      users: [
        {firstName: 'John', lastName: 'Smith', username: 'jsmith', emailAddress: 'jsmith@gmail.com', status: 'Active'},
        {firstName: 'Anna', lastName: 'Bell', username: 'abell', emailAddress: 'abell@yahoo.com', status: 'Active'},
        {firstName: 'George', lastName: 'Best', username: 'gbest', emailAddress: 'gbest@gmail.com', status: 'Inactive'},
        {
          firstName: 'Ben',
          lastName: 'Carter',
          username: 'bcarter',
          emailAddress: 'bcarter@gmail.com',
          status: 'Active'
        },
        {
          firstName: 'Katie',
          lastName: 'Jackson',
          username: 'kjackson',
          emailAddress: 'kjackson@yahoo.com',
          status: 'Active'
        },
        {firstName: 'Mark', lastName: 'Smith', username: 'msmith', emailAddress: 'msmith@foo.com', status: 'Inactive'}
      ],
      search: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active",
      }
    }
  },
  computed:{
    filteredList(){
      // return this.users.filter((cu) => {
      // console.log("cu - Current Value Inside of users objects" + cu.toString())
      // return Object.keys(this.search).every((cur) => {
      //
      //    console.log("cur - Current key  Inside of search object" + cur.toString())
      //    let userObjKey = cu[cur].toLowerCase()
      //    let searchObjValueByKey = this.search[cur].toLowerCase()
      //   if(searchObjValueByKey.length > 1) {
      //     let checkIndexOf = userObjKey.indexOf(searchObjValueByKey)
      //     console.log("cur[cur] - Current key  Inside of search object " + cur.toString())
      //     console.log("User object by key " + userObjKey)
      //     console.log("Search obj value by key " + searchObjValueByKey)
      //     console.log("Check index of: " + userObjKey.indexOf(searchObjValueByKey))
      //     console.log(checkIndexOf !== -1)
      //     return checkIndexOf !== -1
      //   }else{
      //     return false
      //   }
      //  })
      // })

     // return this.users.filter((cu) => Object.keys(this.search).every((cur) =>
     //     cu[cur].toLowerCase().indexOf(this.search[cur].toLowerCase()) !== -1))
      console.log(this.search.status)
      return this.users.filter((cu) => Object.keys(this.search).every((cur) =>
          cu[cur].toLowerCase().includes(this.search[cur].toLowerCase())))
    }

  }
}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}
th {
  text-transform: uppercase
}
td {
  padding: 10px;
}
tr.inactive {
  color: red;
}
input, select {
  font-size: 16px;
}
</style>