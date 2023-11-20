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
        firstName: "".toLowerCase(),
        lastName: "".toLowerCase(),
        username: "".toLowerCase(),
        emailAddress: "".toLowerCase(),
        status: "".toLowerCase(),
      }
    }
  },
  computed:{
    filteredList(){
      let arrayOne = []
      for(let each in this.search){
        if(this.search[each].length > 0) {
          console.log("Test")
          let checkSearch = this.search[each].toLowerCase()
          console.log(checkSearch)
          for (let user of this.users) {
            let checkUsers = user[each].toLowerCase()
            console.log(checkUsers)
            if (checkUsers.indexOf(checkSearch) !== -1) {
              arrayOne.push(user)
            }
          }
        }
      }
      return arrayOne
      // let array = Object.values(this.search)
      // if(array.length === 0){
      //   return this.users
      // }
      // array = array.filter((x) => x.length > 0)//       let array = Object.values(this.search)
      // if(array.length === 0){
      //   return this.users
      // }
      // array = array.filter((x) => x.length > 0)


      // let arrayOne = []
      //
      // for(let each of this.users){
      //   let arrayConditions = [
      //     each.firstName.toLowerCase().indexOf(this.search.firstName) !== -1,
      //     each.lastName.toLowerCase().indexOf(this.search.lastName) !== -1,
      //     each.username.toLowerCase().indexOf(this.search.username) !== -1,
      //     each.emailAddress.toLowerCase().indexOf(this.search.emailAddress) !== -1,
      //     each.status.toLowerCase().indexOf(this.search.status) !== -1,
      //   ]
      //   console.log(arrayConditions)
      //   if(arrayConditions.some((cu) => cu === true)){
      //     arrayOne.push(each)
      //   }
      // }
      // console.log(arrayOne)
      // return arrayOne
      // return []
    }
    }

// works but will not pass test
//       let array = Object.values(this.search)
//       if(array.length === 0){
//         return this.users
//       }
//       array = array.filter((x) => x.length > 0)
    //   let test = []
    //   for (let each of this.users){
    //     let objArray = Object.values(each).toString().toLowerCase()
    //     for(let other of array){
    //       if(objArray.indexOf(other) !== -1){
    //         test.push(each)
    //         break
    //       }
    //     }
    //   }
    //   return test
    //   }
    // }

  // works but will not pass test// works but will not pass test
    // let array = Object.values(this.search)
    // let test = []
    // for (let each of this.users){
    //   console.log(each.toString())
    //   for (let i =0; i < array.length; i++){
    //     let currentObjValue = Object.values(each)[i]
    //     let currentValue = array[i]
    //     if(currentObjValue.includes(currentValue)){
    //       test.push(each)
    //     }
    //   }
    // }
    // console.log(test)
    // return test
    // }
  // for(let i = 0; i < array.length; i++){
  //   if(objArray[i].indexOf(array[i])){
  //     let text = "checking " + objArray[i] + " = " + "array list " + array[i]
  //     console.log(text)
  //     console.log(objArray[i].includes(array[i]))
  //     test.push(each)
  //     break
  //   }
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
