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
            <input type="checkbox" id="selectAll" />
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
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ deactivated: user.status === 'Inactive' }"
        >
          <td>
            <input type="checkbox"
                   v-bind:id="user.id"
                   v-bind:value="user.id"
                   v-on:click="checkBoxEvent($event)"/>
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>

            <button class="btnActivateDeactivate" v-on:click="clickStaticButtonStatus(user.id)">{{ staticButtonStatus(user.status) }}</button>
          </td>
        </tr>
      </tbody>
    </table>

    <div v-bind:class="{ deactivated: this.arrayUserIds.length === 0 , 'all-actions':this.arrayUserIds.length !== 0}" >
      <button>Activate Users</button>
      <button>Deactivate Users</button>
      <button>Delete Users</button>
    </div>
<!--    v-on:click="showElementOrHide"-->
    <button   v-on:click="showElementOrHide">Add New User</button>
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
      arrayUserIds: [],
      show: false,
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
    staticButtonStatus(status){
      // If the user status is Active, the button text displays Deactivate.
      //     If the user status is Inactive, the button text displays Activate.
      //     When you click the button, change the user's status from Active
      //     to Inactive, or Inactive to Active.
     return status.includes("Active")? "Deactivate":"Activate"
    },
    clickStaticButtonStatus(userId){
      for(let each of this.users){
        if(each.id === userId){
          each.status = each.status == "Active"?"Inactive":"Active"
        }
      }
    },
    getNextUserId() {
      return this.nextUserId++;
    },
    showElementOrHide(){
      this.show = !this.show
    },
    showElement(){
      this.show = true
    },
    hideElement(){
      this.show = false
    },
    addUser(event){
      this.newUser.id = this.getNextUserId()
      this.users.push(this.newUser)
      event.target.id.reset()
    },

    checkBoxEvent(event){
      let id = event.target.id
      let checkInArray = this.arrayUserIds.indexOf(event.target.id)
      let condition = checkInArray === -1
      if(condition){
        this.arrayUserIds.push(id)
      }else{
        this.arrayUserIds = this.arrayUserIds.filter((cu) => cu !== id)
      }
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
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.status === this.filter.status
        );
      }
      return filteredUsers;
    }
  }
};
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
.btn.save {
  margin: 20px;
  float: right;
}
</style>
