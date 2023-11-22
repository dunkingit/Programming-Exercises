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
            <input type="checkbox" v-bind:id="selectAll" v-on:click="toggleAll" v-model="permissions" />
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
                   class="checkboxButtons"
                   v-bind:id="user.id"
                   v-bind:value="user.id"
                   v-on:click="permissions.checked"
                   v-model="permissions"
                   />
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

    <div class="all-action" >
      <button :disabled="isButtonDisabled" v-on:click="changeStatuses('Active')">Activate Users</button>
      <button :disabled="isButtonDisabled" v-on:click="changeStatuses('Inactive')"  >Deactivate Users</button>
      <button :disabled="isButtonDisabled" v-on:click="deleteUsers">Delete Users</button>
    </div>
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
      selectAll: 'selectAll',
      permissions: [],
      allButtonState: false,
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
    staticButtonStatus(status) {
      // If the user status is Active, the button text displays Deactivate.
      //     If the user status is Inactive, the button text displays Activate.
      //     When you click the button, change the user's status from Active
      //     to Inactive, or Inactive to Active.
      return status.includes("Active") ? "Deactivate" : "Activate"
    },
    clickStaticButtonStatus(userId) {
      for (let each of this.users) {
        if (each.id == userId) {
          each.status = each.status == "Active" ? "Inactive" : "Active"
        }
      }
    },

    getNextUserId() {
      return this.nextUserId++;
    },
    showElementOrHide() {
      this.show = !this.show
    },

    addUser(event) {
      this.newUser.id = this.getNextUserId()
      this.users.push(this.newUser)
      event.target.id.reset()
    },

    checkBoxEvent(event) {
      console.log(this.permissions.length)
      let id = parseInt(event.target.id)
      if (!this.arrayUserIds.includes(id)) {
        this.arrayUserIds.push(id)
        console.log(this.arrayUserIds.includes(id))
      } else {
        this.arrayUserIds = this.arrayUserIds.filter((cu) => cu !== id)
      }
    },


    changeStatuses(check) {
      this.arrayUserIds.forEach(cu => this.users.forEach(cu2 => cu === cu2.id ? cu2.status = check : null))
    },

    deleteUsers() {
      this.users = this.users.filter(cu => !this.arrayUserIds.includes(cu.id))
      this.arrayUserIds = []
    },

    toggleAll() {
      let x = document.getElementsByClassName("checkboxButtons")
      for (let each in x){
        let id = parseInt(x[each].id)
        let sid = x[each].id
        x[each].model = this.permissions.checked
        console.log(sid)
        if(!this.permissions.includes(id)){
          try{sid.click()}
          catch (e){console.log(e)}
          console.log("trigger")
        }
      }

    }
  },

  computed: {
    checking(id){
      return document.getElementById(id).checked? "checked":"unchecked"
    },

    isButtonDisabled() {
      return this.arrayUserIds.length === 0;
    },


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
.btn.save {
  margin: 20px;
  float: right;
}
</style>
