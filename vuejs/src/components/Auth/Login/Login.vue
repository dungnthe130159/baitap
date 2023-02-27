<template src="./Login.html"></template>
<style lang="scss" scoped src="./Login.scss"></style>

<script lang="ts">
import AuthService from "@/services/AuthService";
import User from "@/types/User";
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Login extends Vue {

  public user: User = {
    id: 0,
    username: "",
    password: "",
    address: "",
    phone: "",
    email: "",
  };

  handleLogin() {
    console.log("login function");

    let data = {
      username: this.user.username,
      password: this.user.password,
      // phone : this.user.phone,
      // address : this.user.address,
      // email : this.user.email,
    };

    AuthService.login(data)
      .then((response) => {
        localStorage.setItem("id", response.data.id)
        localStorage.setItem("username", response.data.username)
        localStorage.setItem("address", response.data.address)
        localStorage.setItem("phone", response.data.phone)
        localStorage.setItem("email", response.data.email)

        this.user.id = response.data.id;
        response.data.roles.forEach((item: any) => {
          if (item == "ROLE_ADMIN") {
            console.log(item)
            this.$router.push("/adminView");
          } else {
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


