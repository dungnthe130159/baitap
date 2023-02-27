<template src="./RoomAvailable.html"></template>
<style lang="scss" scoped src="./RoomAvailable.scss"></style>

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