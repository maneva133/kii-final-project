import React from "react";
import {
    Dialog, DialogTitle, DialogContent, DialogActions,
    Button, Typography
} from "@mui/material";

const DeleteHostDialog = ({ open, onClose, host, onDelete }) => {
    const handleConfirm = () => {
        onDelete(host.id);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Delete Host</DialogTitle>
            <DialogContent>
                <Typography>
                    Are you sure you want to delete <strong>{host.name}</strong>?
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

export default DeleteHostDialog;
