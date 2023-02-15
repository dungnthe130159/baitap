<template>
  <div>
    <div class="bookinghotel-background"></div>
    <div class="welcome">
      <p>Welcome to Hotel Room BookingSystem</p>
    </div>
    <div class="box-contain">
      <div class="table-home">
        <table>
          <tr>
            <td>
              <img class="img-table"
                src="https://thumbs.dreamstime.com/b/beach-background-beautiful-beach-landscape-tropical-nature-scene-palm-trees-blue-sky-summer-holiday-vacation-concept-93725354.jpg"
                alt="anh1" />
            </td>
            <td>
              <img class="img-table"
                src="https://images.unsplash.com/photo-1615914143778-1a1a6e50c5dd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8d29ya2luZyUyMG9uJTIwbGFwdG9wfGVufDB8fDB8fA%3D%3D&w=1000&q=80"
                alt="anh2" />
            </td>
            <td>
              <img class="img-table"
                src="https://images.unsplash.com/photo-1544006659-f0b21884ce1d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fGxhcHRvcHxlbnwwfHwwfHw%3D&w=1000&q=80"
                alt="anh3" />
            </td>
          </tr>
          <tr>
            <td>
              <p class="p-head-home">Room booking system</p>
              <p class="p-content-home">
                We make use of innovative measures to back our approach to
                streamline the online venue booking process and make it simpler
                and easier for our customers. Our easy yet intuitive online
                venue booking mechanism, which is crafted especially for the
                convenience of people
              </p>
            </td>
            <td>
              <p class="p-head-home">Online Hotel Booking</p>
              <p class="p-content-home">
                We make use of innovative measures to back our approach to
                streamline the online venue booking process and make it simpler
                and easier for our customers. Our easy yet intuitive online
                venue booking mechanism, which is crafted especially for the
                convenience of people
              </p>
            </td>
            <td>
              <p class="p-head-home">Online Payment System</p>
              <p class="p-content-home">
                We make use of innovative measures to back our approach to
                streamline the online venue booking process and make it simpler
                and easier for our customers. Our easy yet intuitive online
                venue booking mechanism, which is crafted especially for the
                convenience of people
              </p>
            </td>
          </tr>
        </table>
      </div>
    </div>
    <div class="welcome">
      <p>About Room BookingSystem</p>
    </div>
    <div>
      <p class="p-content-long">
        We make use of innovative measures to back our approach to streamline
        the online venue booking process and make it simpler and easier for our
        customers. Our easy yet intuitive online venue booking mechanism, which
        is crafted especially for the convenience of people living in Delhi NCR,
        Gurgaon, Noida Faridabad, and Ghaziabad, makes online venue booking much
        simpler and faster than its counterpart- offline booking. At RoomMonk,
        we have a wide range of exclusive Wedding Rooms, Wedding Reception
        Rooms, Engagement Rooms, Pre-Wedding Party Rooms, Birthday Party Rooms,
        Kids Party Rooms, First Birthday Party Rooms, Corporate Party Rooms,
        Corporate Event Rooms, Conference Rooms, Bachelor Party Rooms, Business
        Meeting Rooms, Business Dinner Rooms, Exhibition Rooms etc. At RoomMonk,
        we have a wide range of venue categories like Banquet Hall, Farm Houses,
        Lawns, Restaurants, Clubs, Bars, Meeting Rooms, Conterence Rooms,
        Pool-Side Rooms, Rooftop Rooms, and more for every type of celebration,
        People can now book the best venues in their city with just a few clicks
        through RoomMonk. We look forward to raising the bar for online venue
        booking in Delhi NCR Gurgaon, Noida, Faridabad, and Ghaziabad by
        providing necessary features to our customers like prompt customer
        services, faster bookings, and online payments. We are very keen on
        providing our customers with the best venues for their events. When it
        comes to quality and service of the venues or vendors, we never
        compromise on it. Moreover, we offer accurate and updated descriptions
        and transparent pricing for all our venues so that our customers get a
        clarity of the venue they are booking.
      </p>
    </div>
    <div class="welcome">
      <p>Choose Your Room Type</p>
    </div>

    <div class="room-type d-flex">
      <div v-for="category in categories" :key="category.id" class="flex-fill">
        <div class="category-img" v-if="category.id===1">
          <a href="/categories"><img
              src="https://themirahotel.com.vn/wp-content/uploads/2016/11/620x458px-2-7.jpg"
              style="width: 410px; height: 190px;" /></a><br>
          {{ category.categoryName }}
        </div>
        <div class="category-img" v-if="category.id===2">
          <a href="/categories"><img
            src="https://media.istockphoto.com/id/1050564510/photo/3d-rendering-beautiful-luxury-bedroom-suite-in-hotel-with-tv.jpg?s=612x612&w=0&k=20&c=ZYEso7dgPl889aYddhY2Fj3GOyuwqliHkbbT8pjl_iM="
              style="width: 410px; height: 190px;" /></a><br>
          {{ category.categoryName }}
        </div>
        <div class="category-img" v-if="category.id===3">
          <a href="/categories"><img
            src="https://thumbs.dreamstime.com/b/beautiful-hotel-room-25954964.jpg"
              style="width: 410px; height: 190px;" /></a><br>
          {{ category.categoryName }}
        </div>
      </div>
    </div>
  </div>

</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import BookingService from '@/services/BookingService';
import Room from '@/types/Room';
import Category from '@/types/Category';

@Component
export default class Home extends Vue {
  public categories: Category[] = [];
  public currentRoom: Room[] = [];

  retrieveUsers() {
    return BookingService.findAllCategory().then((res) => {
      this.categories = res.data;
      console.log(res.data);
    })
      .catch((e) => {
        console.log(e)
      })
  }

  mounted() {
    this.retrieveUsers();
  }

  // findCategoryRoom(categoyFind: string) {
  //   return BookingService.findCategoryByName(categoyFind)
  //     .then((response) => {
  //       this.currentRoom = response.data;
  //       console.log(response.data);
  //     })
  //     .catch((e) => {
  //       console.log(e)
  //     })

  // }

  // FindByCategoryName(name: string) {
  //   return BookingService.findCategoryByName(name)
  // }
}
</script>

<style scoped>
.category-img{
  padding: 10px;
  
}
.room-type {
  margin-left: 50px;
}

.p-content-home {
  text-align: center;
  padding: 5px;
}

.p-content-long {
  text-align: left;
  margin-left: 50px;
}

.p-head-home {
  font-weight: bold;
  padding: 3px;
}

.table-home {
  margin-left: 30px;
}

.img-table {
  width: 410px;
  height: 233px;
  margin-right: 13px;
}

.welcome {
  /* font-family:sans-serif; */
  font-weight: bolder;
  font-size: large;
  text-align: left;
  margin-top: 10px;
  margin-left: 50px;
}

.bookinghotel-background {
  width: 100%;
  height: 30vh;
  background-image:
    linear-gradient(180deg, rgba(255, 255, 255, 0.2), rgba(51, 224, 213, 0.2));
  /* url(https://images.unsplash.com/photo-1625244724120-1fd1d34d00f6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aG90ZWxzfGVufDB8fDB8fA%3D%3D&w=1000&q=80); */
  background-size: 100% 100%;
  background-repeat: no-repeat;
}

.box-contain {
  margin-left: 50px;
  margin-right: 50px;
  background-color: blanchedalmond;
}
</style>
