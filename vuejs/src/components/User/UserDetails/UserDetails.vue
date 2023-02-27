<template src="./UserDetails.html"></template>
<style lang="scss" scoped src="./UserDetails.scss"></style>


<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import UserDataService from '@/services/UserDataService';
import User from '@/types/User'

@Component
export default class UserDetails extends Vue {
    public currentUser = {} as User;
    //eslint-disable-next-line @typescript-eslint/ban-types
    public message: string = "";

    getUser(id: any) {
        UserDataService.get(id)
            .then((response: any) => {
                this.currentUser = response.data;
                console.log(response.data);
            })
            .catch(() => {
                console.log();
            });
    }

    updateUser() {
        UserDataService.update(this.currentUser.id, this.currentUser)
            .then((response: any) => {
                console.log(response.data);
                this.message = "The user was updated successfully!";
            })
            .catch(() => {
                console.log();
            });
    }

    deleteUser() {
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

    mounted() {
        this.getUser(this.$route.params.id);
    }
}
</script>