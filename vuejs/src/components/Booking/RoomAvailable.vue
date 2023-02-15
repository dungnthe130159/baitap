<template>
    <div>
        <div class="welcome">
            <p>All Number Room Avaiable</p>
        </div>
        <div class="container-avaiable">
            <div>
                <h5>Select your Room Type</h5>
                <select style="margin-bottom: 10px;" class="list" v-model="nameFind" @change="searchName(nameFind)">
                    <option defaults value="all">All Rooms</option>
                    <option value="KINGROOM">King Room</option>
                    <option value="LUXURYROOM">Luxury Room</option>
                    <option value="NORMALROOM">Normal Room</option>
                </select>

                <div v-if="nameFind === 'all'" style="margin-left: 120px;" class="d-flex flex-wrap">
                    <div class="room" :class="{ active: index == currentIndex }" v-for="(room, index) in rooms "
                        :key="index" @click="setActiveRoom(room, index)">
                        <div v-if="room.category.id === 1">
                            <img class="img-table"
                                src="https://images.unsplash.com/photo-1544006659-f0b21884ce1d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fGxhcHRvcHxlbnwwfHwwfHw%3D&w=1000&q=80">
                            <div>
                                <p>Room Number : {{ room.number }}</p>
                            </div>
                            <div>
                                <p>Category Room : {{ room.category.categoryName }}</p>
                            </div>
                            <div class="p">Max Adults : 4 Adults</div>
                            <div class="p">Total Bed : 5 Beds</div>
                        </div>
                    </div>
                    <div class="room" :class="{ active: index == currentIndex }" v-for="(room, index) in rooms "
                        :key="index" @click="setActiveRoom(room, index)">
                        <div v-if="room.category.id === 2">
                            <img class="img-table"
                                src="https://images.unsplash.com/photo-1499914485622-a88fac536970?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80">
                            <div>
                                <p>Room Number : {{ room.number }}</p>
                            </div>
                            <div>
                                <p>Category Room : {{ room.category.categoryName }}</p>
                            </div>
                            <div class="p">Max Adults : 3 Adults</div>
                            <div class="p">Total Bed : 2 Beds</div>
                        </div>
                    </div>
                    <div class="room" :class="{ active: index == currentIndex }" v-for="(room, index) in rooms "
                        :key="index" @click="setActiveRoom(room, index)">
                        <div v-if="room.category.id === 3">
                            <img class="img-table"
                                src="https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1172&q=80">
                            <div>
                                <p>Room Number : {{ room.number }}</p>
                            </div>
                            <div>
                                <p>Category Room : {{ room.category.categoryName }}</p>
                            </div>
                            <div class="p">Max Adults : 2 Adults</div>
                            <div class="p">Total Bed : 1 Beds</div>
                        </div>
                    </div>

                </div>
                <div v-if="nameFind === 'KINGROOM'" style="margin-left: 120px;" class="d-flex flex-wrap">
                    <div class="room" :class="{ active: index == currentIndex }" v-for="(room, index) in categories "
                        :key="index" @click="setActiveRoom(room, index)">
                        <div>
                            <img class="img-table"
                                src="https://images.unsplash.com/photo-1544006659-f0b21884ce1d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fGxhcHRvcHxlbnwwfHwwfHw%3D&w=1000&q=80">
                            <div>
                                <p>Room Number : {{ room.number }}</p>
                            </div>
                            <div>
                                <p>Category Room : {{ room.category.categoryName }}</p>
                            </div>
                            <div class="p">Max Adults : 4 Adults</div>
                            <div class="p">Total Bed : 5 Beds</div>
                        </div>
                    </div>
                </div>
                <div v-if="nameFind === 'LUXURYROOM'" style="margin-left: 120px;" class="d-flex flex-wrap">
                    <div class="room" :class="{ active: index == currentIndex }" v-for="(room, index) in categories "
                        :key="index" @click="setActiveRoom(room, index)">
                        <div>
                            <img class="img-table"
                                src="https://images.unsplash.com/photo-1499914485622-a88fac536970?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80">
                            <div>
                                <p>Room Number : {{ room.number }}</p>
                            </div>
                            <div>
                                <p>Category Room : {{ room.category.categoryName }}</p>
                            </div>
                            <div class="p">Max Adults : 3 Adults</div>
                            <div class="p">Total Bed : 2 Beds</div>
                        </div>
                    </div>
                </div>
                <div v-if="nameFind === 'NORMALROOM'" style="margin-left: 120px;" class="d-flex flex-wrap">
                    <div class="room" :class="{ active: index == currentIndex }" v-for="(room, index) in categories "
                        :key="index" @click="setActiveRoom(room, index)">
                        <div>
                            <img class="img-table"
                                src="https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1172&q=80">
                            <div>
                                <p>Room Number : {{ room.number }}</p>
                            </div>
                            <div>
                                <p>Category Room : {{ room.category.categoryName }}</p>
                            </div>
                            <div class="p">Max Adults : 2 Adults</div>
                            <div class="p">Total Bed : 1 Beds</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="room-detail" v-if="currentRoom.id">

            <h4>Room Detail</h4><br>
            <table class="table-room-detail">
                <tr>
                    <td><label><strong>Category Room</strong></label></td>
                    <td><label><strong>Number Room</strong></label></td>
                    <td><label><strong>Price Room</strong></label></td>
                    <td><label><strong>Price Room</strong></label></td>
                </tr>
                <tr>
                    <td>{{ currentRoom.category.categoryName }}</td>
                    <td>{{ currentRoom.number }}</td>
                    <td>{{ currentRoom.price }}</td>
                    <td>
                        <label>Available </label>
                        <a class="m-1 btn btn-sm btn-warning" :href="'/bookRoom/'">
                            BookRoom
                        </a>
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
export default class RoomAvailable extends Vue {
    public rooms: Room[] = [];
    public currentIndex: number = -1;
    public currentRoom = {} as Room;

    public nameFind: string = "all";
    public categories: Room[] = [];

    retrieveUsers() {
        return BookingService.findAvailableRooms().then((res) => {
            this.rooms = res.data;
            console.log(this.rooms);
        })
            .catch((e) => {
                console.log(e)
            })
    }
    mounted() {
        this.retrieveUsers();
    }

    setActiveRoom(room: Room, index: number) {
        this.currentIndex = index;
        this.currentRoom = room;
    }

    searchName(name: any) {
        BookingService.findCategoryByName(name)
            .then((response) => {
                this.categories = response.data;
                console.log(this.categories);
            })
            .catch((e) => {
                console.log((e))
            })
    }

    CategoryChanged(e: any) {
        if (e.target.option.selectedIndex = 1) {
            console.log(e)
        }
    }

}
</script>

<style scoped>
.list {
    background-color: #f2f2f2;
    padding: 8px 16px;
    border-radius: 3px;
}

.container-avaiable {
    margin: 3px auto;
    width: 100%;
    background-color: transparent;
}

.room {
    border-radius: 5px;
    background-color: #f2f2f2;
}

.p {
    padding-top: 5px;
    padding-bottom: 5px;
}

.table-room-detail {
    width: 80%;
    margin-left: 13%;
    margin-right: 13%;
}

.room-detail {
    margin-left: 10%;
    margin-right: 10%;
    width: 50%;
    height: 150px;
    border-radius: 5px;
    padding: 10px;
    background-color: #f2f2f2;
}

.btn {
    background-color: #04aa6d;
    color: white;
    padding: 12px 15px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100px;
}

.search-gruop {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}

.welcome {
    /* font-family:sans-serif; */
    font-weight: bolder;
    font-size: large;
    text-align: left;
    margin-top: 10px;
    margin-left: 50px;
}

.img-table {
    width: 310px;
    height: 233px;
    margin-right: 13px;
    padding: 10px;
}
</style>