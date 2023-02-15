<template>
    <div class="container">
        <div class="search d-flex flex-wrap">
            <input type="text" class="inputS" placeholder="Search by name" v-model="nameFind" />
            <button style="margin-left: 35px; border-radius: 5px; width: 110px;" type="button" v-on:click="searchName">
                Search
            </button>
        </div>        
        <div class="view d-flex flex-wrap">
            <div class="view-list">
                <h4 style="font-weight: bolder;">Users List</h4><br>
                <table>
                    <!-- <li class="list-group-item" :class="{ active: index == currentIndex }"
                        v-for="(user, index) in users" :key="index" @click="setActiveUser(user, index)">
                        {{ user.username }}
                    </li> -->
                    <tr style="font-weight: bolder;">
                        <td>Id</td>
                        <td>Username</td>
                        <td>Address</td>
                        <td>Email</td>
                        <td>Phone</td>
                    </tr>
                    <tr v-for="user in users" :key="user.id"
                            v-on:click="setActiveUser(user,user.id)">
                        <td>{{ user.id }}</td>
                        <td>{{ user.username }}</td>
                        <td>{{ user.address }}</td>
                        <td>{{ user.email }}</td>
                        <td>{{ user.phone }}</td>
                    </tr>
                </table>
            </div>

            <div class="view-detail">
                <div style="width: 250px; margin-left: 30px;" v-if="currentUser.id">
                    <h4 style="font-weight: bolder;">User Detial</h4><br>
                    <div>
                        <label>User Name : </label>
                        {{ currentUser.username }}
                    </div>
                    <div>
                        <label>Email : </label>
                        {{ currentUser.email }}
                    </div>
                    <div>
                        <label>Phone Number : </label>
                        {{ currentUser.phone }}
                    </div>
                    <div>
                        <label>Address : </label>
                        {{ currentUser.address }}
                    </div>
                    <a class="m-1 btn btn-sm btn-warning" :href="'/users/' + currentUser.id">
                        Edit
                    </a>
                </div>
                <div v-else>
                    <br />
                    <p>Please click details Users...</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import UserDataService from '@/services/UserDataService';
import User from '@/types/User'

@Component
export default class UserList extends Vue {
    public users: User[] = [];
    public nameFind: string = "";
    public currentUser = {} as User;
    public idCurrent : number = 0;

    
    retrieveUsers() {
        return UserDataService.getAll().then((res) => {
            this.users = res.data;
            console.log(res.data)
        })
        .catch((e) => {
            console.log(e)
        })
    }

    // removeAllUser() {
    //     UserDataService.deleteAll()
    //         .then((response) => {
    //             console.log(response);
    //             this.refreshList;
    //         })
    //         .catch((e) => {
    //             console.log(e)
    //         })
    // }

    setActiveUser(user: User, index: number) {
        this.currentUser = user;
        this.currentUser.id = index
    }

    // refreshList() {
    //     this.retrieveUsers();
    //     this.currentUser = {} as User;
    // }

    
    searchName() {
        UserDataService.findByKeyName(this.nameFind)
            .then(response => {
                this.users = response.data;
                console.log(response.data);
            })
            .catch((e) => {
                console.log((e))
            })
    }

    mounted() {
        this.retrieveUsers();
    }
}
</script>

<style scoped>
.container {
    height: 100%;
    margin-left: 100px;
    margin-top: 30px;
    background-color: rgb(222, 206, 206);
}

.search {
    width: 95%;
    padding: 30px 0px 0px 50px;
}

.inputS {
    height: 40px;
    width: 80%;
    /* margin: 10px; */
    border-radius: 5px;
}
.view{
    margin-top: 30px;
}
.view-list{
    width: 65%;
    margin-left: 30px;
}
.view-detail{
    width: 20%;
    margin-left: 30px;
}
table{
    width: 750px;
}
.detail{
    width: 400px;
    height: 50px;
}
</style>
