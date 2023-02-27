<template src="./UserList.html"></template>
<style lang="scss" scoped src="./UserList.scss"></style>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import UserDataService from '@/services/UserDataService';
import User from '@/types/User'

@Component
export default class UserList extends Vue {
    public users: User[] = [];
    public nameFind: string = "";
    public currentUser = {} as User;
    public idCurrent: number = 0;


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