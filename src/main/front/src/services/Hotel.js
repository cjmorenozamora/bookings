import axios from "axios";
const API = "http://localhost:8080/hotels";

export default {
  get() {
    return axios.get(API);
  }
};