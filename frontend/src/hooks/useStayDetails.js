import {useEffect, useState} from "react";
import hostRepository from "../repository/hostRepository.js";
import stayRepository from "../repository/stayRepository.js";

const useProductDetails = (id) => {
    const [state, setState] = useState({
        "stay": null,
        "host": null,
    });

    useEffect(() => {
        stayRepository
            .findById(id)
            .then((response) => {
                setState(prevState => ({...prevState, "stay": response.data}));
                hostRepository
                    .findById(response.data.hostId)
                    .then((response) => {
                        setState(prevState => ({...prevState, "host": response.data}));
                    })
                    .catch((error) => console.log(error));

            })
            .catch((error) => console.log(error));
    }, [id]);

    return state;
};

export default useProductDetails;
