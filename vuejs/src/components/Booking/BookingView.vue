<template>
    <div class="containerBV">
        <table style="margin:40px 0px 0px 40px;">
            <div style="margin-top: 20px;">
                <tr > 
                    <td>Id</td>
                    <td>Room</td>
                    <td>User Name</td>
                    <td>Phone</td>
                    <td>Email</td>
                    <td>Address</td>
                    <td>Date From</td>
                    <td>Date To</td>
                    <td>Total Price</td>
                </tr>
                <tr v-for="booking in bookings" :key="booking.id">
                    <td>{{ booking.id }}</td>
                    <td style="width: 210px;">{{ booking.room.category.categoryName}}
                        <br>Room Number : {{ booking.room.number }}</td>
                    <td>{{ booking.user.username }}</td>
                    <td>{{ booking.user.phone }}</td>
                    <td>{{ booking.user.email }}</td>
                    <td>{{ booking.user.address }}</td>
                    <!-- <td>{{ booking.dateFrom | formatDate }}</td> -->
                    <td>{{ booking.dateFrom }}</td>
                    <td>{{ booking.dateTo   }}</td>
                    <td>{{ booking.totalPrice }}</td>
                </tr>
            </div>
        </table>
    </div>
</template>

<script lang="ts">
    import {Component ,Vue} from 'vue-property-decorator'
    import BookingService from '@/services/BookingService';
    import Booking from '@/types/Booking';
    import moment from 'moment'

    @Component
    export default class BookingView extends Vue{
        public bookings : Booking[] =[];

        retriveBooking(){
            return BookingService.findAllBooking()
            .then((response) => {
                    response.data.forEach((item: any) => {
                        item.dateFrom = moment(item.dateForm).format('MMMM Do YYYY')
                        item.dateTo = moment(item.dateTo).format('MMMM Do YYYY')
                        
                        return item
                    })
                    this.bookings = response.data
                    console.log(this.bookings)
            }).catch((e) => {
                console.log(e)
            })
        }

        mounted(){
            this.retriveBooking();
        }
    }

    
</script>

<style scoped>
td{
    padding: 5px;
    padding-right: 14px;
}
tr{
    padding: 20px;
    height: 50px;
}
.containerBV{
    width: 90%;
    height: 100%;
    background-color: rgb(222, 206, 206);
    margin-left: 65px ;
}
</style>
<!-- https://laracasts.com/discuss/channels/laravel/how-to-change-date-format-in-vue-js -->