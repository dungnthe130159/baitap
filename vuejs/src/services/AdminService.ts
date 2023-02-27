import http from "@/http-common";

class AdminService {
    createRomm(data: any) {
        return http.post("/api/auth/signin/addRoom", data);
    }
}

export default new AdminService();