<template>
  <div class="body">
    <h2 style="margin-top: 10px;">Login Form</h2>
      <div class="container" style="margin-top: 20px;">
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username"
        v-model="user.username" name="username" required />

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" 
        v-model="user.password" name="password" required />

        <button type="submit" v-on:click="handleLogin">Login</button>
      </div>

      <div class="container">
        <!-- <button type="button" class="cancelbtn">Cancel</button> -->
        <span class="psw"><a style="all:unset" href="#">Forgot password?</a></span>
      </div>
  </div>
  
</template>

<script lang="ts">
import AuthService from "@/services/AuthService";
import User from "@/types/User";
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Login extends Vue {

  public user: User = {
      id : 0,
      username : "",
      password:"",
      address : "",
      phone : "",
      email : "",
  };

  handleLogin() {
    console.log("login function");

    let data = {
      username : this.user.username,
      password : this.user.password,
      // phone : this.user.phone,
      // address : this.user.address,
      // email : this.user.email,
    };
             
    AuthService.login(data)
    .then((response) => {
    localStorage.setItem("id",response.data.id)
    localStorage.setItem("username",response.data.username) 
    localStorage.setItem("address",response.data.address)
    localStorage.setItem("phone",response.data.phone)
    localStorage.setItem("email",response.data.email)

      this.user.id = response.data.id;
      response.data.roles.forEach((item:any) => {
        if(item == "ROLE_ADMIN"){
          console.log(item)
          this.$router.push("/adminView");
        }else{
          console.log(item)
          this.$router.push("/usersView");
        }
      })
    })
    .catch(() => {
      console.log();
    });
  }
}
</script>

<style scoped>
body {
  font-family: Arial, Helvetica, sans-serif;
}

form {
  border: 3px solid #f1f1f1;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04aa6d;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
    display: block;
    float: none;
  }

  .cancelbtn {
    width: 100%;
  }
}
</style>

