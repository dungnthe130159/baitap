<template>
    <div>
        <div >
           <h3 style="margin-top: 10px; font-weight: bold;"> All Type Room </h3> 
        </div>
        <div class="container d-flex flex-nowrap">
            <div style="padding: 5px; margin-left: 35px; margin-top: 30px;" 
            v-for="category in categories" :key="category.id"  @click="findCategoryRoom(category.categoryName)">
                <div v-if="category.id == 1">
                        <img @k="findCategoryRoom(category.categoryName)"
                            src="https://images.unsplash.com/photo-1544006659-f0b21884ce1d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fGxhcHRvcHxlbnwwfHwwfHw%3D&w=1000&q=80"
                            style="width: 380px; height: 253px;" /><br>
                            <p style="font-weight: bold; margin-top: 10px;">{{ category.categoryName }}</p>
                </div>
                <div v-if="category.id == 2">
                        <img @k="findCategoryRoom(category.categoryName)"
                            src="https://images.unsplash.com/photo-1499914485622-a88fac536970?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
                            style="width: 380px; height: 253px" /><br>
                            <p style="font-weight: bold; margin-top: 10px;">{{ category.categoryName }}</p>
                </div>
                <div v-if="category.id == 3">
                        <img @k="findCategoryRoom(category.categoryName)"
                            src="https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1172&q=80"
                            style="width: 380px; height: 253px" /><br>
                        <p style="font-weight: bold; margin-top: 10px;">{{ category.categoryName }}</p>
                </div>
            </div>      
        </div>
        <div class="detail d-flex flex-wrap">
            <div class="detail-in" v-for="currents in currentRoom" :key="currents.id">
                <div v-if="currents.category.categoryName==='KINGROOM'">
                    <img class="img-table"
                        src="https://images.unsplash.com/photo-1544006659-f0b21884ce1d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fGxhcHRvcHxlbnwwfHwwfHw%3D&w=1000&q=80"
                            style="width: 280px; height: 183px" >
                    <br>Room Type :{{ currents.category.categoryName }}<br>
                    Room Number :{{ currents.number }}<br>
                    Room Price :{{ currents.price }}<br>
                    <div v-if="currents.available===1">
                        Status : Avaiable
                    </div>
                    <div v-else>
                        Status : Unavaiable
                    </div>
                </div>
                <div v-if="currents.category.categoryName==='LUXURYROOM'">
                    <img class="img-table"
                        src="https://images.unsplash.com/photo-1499914485622-a88fac536970?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
                            style="width: 280px; height: 183px" >
                    <br>Room Type :{{ currents.category.categoryName }}<br>
                    Room Number :{{ currents.number }}<br>
                    Room Price :{{ currents.price }}<br>
                    <div v-if="currents.available===1">
                        Status : Avaiable
                    </div>
                    <div v-else>
                        Status : Unavaiable
                    </div>
                </div>
                <div v-if="currents.category.categoryName==='NORMALROOM'">
                    <img class="img-table"
                        src="https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1172&q=80"
                            style="width: 280px; height: 183px" >
                    <br>Room Type :{{ currents.category.categoryName }}<br>
                    Room Number :{{ currents.number }}<br>
                    Room Price :{{ currents.price }}<br>
                    <div v-if="currents.available===1">
                        Status : Avaiable
                    </div>
                    <div v-else>
                        Status : Unavaiable
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</template>

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

<style scoped>
img {
    width: 200px;
}
.detail-in{
    margin-top:30px;
    width: 370px;
    height: 250px;
}
.detail{
    width: 98%;
    height: 320px;
    margin-left: 20px;
    margin-top:40px;
}

.container {
    margin-top: 10px;
    margin-left: 100px;
    width: 100%;
    height: 100%;
    background-color: antiquewhite;
}
</style>