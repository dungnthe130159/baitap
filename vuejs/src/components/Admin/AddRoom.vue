<template>
    <div class="container-all">
        <h3>Add Room</h3>
        <div class="container-ar">
            <div class="wrap-wrap">
                <div class="d-flex flex-nowrap wrap-ar">
                    <p>Select Room Type</p>
                    <select v-model="nameFind">
                        <option value="1">KING ROOM</option>
                        <option value="2">LUXURY ROOM</option>
                        <option value="3">NORMAL ROOM</option>
                    </select>
                </div>
                <div class="d-flex flex-nowrap wrap-ar">
                    <p>Room Number</p>
                    <input type="text" placeholder="Enter Room Number" v-model="room.number" required>
                </div>
                <div class="d-flex flex-nowrap wrap-ar">
                    <p>Price</p>
                    <input type="text" placeholder="Enter Room Price" v-model="room.price" required>
                </div>
                <div class="d-flex flex-nowrap wrap-ar">
                    <p>Avaiable</p>
                    <div style="width: 550px;" class="d-flex flex-nowrap">
                        <input style="margin:13px 10px 0px 0px; width: 20px; height: 20px;" type="checkbox" id="checkbox" v-model="checked" />
                        <p style="margin: 5px 0px 0px 5px;  font-size: x-large; color: seagreen;" v-if="checked===true">Aviable</p>
                        <p style="margin: 5px 0px 0px 5px;  font-size: x-large; color: red;" v-else>Unaviable</p>
                    </div>                
                </div>
                <button v-on:click="saveRoom" class="addRoom">Add Room</button>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Model, Vue } from 'vue-property-decorator';
import AdminService from '@/services/AdminService';
import Room from '@/types/Room';
import Category from '@/types/Category';

@Component
export default class AddRoom extends Vue {
    public nameFind = "1";
    public checked = true;

    public room: Room = {
        id: 0,
        category: {} as Category,
        number: "",
        price: 0,
        available: 0,
    };

    saveRoom(){
        if(this.checked===true){
            var category = {
                id : this.nameFind
            }
            let data = {
                // category : categoryModel,
                category,
                number : this.room.number,
                price : this.room.price,
                available : "1",
            }  

            AdminService.createRomm(data)
            .then((res) => {
                console.log(res);
                this.$router.push("/roomManagement")
            }).catch(() => {
                console.log();
            });
        }else{
            let data = {
            category : this.nameFind,
            number : this.room.number,
            price : this.room.price,
            available : "0",
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

<style scoped>
.addRoom{
    width: 140px;
    height: 45px;
    background-color: rgb(37, 141, 84);
    color: white;
    border-radius: 3px;
    border: none;
}
.container-all{
    width: 100%;
    height: 500px;
}
.wrap-wrap {
    width: 94%;
    height: 320px;
    background-color: white;
    margin:30px 0px 0px 46px;
    padding:20px 0px 20px 0px ;
}

h3 {
    text-align: left;
    padding: 10px 0px 0px 30px;
    font-weight: bolder;
}

.container-ar {
    width: 100%;
    height: 80%;
    background-color: beige;
    padding: 10px 0px 10px 0px;
    margin-bottom: 250px;

}

.wrap-ar {
    width: 95%;
    margin: 0px 0px 0px 25px;
    padding-bottom: 10px;

}

p {
    width: 30%;
    text-align: left;
    margin: 15px 0px 0px 20px;
    font-weight: bold;
}

select {
    width: 40%;
    border-radius: 5px;
    margin-top: 10px;
    padding: 12px;
}
input{
    width: 40%;
    border-radius: 5px;
    border-color: none;
}
</style>
