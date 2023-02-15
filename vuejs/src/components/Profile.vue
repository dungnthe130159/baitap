<template>
    <div>
        <div style="margin-top: 30px;">
            <h3>Your Profile</h3>
        </div>
        <div class="table">
            <div style="padding-top: 20px;" class="d-flex flex-wrap">
                <label>Username </label>
                <div>{{ username }}</div>
            </div><br>
            <div style="padding-top: 20px;" class="d-flex flex-wrap">
                <label>Address </label><br>
                <div class="div">{{ address }}</div>
            </div><br>
            <div style="padding-top: 20px;" class="d-flex flex-wrap">
                <label>Email </label><br>
                <div class="div">{{ email }}</div>
            </div><br>
            <div style="padding-top: 20px;" class="d-flex flex-wrap">
                <label>Phone </label><br>
                    <div class="div">{{ phone }}</div>
            </div><br>      
        </div>
        <div>
            <button class="update"><a style="all: unset;" :href="'/users/' + id">
            <img src="https://png.pngtree.com/png-clipart/20191120/original/pngtree-pencil-icon-symbol-isolated-png-image_5045524.jpg"/>
                Update
            </a>    
            </button>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Profile extends Vue {
    
    public id : number = 0;
    public username: string = ""
    public address: string = ""
    public email: string = ""
    public phone: string = ""
    

    getData() {
        var i : any = localStorage.getItem("id")
        this.id = i
        console.log(this.id)
        var u : any = localStorage.getItem("username")
        this.username = u
        var a : any = localStorage.getItem("address")
        this.address = a
        var e : any = localStorage.getItem("email")
        this.email = e
        var p : any = localStorage.getItem("phone")
        this.phone  = p
    }
    mounted() {
        this.getData()
    }
}


</script>

<style scoped>
.table{
    /* margin-top: 30px; */
    margin-left: 230px;
    width: 70%;
    height: 70%;
}
label{
    width: 15%;
    font-weight: bolder;
}
.update{
    width: 300px;
    height: 40px;
    border-radius: 20px;
}
img{
    width: 20px;
    height: 20px;
    background-color:white ;
}
</style>
