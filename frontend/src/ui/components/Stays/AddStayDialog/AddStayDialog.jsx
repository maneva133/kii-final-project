import React, { useState } from "react";
import {
    Dialog, DialogTitle, DialogContent, DialogActions,
    TextField, Button, MenuItem, FormControl, InputLabel, Select
} from "@mui/material";
import useHosts from "../../../../hooks/useHosts.js";

const AddStayDialog = ({ open, onClose, onAdd }) => {
    const [formData, setFormData] = useState({
        name: "",
        category: "HOTEL",
        hostId: "",
        numRooms: 1
    });

    const { hosts, loading, error } = useHosts();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: name === "numRooms" ? parseInt(value) : value });
    };

    const handleSubmit = () => {
        onAdd(formData);
        onClose();
        setFormData({ name: "", category: "HOTEL", hostId: "", numRooms: 1 });
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Add Stay</DialogTitle>
            <DialogContent>
                <TextField
                    fullWidth
                    margin="dense"
                    label="Name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                />
                <FormControl fullWidth margin="dense">
                    <InputLabel>Category</InputLabel>
                    <Select
                        name="category"
                        value={formData.category}
                        onChange={handleChange}
                    >
                        <MenuItem value="HOTEL">HOTEL</MenuItem>
                        <MenuItem value="ROOM">ROOM</MenuItem>
                    </Select>
                </FormControl>
                <FormControl fullWidth margin="dense">
                    <InputLabel>Host</InputLabel>
                    <Select
                        name="hostId"
                        value={formData.hostId}
                        onChange={handleChange}
                    >
                        {hosts.map((host) => (
                            <MenuItem key={host.id} value={host.id}>
                                {host.name}
                            </MenuItem>
                        ))}
                    </Select>

                </FormControl>
                <TextField
                    fullWidth
                    margin="dense"
                    label="Number of Rooms"
                    name="numRooms"
                    type="number"
                    inputProps={{ min: 1 }}
                    value={formData.numRooms}
                    onChange={handleChange}
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleSubmit} variant="contained">Add</Button>
            </DialogActions>
        </Dialog>
    );
};

export default AddStayDialog;
