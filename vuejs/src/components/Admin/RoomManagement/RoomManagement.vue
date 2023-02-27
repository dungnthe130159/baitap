<template src="./RoomManagement.html"></template>
<style lang="scss" scoped src="./RoomManagement.scss"></style>

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