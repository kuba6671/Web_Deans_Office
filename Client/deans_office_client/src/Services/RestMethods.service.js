import http from "../http-common"
class RestMethodsService {
    addStudent(data) {
        console.log(data)
        return http.post("/students", data);
    }
}
export default new RestMethodsService();