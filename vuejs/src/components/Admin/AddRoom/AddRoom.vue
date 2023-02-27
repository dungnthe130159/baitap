<template src="./AddRoom.html"></template>
<style lang="scss" scoped src="./AddRoom.scss"></style>

<script lang="ts">
import { Component, Model, Vue } from 'vue-property-decorator';
import AdminService from '@/services/AdminService';
import Room from '@/types/Room';
import Category from '@/types/Category';

@Component
export default class AddRoom extends Vue {
    public nameFind: String = "1";
    public checked: Boolean = true;

    public room: Room = {
        id: 0,
        category: {} as Category,
        number: "",
        price: 0,
        available: 0,
    };

    saveRoom() {
        if (this.checked === true) {
            let category = {
                id: this.nameFind
            }
            let data = {
                // category : categoryModel,
                category,
                number: this.room.number,
                price: this.room.price,
                available: "1",
            }

            AdminService.createRomm(data)
                .then((res) => {
                    console.log(res);
                    this.$router.push("/roomManagement")
                }).catch(() => {
                    console.log();
                });
        } else {
            let data = {
                category: this.nameFind,
                number: this.room.number,
                price: this.room.price,
                available: "0",
            }

            AdminService.createRomm(data)
                .then((res) => {
                    console.log(res);
                    this.$router.push("/addRoom")
                }).catch(() => {
                    console.log();
                });
        }
    }
}
</script>
