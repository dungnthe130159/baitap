<template>
    <div class="d-flex flex-wrap  container">
        <div class="dashboard-admin">
                <p>Dashboard</p>
                <a href="/roomManagement" class="nav-link">Room Management</a>
                <a href="/bookingView" class="nav-link">All Bookings</a>
                <a href="/bookRoom" class="nav-link">Add Booking</a>
                <a href="#" class="nav-link">Billing Management</a>
                <a href="#" class="nav-link">Biiling Category</a>
                <a href="/users" class="nav-link">Customer Management</a>
                <a href="#" class="nav-link">Contact Us Report</a>
                <a href="#" class="nav-link">Feedback Report</a>
                <a href="#" class="nav-link">Logout</a>
        </div>
        <div class="admin-portal">
            <h2 style=" margin-left: 20px; padding-top: 10px">Hotel Booking System - User Dashboard</h2>
            <div class="d-flex flex-wrap justify-content-center">
                <div class="link-content" style="margin-bottom: 10px;">
                    <a href="/home" class="nav-link">Home</a>
                    <a href="/usersView" class="nav-link">Dashboard</a>
                    <a href="/about" class="nav-link">About</a>
                    <a href="/roomAvailable" class="nav-link">RoomAvailable</a>
                    <a href="/#" class="nav-link">My Booking</a>
                    <a href="/#" class="nav-link">My Acount</a>
                    <a href="/#" class="nav-link">Log out</a>
                </div> 
                <img src="https://www.stampli.com/wp-content/uploads/2022/05/01-STAMPLI__-hotel_hero-1536x864.png.webp">
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class AdminView extends Vue {
    
}
</script>

<style scoped>
.link-content{
    width: 65%;
    height: 100%;
}
img{
    width: 33%;
    height: 20%;
    padding: 3px;

}
.container{
    margin-top: 10px;
}
a{
    padding: 10px;
    border-radius: 5px;
    border: 20x;
    width: 95%;
    margin-top: 10px;
    background-color: darkseagreen;
    margin-left: 20px;
}
.dashboard-admin {
    width: 20%;
    height: 100%;
    /* background-color: rgb(24, 26, 18); */
}
.admin-portal{
    width: 80%;
    height: 100%;
}

.d-flex{
    width: 100% !important;
}
</style>