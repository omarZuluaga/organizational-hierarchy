import axios from "axios";

const URL = `http://localhost:8080/`;

const axi = axios.create({
  baseURL: URL,
});

// Endpoint List

const API = {
  company: {
    GET: {
      getAll() {
        return axi.get(`company/get`);
      },
    },
    POST: (body) => {
      return axi.post(`company/save`, body);
    },
    PUT: (body, id) => {
      return axi.put(`company/update/${id}`, { body });
    },
    DELETE: (id) => {
      return axi.delete(`company/delete/${id}`);
    },
  },
  department: {
    GET: {
      getByCompany(id) {
        return axi.get(`department/getDepartments/${id}`);
      },
    },
    POST: (body) => {
      return axi.post(`department/save`, body);
    },
    PUT: (body, id) => {
      return axi.put(`department/update/${id}`, { body });
    },
    DELETE: (id) => {
      return axi.delete(`department/delete/${id}`);
    },
  },
  subDepartment: {
    GET: {
      getByDepartment(id) {
        return axi.get(`subDepartment/getSubDepartment/${id}`);
      },
    },
    POST: (body) => {
      return axi.post(`subDepartment/save`, body);
    },
    PUT: (body, id) => {
      return axi.put(`subDepartment/update/${id}`, { body });
    },
    DELETE: (id) => {
      return axi.delete(`subDepartment/delete/${id}`);
    },
  },
};

export default API;
