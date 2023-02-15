<template>
    <div class="container-rm">
        <h4 style="padding: 20px; text-align: left; font-weight: bolder;">All Room Report</h4>
        <div class="contain">
            <div class="add-nr">
                <button class="new-room"><a style="all: unset;" href="/addRoom">
                        Add New Room
                    </a></button>
            </div>
            <table class="table-nr">
                <tr style="padding-bottom: 10px; font-weight: bolder;">
                    <td>ID</td>
                    <td>Number Room</td>
                    <td>Price</td>
                    <td>Room Type</td>
                    <td>Action</td>
                </tr>
                <tr class="tr-nr" v-for="room in rooms" :key="room.id">
                    <td>{{ room.id }}</td>
                    <td>{{ room.number }}</td>
                    <td>{{ room.price }}</td>
                    <td>{{ room.category.categoryName }}</td>
                    <td v-if="room.available === 1">                                
                            <button style="border-radius: 5px;padding: 5px; background-color: antiquewhite; color: green; margin: 10px 0px 10px 0px; font-size: large;">
                                <a style="all:unset; border: 2px;" href="/bookRoom">BookRoom</a></button> 
                    </td>                          
                    <td v-else style="color: red; font-size: large;">
                        Unavaialbe
                    </td>  
                </tr>
            </table>
        </div>
    </div>
</template>

<script lang="ts">
import Room from '@/types/Room';
import { Component, Vue } from 'vue-property-decorator';
import BookingService from '@/services/BookingService';

@Component
export default class RoomManagement extends Vue {
    public rooms: Room[] = [];

    retrieveRooms() {
        return BookingService.findAllRooms().then((res) => {
            this.rooms = res.data;
            console.log(this.rooms)
        }).catch((e) => {
            console.log(e)
        })
    }

    mounted() {
        this.retrieveRooms();
    }
}


</script>

<style scoped>
.add-nr {
    padding: 20px 20px 20px 0px;
    text-align: right;
}

.tr-nr {
    height: 50px;
    padding: 5px;
}

.table-nr {
    width: 100%;
    padding: 8px;
}

.new-room {
    width: 140px;
    height: 45px;
    background-color: rgb(37, 141, 84);
    color: white;
    border-radius: 3px;
    border: none;
}

.contain {
    width: 95%;
    height: auto;
    margin-left: 35px;
    background-color: rgb(222, 206, 206);
}
</style>