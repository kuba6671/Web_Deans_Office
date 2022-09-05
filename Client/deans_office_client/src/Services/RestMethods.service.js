import http from "../http-common"
class RestMethodsService {
    addStudent(data) {
        return http.post("/students", data);
    }
}
export default new RestMethodsService();