<template src="./BookRoom.html"></template>
<style lang="scss" scoped src="./BookRoom.scss"></style>

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
                                if (this.booking.totalPrice >= 0) {
                                        return this.booking.totalPrice
                                } else {
                                        return this.booking.totalPrice = 0;
                                }

                        }).catch((e) => {
                                console.log(e)
                        })
        }
}

</script>
