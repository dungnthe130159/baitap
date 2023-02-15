<template>
    <div v-if="currentUser.id" class="container">
        <h3>Update Form</h3>
            <div style="padding-top: 20px;" class="d-flex flex-wrap">
                <label for="first">ID User</label>
                <div style="text-align: left;" id="first">{{ currentUser.id }}</div>
            </div>

            <div style="padding-top: 30px;" class="d-flex flex-wrap">
                <label for="first">User Name</label>
                <input
                    type="text"
                    id="username"
                    v-model="currentUser.username"
                />
            </div>

            <div style="padding-top: 30px;" class="d-flex flex-wrap">
                <label for="phone">Phone</label>
                <input
                    type="text"
                    id="phone"
                    v-model="currentUser.phone"
                />
            </div>

            <div style="padding-top: 30px;" class="d-flex flex-wrap">
                <label for="last">Address</label>
                <input
                    type="text"
                    id="address"
                    v-model="currentUser.address"
                />
            </div>

            <div style="padding-top: 30px;" class="d-flex flex-wrap">
                <label for="email">Email</label>
                <input
                    type="text"
                    id="email"
                    v-model="currentUser.email"
                />
            </div>
        <button class="delete" @click="deleteUser">
            Delete
        </button>

        <button type="submit" class="update" @click="updateUser">
            Update
        </button>
        <p style="margin-top: 5px;">{{ message }}</p>
    </div>
</template>

<script lang="ts">
    import {Component,Vue} from 'vue-property-decorator';
    import UserDataService from '@/services/UserDataService';
    import User from '@/types/User'

    @Component
    export default class UserDetails extends Vue{
        public currentUser = {} as User;
        //eslint-disable-next-line @typescript-eslint/ban-types
        public message : string = "";

        getUser(id:any){
            UserDataService.get(id)
            .then((response:any) => {
                this.currentUser = response.data;
                console.log(response.data);
            })
            .catch(() => {
                console.log();
            });
        }

        updateUser(){
            UserDataService.update(this.currentUser.id,this.currentUser)
            .then((response:any) => {
                console.log(response.data);
                this.message = "The user was updated successfully!";
            })
            .catch(() =>{
                console.log();
            });
        }

        deleteUser(){
            UserDataService.delete(this.currentUser.id)
            // .then((response) => {
            //     console.log(response.data);
            //     this.$router.push({name : "users"});
            // })
            // .catch((e) => {
            //     console.log(e);
            // });
            this.$router.push("/users")
        }

        mounted(){
            this.getUser(this.$route.params.id);
        }
    }
</script>

<style>
.delete{
    width: 150px;
    height: 40px;
    border-radius: 20px;
    margin-right: 10px;
    margin-top: 20px;
}
.update{
    width: 150px;
    height: 40px;
    border-radius: 20px;
    margin-top: 20px;
}
.container{
    margin-top: 30px;
    padding-left: 100px;
}
input{
    border: 0;
    outline: none;
}
label{
    width: 15%;
    font-weight: bolder;
    text-align: right;
    padding-right: 30px ;
    margin-right: 30px ;
}
</style>