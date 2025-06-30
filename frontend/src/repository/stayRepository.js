import axiosInstance from "../axios/axios.js";

const stayRepository = {
    findAll: async () => {
        return await axiosInstance.get("/stay");
    },
    findById: async (id) => {
        return await axiosInstance.get(`/stay/${id}`);
    },
    add: async (data) => {
        return await axiosInstance.post("/stay/add", data);
    },
    edit: async (id, data) => {
        return await axiosInstance.put(`/stay/edit/${id}`, data);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/stay/delete/${id}`);
    },


};

export default stayRepository;
