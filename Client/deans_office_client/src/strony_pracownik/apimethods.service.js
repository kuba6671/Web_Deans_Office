import http from "../http-common";

class Apimethods{
    addStudent(data) {
        return http.post("/students", data);
    }
}

export default new Apimethods();