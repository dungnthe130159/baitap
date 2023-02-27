<template>
  <div id="app" class="body">
    <nav class="navbar ">
      <h4 class="bookinghotel">BookingHotel</h4>
    </nav>
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <a href="/home" class="nav-link">Home</a>
        </li>
        <li class="nav-item">
          <a href="/categories" class="nav-link">Room Type</a>
        </li>
        <li class="nav-item">
          <a href="/roomAvailable" class="nav-link">All Rooms</a>
        </li>
        <div v-if="login" class="d-flex flex-wrap">
          <div class="nav-item" style="margin-left: 1050px;">
            <a href="/signin" class="nav-link">Login</a>
          </div>
        </div>
        <div v-else style="margin-left: 970px;" class="d-flex flex-wrap">
          <div class="nav-item">
            <a style="margin-left: 2px; width: 50px;" href="/profile" class="nav-link">
              <img src="https://t3.ftcdn.net/jpg/03/46/83/96/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg"
                style="width: 30px; height: 30px; border-radius: 10px;" /></a>
          </div>
          <div class="nav-item">
            <a href="/home" class="nav-link" v-on:click="LogOut">Log Out</a>
          </div>
        </div>

      </div>
    </nav>
    <router-view></router-view>
    <!-- <Home></Home> -->
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import Home from './components/Home.vue';

@Component({
  components: {
    Home
  }
})
export default class App extends Vue {
  login: boolean = true;

  CheckLogin() {
    if (localStorage.getItem("username") === null) {
      console.log("true")
      this.login = true
    } else {
      this.login = false
      console.log("false")

    }
  }

  LogOut() {
    localStorage.clear()
    this.login = true
  }

  beforeUpdate() {
    this.CheckLogin();
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.bookinghotel {
  padding-top: 8px;
  padding-left: 50px;
  font-weight: bold;

}
</style>
