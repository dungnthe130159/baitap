<template>
    <div class="d-flex flex-wrap container-uview">
        <h2 style=" margin-left: 20px; padding-top: 10px" >Hotel Booking System - User Dashboard</h2>
        <div class="container-uviewin">
            <div style="margin-bottom: 10px;">       
                <a href="/home" class="nav-link">Home</a>
                <a href="/usersView" class="nav-link">Dashboard</a>
                <a href="/about" class="nav-link">About</a>
                <a href="/roomAvailable" class="nav-link">RoomAvailable</a>
                <a href="/#" class="nav-link">My Booking</a>
                <a href="/#" class="nav-link">My Acount</a>
                <a href="/#" class="nav-link">Log out</a>
            </div>
        </div>
        <img src="https://www.stampli.com/wp-content/uploads/2022/05/01-STAMPLI__-hotel_hero-1536x864.png.webp">
    </div>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    

@Component
export default class UserView extends Vue  {

}
</script>

<style scoped>
img{
    margin-top: 15px;
    width: 38%;
    background-color: aqua;
    margin-bottom: 20px;
}
a{
    padding: 10px;
    border-radius: 5px;
    border: 20x;
    width: 95%;
    height: 90%;
    margin-top: 10px;
    background-color: darkseagreen;
    margin-left: 20px;
}
.container-uviewin{
    width: 60%;
    height: 90%;    
}
.container-uview{
    width: 90%;
    background-color: antiquewhite ;
    margin-top:20px;
    margin-left: 70px;

}
</style>