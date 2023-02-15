<template>
    <div class="container">
        <thead>
            <tr>
                <td>Name</td>
                <td>Price</td>
            </tr>
        </thead>
        <tbody v-for="feature in features" :key="feature.id">
            <tr>
                <td>{{ feature.name }}</td>
                <td>{{ feature.price }}</td>
            </tr>
        </tbody>
        
    </div>
</template>

<script lang="ts">
    import Feature from '@/types/Feature';
    import { Component,Vue } from 'vue-property-decorator';
    import BookingService from '@/services/BookingService';

    @Component
    export default class FeaturesView extends Vue {
        public features : Feature [] = [];    
        
        retrieveUsers(){
            return BookingService.findAllFeature().then((res) =>{
                this.features = res.data;
                console.log(res.data);
            })
            .catch((e) =>{
                console.log(e)
            })
        }

        mounted(){
            this.retrieveUsers();
        }

    }
</script>

<style scoped>

</style>