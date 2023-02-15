<template>
  <div class="body">
    <!-- <div v-if="!submitted"> -->
        <div class="container">
          <h1>Register</h1>
          <p>Please fill in this form to create an account.</p>
          <hr>
          <label for="email"><b>Username</b></label>
          <input type="text" placeholder="Enter Username" v-model="user.username" name="username" id="username"
            required>

          <label for="email"><b>Phone</b></label>
          <input type="text" placeholder="Enter Your Phone" v-model="user.phone" name="phone" id="phone" required>

          <label for="email"><b>Address</b></label>
          <input type="text" placeholder="Enter Your Address" v-model="user.address" name="address" id="address"
            required>

          <label for="email"><b>Email</b></label>
          <input type="text" placeholder="Enter Email" v-model="user.email" name="email" id="email" required>

          <!-- <label for="psw"><b>Role</b></label>
          <input type="text" placeholder="Enter Role" v-model="user.role" name="role" id="role" required> -->

          <label for="psw"><b>Password</b></label>
          <input type="password" placeholder="Enter Password" v-model="user.password" name="psw" id="psw" required>

          <label for="psw-repeat"><b>Repeat Password</b></label>
          <input type="password" placeholder="Repeat Password" v-model="pswRepeat" name="psw-repeat" id="psw-repeat"
            required>
          <hr>
          <button v-on:click="saveUser" class="registerbtn">Register</button>
        </div>

        <div class="container signin">
          <p>Already have an account? <a href="/api/auth/signin">Sign in</a>.</p>
        </div>
    </div>

    <!-- <div v-else>
      <h4>You submitted successfully</h4>
            <button class="btn btn-success" @click="newUser">Add</button>
            <a class="btn btn-success" href="/">Home</a>
    </div>
  </div> -->
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import AuthService from '@/services/AuthService';
import User from '@/types/User';


@Component
export default class Register extends Vue {
  public user: User = {
    id: 0,
    username: "",
    password: "",
    address: "",
    phone: "",
    email: "",
  };

  public pswRepeat: string = "";
  public submitted: boolean = false;
  public message : string = "";

  saveUser() {
    let data = {
      username: this.user.username,
      password: this.user.password,
      phone: this.user.phone,
      address: this.user.address,
      email: this.user.email,
    };

    if(this.pswRepeat == this.user.password){
      AuthService.register(data)
      .then((response) => {
          if(response.data.id == null){
          alert(response.data.messageError)  
          this.user.id = response.data.id;
          this.submitted = true;        
          console.log(response.data);  
          this.$router.push("/signin")
        }else{
          console.log();
        }
      })
      .catch(() => {
        console.log();
      });
    }else{
      alert("Enter wrong password")
      console.log();
    }
  }

  newUser(){
    this.submitted =false;
    this.user = {} as User;
  }
}
</script>

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text],
input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus,
input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<!-- public login(request: any): Promise<any> {
  return Vue.axios.post(this.ROOT_URL, request)
    .then((res) => {
      if (res.headers['x-auth-token']) {
        // Success
        localStorage[this.token] = res.headers['x-auth-token'];
        const decoded: any = res.headers['x-auth-token'];
        return new LoginDetails({
          email: decoded.username,
          isLoginSuccess: true,
        });
      }
      return new LoginDetails({
        isLoginSuccess: false,
      });
    });       
} -->
