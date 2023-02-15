import http from "@/http-common";

class UserDataService{
    getAll(){
        return http.get("/api/auth/signin/users");
    }

    get(id: string) {
        return http.get(`/api/auth/signin/users/${id}`);
    }
    
    create(data: any) {
        return http.post("/api/auth/signin/users", data);
    }
    
    update(id: any, data: any) {
        return http.put(`/api/auth/signin/users/${id}`, data);
    }
    
    delete(id: any) {
        return http.delete(`/api/auth/signin/users/${id}`);
    }
    //not ok
    deleteAll() {
        return http.delete(`/api/auth/signin/users`);
    }

    findByKeyName(username: string){
        return http.get(`/api/auth/signin/users?username=${username}`);
    }

    findByUserName(username : string){
        return http.get(`/api/auth/signin/users/detail/${username}`);
    }
}

export default new UserDataService();