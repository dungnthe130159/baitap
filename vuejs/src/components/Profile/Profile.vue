<template src="./Profile.html"></template>
<style lang="scss" scoped src="./Profile.scss"></style>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Profile extends Vue {

    public id: number = 0;
    public username: string = ""
    public address: string = ""
    public email: string = ""
    public phone: string = ""


    getData() {
        var i: any = localStorage.getItem("id")
        this.id = i
        console.log(this.id)
        var u: any = localStorage.getItem("username")
        this.username = u
        var a: any = localStorage.getItem("address")
        this.address = a
        var e: any = localStorage.getItem("email")
        this.email = e
        var p: any = localStorage.getItem("phone")
        this.phone = p
    }
    mounted() {
        this.getData()
    }
}


</script>