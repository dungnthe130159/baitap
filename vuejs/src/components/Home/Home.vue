<template src="./Home.html"></template>
<style lang="scss" scoped src="./Home.scss"></style>

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

