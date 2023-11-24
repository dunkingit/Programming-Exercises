<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input type="checkbox" id="selectAll"
                   v-bind:value="top" @change="checkAll(!toggle)" />
          </td>
          <td>
            <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Inactive">Inactive</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr id="boxes"
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ deactivated: user.status === 'Inactive' }"
        >
          <td>
            <input type="checkbox"
                   class="checkboxButtons"
                   v-bind:id="user.id"
                   v-bind:value="user.id"
                   v-model="permissions"
                   />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>

            <button class="btnActivateDeactivate" v-on:click="changeUniqueUserStatus(user.id)">{{ staticButtonStatus(user.status) }}</button>
          </td>
        </tr>
      </tbody>
    </table>
    <div class="all-action" :disabled="permissions.length == 0">
      <button :disabled="permissions.length == 0" v-on:click="clickStaticButtonStatus('Active')">Activate Users</button>
      <button :disabled="permissions.length == 0" v-on:click="clickStaticButtonStatus('Inactive')"  >Deactivate Users</button>
      <button :disabled="permissions.length == 0" v-on:click="deleteUsers">Delete Users</button>
    </div>
    <button   v-on:click="show = !show">Add New User</button>
    <form id="frmAddNewUser" v-show="show" v-on:submit.prevent="addUser($event)" v-bind="frmAddNewUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName"  v-model="newUser.firstName" />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName"  v-model="newUser.lastName"/>
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" v-model="newUser.username" />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input type="text" id="emailAddress" name="emailAddress" v-model="newUser.emailAddress"/>
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: false,
      hideBtn: true,
      buttonStatus: 0,
      toggle:false,
      top:0,
      permissions: [],
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      nextUserId: 7,
      newUser: {
        id: 0,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive"
        }
      ],
    }
  },
  methods: {
    staticButtonStatus(status) {
      // If the user status is Active, the button text displays Deactivate.
      //     If the user status is Inactive, the button text displays Activate.
      //     When you click the button, change the user's status from Active
      //     to Inactive, or Inactive to Active.
      return status.includes("Active") ? "Deactivate" : "Activate"
    },

    clickStaticButtonStatus(action){
      let array = this.permissions.filter(cu => parseInt(cu) != 0)
      array.forEach(cu => this.iterUsersChangeUserStatus(cu, action))
      this.clearCheckBoxes()
    },

    iterUsersChangeUserStatus(userId, action){
      let status = this.users.find(ele => ele.id == userId)
      status.status = action
    },

    changeUniqueUserStatus(userId){
      let status = this.users.find(ele => ele.id == userId)
      status.status = status.status == "Active"? "Inactive":"Active"
    },
    getNextUserId() {
      return this.nextUserId++;
    },
    addUser(event) {
      this.newUser.id = this.getNextUserId()
      this.users.push(this.newUser)
      event.target.id.reset()
    },
    deleteUsers() {
      this.permissions.forEach(cu => console.log("Deleting user: " + cu))
      this.users = this.users.filter(cu => !this.permissions.includes(cu.id))
      this.users.forEach(cu => console.log("Checking current user id's: " + cu.id))
      let condition = this.users.every(cu => !this.permissions.includes(cu.id))
      console.log(condition)
      this.permissions = this.permissions.filter(cu => cu != 0)
      this.clearCheckBoxes()
    },
    checkAll(toToggle){
      this.toggle = toToggle
      let all = document.getElementsByClassName("checkboxButtons")
      for(let each in all){
        if(typeof all[each] == "object"){
          if(toToggle && !all[each].checked){
              this.permissions.push(parseInt(all[each].id))
              console.log(all[each].id)
          }
          all[each].checked = toToggle
        }
      }
      if(!toToggle){
        this.permissions = []
      }
    },

    checkList(id){
      this.permissions.includes(id)? this.permissions = this.filter(cu => cu != id):this.permissions.push(id)
      console.log(this.permissions.toString())
    },

    clearCheckBoxes(){
      for (let i = 0; i < 7; i++) {
        document.getElementById(i).checked = false
      }
      this.permissions = []
    }
  },

  computed: {
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
            user.firstName
                .toLowerCase()
                .includes(this.filter.firstName.toLowerCase())
        )
      }


      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
            user.lastName
                .toLowerCase()
                .includes(this.filter.lastName.toLowerCase())
        )
      }


      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
            user.username
                .toLowerCase()
                .includes(this.filter.username.toLowerCase())
        )
      }


      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
            user.emailAddress
                .toLowerCase()
                .includes(this.filter.emailAddress.toLowerCase())
        )
      }


      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
            user.status === this.filter.status
        )
      }


      return filteredUsers;
    }
  }
}

</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}

.all-actions button{

}


.btn.save {
  margin: 20px;
  float: right;
}
</style>
