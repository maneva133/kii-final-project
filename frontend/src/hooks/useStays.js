import {useCallback, useEffect, useState} from "react";
import stayRepository from "../repository/stayRepository.js";

const initialState = {
    "stays": [],
    "loading": true,
};

const useStays = () => {
    const [state, setState] = useState(initialState);

    const fetchStays = useCallback(() => {
        // setState(initialState);
        stayRepository
            .findAll()
            .then((response) => {
                setState({
                    "stays": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);


    const onAdd = useCallback((data) => {
        stayRepository
            .add(data)
            .then(() => {
                console.log("Successfully added a new product.");
                fetchStays();
            })
            .catch((error) => console.log(error));
    }, [fetchStays]);

    const onEdit = useCallback((id, data) => {
        stayRepository
            .edit(id, data)
            .then(() => {
                console.log(`Successfully edited the product with ID ${id}.`);
                fetchStays();
            })
            .catch((error) => console.log(data));
    }, [fetchStays]);

    const onDelete = useCallback((id) => {
        stayRepository
            .delete(id)
            .then(() => {
                console.log(`Successfully deleted the product with ID ${id}.`);
                fetchStays();
            })
            .catch((error) => console.log(error));
    }, [fetchStays]);

    useEffect(() => {
        fetchStays();
    }, [fetchStays]);

    return {...state, onAdd: onAdd, onEdit: onEdit, onDelete: onDelete};

};

export default useStays;
