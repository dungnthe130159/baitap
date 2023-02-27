<template src="./Register.html"></template>
<style lang="scss" scoped src="./Register.scss"></style>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import AuthService from '@/services/AuthService';
import User from '@/types/User';


@Component
export default class Register extends Vue {
    public user: User = {
        id: 0,
        username: "",
        password: "",
        address: "",
        phone: "",
        email: "",
    };

    public pswRepeat: string = "";
    public submitted: boolean = false;
    public message: string = "";

    saveUser() {
        let data = {
            username: this.user.username,
            password: this.user.password,
            phone: this.user.phone,
            address: this.user.address,
            email: this.user.email,
        };

        if (this.pswRepeat == this.user.password) {
            AuthService.register(data)
                .then((response) => {
                    if (response.data.id == null) {
                        alert(response.data.messageError)
                        this.user.id = response.data.id;
                        this.submitted = true;
                        console.log(response.data);
                        this.$router.push("/signin")
                    } else {
                        console.log();
                    }
                })
                .catch(() => {
                    console.log();
                });
        } else {
            alert("Enter wrong password")
            console.log();
        }
    }

    newUser() {
        this.submitted = false;
        this.user = {} as User;
    }
}
</script>