<template src="./BookingView.html"></template>
<style lang="scss" scoped src="./BookingView.scss"></style>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import BookingService from '@/services/BookingService';
import Booking from '@/types/Booking';
import moment from 'moment'

@Component
export default class BookingView extends Vue {
  public bookings: Booking[] = [];

  retriveBooking() {
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

  mounted() {
    this.retriveBooking();
  }
}
</script>