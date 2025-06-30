import React, { useState } from "react";
import {
    Dialog, DialogTitle, DialogContent, DialogActions,
    TextField, Button, MenuItem, FormControl, InputLabel, Select
} from "@mui/material";

import useHosts from "../../../../hooks/useHosts.js";
import { FormControlLabel, Checkbox } from "@mui/material";

const EditStayDialog = ({ open, onClose, stay, onEdit }) => {
    const [formData, setFormData] = useState({
        name: stay.name,
        category: stay.category,
        hostId: stay.hostId,
        numRooms: stay.numRooms,
        isAvailable: stay.isAvailable ?? false

    });

    const { hosts, loading, error } = useHosts();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: name === "numRooms" ? parseInt(value) : value });
    };

    const handleSubmit = () => {
        onEdit(stay.id, formData);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Edit Stay</DialogTitle>
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
                <FormControlLabel
                    control={
                        <Checkbox
                            checked={formData.isAvailable || false}
                            onChange={(e) =>
                                setFormData({ ...formData, isAvailable: e.target.checked })
                            }
                        />
                    }
                    label="Is Available"
                />

            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleSubmit} variant="contained" color="warning">Edit</Button>
            </DialogActions>
        </Dialog>
    );
};

export default EditStayDialog;
