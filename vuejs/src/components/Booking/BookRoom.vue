<template>
        <div>
                <div class="Vuejs">
                        <h1 style="margin-top: 20px;"> Book Room</h1><br>

                </div>
                <div class="container-book d-flex flex-wrap">
                        <div class="book-in1">
                                <label for="room">User name</label><br>
                                <label for="user">Room ID</label><br>
                                <label for="feature">From Date</label><br>
                                <label for="year">To Date</label><br>
                                <label for="year">Total Price</label><br>
                        </div>
                        <div class="book-in2">
                                <input type="text" placeholder="Enter Your Username" v-model="booking.user.username"
                                        required /><br>
                                <input type="text" placeholder="Enter RoomID" v-model="booking.room.id" required
                                        v-on:change="totalPrice" /><br>
                                <input type="date" placeholder="dd/mm/yyyy" v-model="booking.dateFrom" required
                                        v-on:change="totalPrice" /><br>
                                <input type="date" placeholder="dd/mm/yyyy" v-model="booking.dateTo" required
                                        v-on:change="totalPrice" /><br>
                                <label style="color: red;">{{ booking.totalPrice }}$</label>
                        </div>
                        <div class="book-in3">
                                <button style="width: 80px; background-color: azure;padding: 7px;border-radius: 5px;"
                                        v-on:click="saveBooking">Book</button>
                        </div>
                </div>

        </div>
</template>

<script lang="ts">
import Booking from '@/types/Booking';
import { Component, Vue } from 'vue-property-decorator';
import User from '@/types/User';
import Room from '@/types/Room';
import 'vue2-datepicker/index.css';
import UserDataService from '@/services/UserDataService';
import BookingService from '@/services/BookingService';
import moment from 'moment';

@Component
export default class BookRoom extends Vue {
        public datenow = moment(new Date).format('YYYY-MM-DD')
        public booking: Booking = {
                id: 0,
                user: {} as User,
                room: {} as Room,
                dateFrom: new Date,
                dateTo: new Date,
                totalPrice: 0
        };

        // currentDate(){
        //         const current = new Date();
        //         // const date = `${current.getDate()}/${current.getMonth()+1}/${current.getFullYear()}`
        //         // const date = moment(new Date())
        //         return current

        // };

        saveBooking() {
                UserDataService.findByUserName(this.booking.user.username)
                        .then((res) => {
                                this.booking.user.id = res.data.id;
                                var user = {
                                        id: this.booking.user.id
                                }
                                var room = {
                                        id: this.booking.room.id
                                }
                                var dateform = moment(this.booking.dateFrom).format('YYYY-MM-DD')
                                var dateto = moment(this.booking.dateTo).format('YYYY-MM-DD')
                                const diffInDays = moment(dateto).diff(moment(dateform), 'days')

                                BookingService.findRoomByID(this.booking.room.id)
                                        .then((res) => {
                                                this.booking.totalPrice = res.data.price * diffInDays
                                                if (moment(this.datenow).isBefore(dateform) && moment(dateform).isBefore(dateto)) {
                                                        let data = {
                                                                user, room,
                                                                dateFrom: this.booking.dateFrom,
                                                                dateTo: this.booking.dateTo,
                                                                totalPrice: this.booking.totalPrice
                                                        };
                                                        BookingService.booking(data).then((res) => {
                                                                console.log(res);
                                                                this.$router.push("/bookingView")
                                                        })
                                                } else {
                                                        alert("wrong date")
                                                }
                                        }).catch((e) => {
                                                console.log(e);
                                        })
                        }).catch((e) => {
                                console.log(e)
                        });
        }
        totalPrice() {
                var dateform = moment(this.booking.dateFrom).format('YYYY-MM-DD')
                var dateto = moment(this.booking.dateTo).format('YYYY-MM-DD')
                const diffInDays = moment(dateto).diff(moment(dateform), 'days')

                BookingService.findRoomByID(this.booking.room.id)
                        .then((res) => {
                                this.booking.totalPrice = res.data.price * diffInDays
                                if(this.booking.totalPrice >= 0){
                                        return this.booking.totalPrice
                                }else{
                                        return this.booking.totalPrice = 0;
                                }
                                
                        }).catch((e) => {
                                console.log(e)
                        })
        }
}

</script>

<style scoped>
.Vuejs input {
        padding: 0.75em 0.5em;
        font-size: 100%;
        border: 1px solid #ccc;
        widows: 120px;
}

.book-in1 {
        margin-top: 20px;
        width: 50%;
}

.book-in2 {
        margin-top: 20px;
        width: 50%;
}

.book-in3 {
        margin-left: 450px;
        padding: 10px;
}

label {
        text-align: center;
        background-color: azure;
        width: 85%;
        height: 45px;
        margin-top: 20px;
        border-radius: 10px;
        padding-top: 10px;
}

input {
        text-align: center;
        background-color: azure;
        width: 85%;
        height: 45px;
        margin-top: 20px;
        border-radius: 10px;
        padding-top: 10px;
}

.container-book {
        width: 65%;
        height: 450px;
        background-color: antiquewhite;
        margin-top: 5px;
        /* margin-left: 70px; */
        position: absolute;
        margin-left: auto;
        margin-right: auto;
        left: 0;
        right: 0;
        text-align: center;
        border-radius: 20px;
}
</style>
