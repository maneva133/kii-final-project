import {useCallback, useEffect, useState} from "react";
import countriesRepository from "../repository/countryRepository.js";

const initialState = {
    "countries": [],
    "loading": true,
};

const useCountries = () => {
    const [state, setState] = useState(initialState);

    const fetchCountries = useCallback(() => {
        // setState(initialState);
        countriesRepository
            .findAll()
            .then((response) => {
                setState({
                    "countries": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);


    const onAdd = useCallback((data) => {
        countriesRepository
            .add(data)
            .then(() => {
                console.log("Successfully added a new product.");
                fetchCountries();
            })
            .catch((error) => console.log(error));
    }, [fetchCountries]);

    const onEdit = useCallback((id, data) => {
        countriesRepository
            .edit(id, data)
            .then(() => {
                console.log(`Successfully edited the product with ID ${id}.`);
                fetchCountries();
            })
            .catch((error) => console.log(error));
    }, [fetchCountries]);

    const onDelete = useCallback((id) => {
        countriesRepository
            .delete(id)
            .then(() => {
                console.log(`Successfully deleted the product with ID ${id}.`);
                fetchCountries();
            })
            .catch((error) => console.log(error));
    }, [fetchCountries]);

    useEffect(() => {
        fetchCountries();
    }, [fetchCountries]);

    return {...state, onAdd: onAdd, onEdit: onEdit, onDelete: onDelete};

};

export default useCountries;
