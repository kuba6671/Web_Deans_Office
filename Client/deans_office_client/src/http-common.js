import axios from "axios";
export default axios.create({
  baseURL: "http://localhost8080",
  headers: {
    "Content-type": "application/json"
  }
});