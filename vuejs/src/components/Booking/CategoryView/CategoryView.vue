<template src="./CategoryView.html"></template>
<style lang="scss" scoped src="./CategoryView.scss"></style>

<script lang="ts">
import Category from '@/types/Category';
import { Component, Vue } from 'vue-property-decorator';
import BookingService from '@/services/BookingService';
import Room from '@/types/Room';

@Component
export default class CategoryView extends Vue {
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

    findCategoryRoom(categoyFind: string) {
        return BookingService.findCategoryByName(categoyFind)
            .then((response) => {
                this.currentRoom = response.data;
                console.log(response.data);
            })
            .catch((e) => {
                console.log(e)
            })

    }
}
</script>