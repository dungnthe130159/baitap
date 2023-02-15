import http from "@/http-common";

class BookingService{
    findAllCategory(){
        return http.get("api/auth/signin/findallCategory");
    }

    findAllFeature(){
        return http.get("/api/auth/signin/findallFeatures");
    }

    findAllBooking(){
        return http.get("/api/auth/signin/booking");
    }

    findBookingUser(userID : string){
        return http.get(`/api/auth/signin/findBookingUser/${userID}`);
    }

    findAllRooms(){
        return http.get("/api/auth/signin/findAllRooms");
    }

    findCategoryByName(name : string){
        return http.get(`/api/auth/signin/find/category/${name}`);
    }

    findAvailableRooms(){
        return http.get("/api/auth/signin/room/available");
    }

    bookingRoom(data : any){
        return http.post(`/api/auth/signin/room/book/${data}`);
    }

    booking(data : any){
        return http.post("/api/auth/signin/bookingRoom",data); 
    }

    findRoomByID(id : number){
        return http.get(`/api/auth/signin/room/${id}`);
    }
}

export default new BookingService();