import React from "react";
import {
    Dialog, DialogTitle, DialogContent, DialogActions,
    Button, Typography
} from "@mui/material";

const DeleteStayDialog = ({ open, onClose, stay, onDelete }) => {
    const handleConfirm = () => {
        onDelete(stay.id);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Delete Stay</DialogTitle>
            <DialogContent>
                <Typography>
                    Are you sure you want to delete <strong>{stay.name}</strong>?
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

export default DeleteStayDialog;
