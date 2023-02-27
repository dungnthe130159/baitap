<template src="./AddUser.html"></template>
<style lang="scss" scoped src="./AddUser.scss"></style>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import UserDataService from '@/services/UserDataService';
import User from '@/types/User';

@Component
export default class AddUser extends Vue {
    public user: User = {
        id: 0,
        username: "",
        password: "",
        address: "",
        phone: "",
        email: "",
    };

    public submitted: boolean = false;

    saveUser() {
        let data = {
            username: this.user.username,
            password: this.user.password,
            phone: this.user.phone,
            address: this.user.address,
            email: this.user.email,
        };

        UserDataService.create(data)
            .then((response) => {
                this.user.id = response.data.id;
                console.log(response.data);
                this.submitted = true;
            })
            .catch(() => {
                console.log();
            });
    }

    newUser() {
        this.submitted = false;
        this.user = {} as User;
    }
}
</script>