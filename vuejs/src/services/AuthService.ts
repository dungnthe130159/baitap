import http from "@/http-common";

class AuthService {
    login(data : any){
        return http.post("/api/auth/signin",data);       
    }

    // logout(){
    //     localStorage.removeItem('user');
    // }

    register(data : any){
        return http.post("/api/auth/signup",data);
    }
}

export default new AuthService();