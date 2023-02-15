,<template>
    <div class="submit-form">
        <div v-if="!submitted">
            <div class="form-group">
                <label for="username">Username</label>
                <input
                    class="form-control"
                    id="username"
                    required
                    v-model="user.username" 
                    name="username"
                />
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input
                    type="password"
                    class="form-control"
                    id="password"
                    required
                    v-model="user.password"
                    name="password"
                />
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input
                    class="form-control"
                    id="email"
                    required
                    v-model="user.email"
                    name="email"
                />
            </div>

            <div class="form-group">
                <label for="number">Phone Number</label>
                <input
                    class="form-control"
                    id="number"
                    required
                    v-model="user.phone"
                    name="number"
                />
            </div>

            <div class="form-group">
                <label for="address">Address</label>
                <input
                    class="form-control"
                    id="address"
                    required
                    v-model="user.address"
                    name="address"
                />
            </div>

            <!-- <div class="form-group">
                <label for="role">Role</label>
                <input
                    class="form-control"
                    id="role"
                    required
                    v-model="user.role"
                    name="role"
                />
            </div> -->

            <button v-on:click="saveUser" class="btn btn-success">Submit</button>
        </div>

        <div v-else>
            <h4>You submitted successfully</h4>
            <button class="btn btn-success" @click="newUser">Add</button>
            <a class="btn btn-success" href="/">Home</a>
        </div>
    </div>
</template>

<script lang="ts">
    import { Component,Vue } from 'vue-property-decorator';
    import UserDataService from '@/services/UserDataService';
    import User from '@/types/User';

    @Component
    export default class AddUser extends Vue{
        public user : User = {
            id: 0,
            username : "",
            password:"",
            address : "",
            phone : "",
            email : "",
        };

        public submitted:boolean =false;

        saveUser(){
            let data = {
                username : this.user.username,
                password : this.user.password,
                phone : this.user.phone,
                address : this.user.address,
                email : this.user.email,
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

        newUser(){
            this.submitted =false;
            this.user = {} as User;
        }
    }
</script>

<style>
.submit-form{
    max-width: 300px;
    margin: auto;
}
</style>