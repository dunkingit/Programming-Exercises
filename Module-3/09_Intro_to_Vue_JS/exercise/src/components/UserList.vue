<template>
  <p>{{filteredList}}</p>
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
          <select id="statusFilter" v-model="search.status">
            <option value="" >Show All</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
          </select>
        </td>
      </tr>
      <tr v-for="(user, index) in users" v-bind:key="index">
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.emailAddress }}</td>
        <td>{{ user.status }}</td>
      </tr>
    </tbody>
  </table>
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
        status: "".value,
      }
    }
  },
  computed:{
    filteredList(){
    let array = Object.values(this.search)

    let test = []
    for (let each of this.users){
      for (let i =0; i < array.length; i++){
        let currentObjValue = Object.values(each)[i]
        let currentValue = array[i]
        if(currentObjValue.includes(currentValue)){
          test.push(each)
        }
      }
    }
    console.log(test)
    return test
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
