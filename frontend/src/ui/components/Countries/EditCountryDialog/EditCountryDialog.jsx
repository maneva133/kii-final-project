import React, {useEffect, useState} from "react";
import {
    Dialog, DialogTitle, DialogContent, DialogActions,
    TextField, Button, MenuItem, FormControl, InputLabel, Select
} from "@mui/material";
import useCountries from "../../../../hooks/useCountries.js";

const EditCountryDialog = ({ open, onClose, country, onEdit }) => {
    const [formData, setFormData] = useState({
        name: country.name,
        continent: country.continent,
    });


    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    useEffect(() => {
        if (country) {
            setFormData({
                name: country.name || "",
                continent: country.continent || ""
            });
        }
    }, [country]);
    const handleSubmit = () => {
        onEdit(country.id, formData);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Edit Country</DialogTitle>
            <DialogContent>
                <TextField
                    fullWidth
                    margin="dense"
                    label="Name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                />
                <TextField
                    fullWidth
                    margin="dense"
                    label="Continent"
                    name="continent"
                    value={formData.continent}
                    onChange={handleChange}
                />


            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleSubmit} variant="contained" color="warning">Edit</Button>
            </DialogActions>
        </Dialog>
    );
};

export default EditCountryDialog;
