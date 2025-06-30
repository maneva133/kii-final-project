import React from "react";
import {
    Dialog, DialogTitle, DialogContent, DialogActions,
    Button, Typography
} from "@mui/material";

const DeleteCountryDialog = ({ open, onClose, country, onDelete }) => {
    const handleConfirm = () => {
        onDelete(country.id);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Delete Country</DialogTitle>
            <DialogContent>
                <Typography>
                    Are you sure you want to delete <strong>{country.name}</strong>?
                </Typography>
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleConfirm} color="error" variant="contained">
                    Delete
                </Button>
            </DialogActions>
        </Dialog>
    );
};

export default DeleteCountryDialog;
