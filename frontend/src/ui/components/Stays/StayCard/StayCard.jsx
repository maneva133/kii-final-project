import React, {useState} from 'react';
import {Card, CardContent, Typography, CardActions, Button, Box, ToggleButtonGroup, ToggleButton} from '@mui/material';
import {useNavigate} from "react-router";
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import EditStayDialog from "../EditStayDialog/EditStayDialog.jsx";
import AddStayDialog from "../AddStayDialog/AddStayDialog.jsx";
import DeleteStayDialog from "../DeleteStayDialog/DeleteStayDialog.jsx";

const StayCard = ({ stay, onEdit, onDelete }) => {
    const navigate = useNavigate();
    const [editStayDialogOpen, setEditStayDialogOpen] = useState(false);
    const [deleteStayDialogOpen, setDeleteStayDialogOpen] = useState(false);
    const [isAvailable, setIsAvailable] = useState(stay.isAvailable);

    const handleAvailabilityChange = (newAvailability) => {
        setIsAvailable(newAvailability);
        onEdit(stay.id, { ...stay, isAvailable: newAvailability });
    };

    return (
        <>
        <Card sx={{ maxWidth: 345, margin: '1rem' }}>
            <CardContent>
                <Typography variant="h6" component="div">
                    {stay.name}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    {stay.description || 'No description available.'}
                </Typography>
                {/* Add more stay fields here as needed */}
                <Typography variant="body2" color="text.secondary" sx={{ mt: 1 }}>
                    Availability: {isAvailable ? "Available" : "Unavailable"}
                </Typography>

                <ToggleButtonGroup
                    value={isAvailable ? "yes" : "no"}
                    exclusive
                    onChange={(e, value) => {
                        if (value === "yes") handleAvailabilityChange(true);
                        else if (value === "no") handleAvailabilityChange(false);
                    }}
                    sx={{ mt: 1 }}
                >
                    <ToggleButton value="yes">Available</ToggleButton>
                    <ToggleButton value="no">Unavailable</ToggleButton>
                </ToggleButtonGroup>

            </CardContent>
            <CardActions sx={{justifyContent: "space-between"}}>
                <Button
                    size="small"
                    color="info"
                    startIcon={<InfoIcon/>}
                    onClick={() => navigate(`/stay/${stay.id}`)}
                >
                    Info
                </Button>
                <Box>
                    <Button
                        size="small"
                        color="warning"
                        startIcon={<EditIcon/>}
                        sx={{mr: "0.25rem"}}
                        onClick={() => setEditStayDialogOpen(true)}
                    >
                        Edit
                    </Button>
                    <Button
                        size="small"
                        color="error"
                        startIcon={<DeleteIcon/>}
                        onClick={() => setDeleteStayDialogOpen(true)}
                    >
                        Delete
                    </Button>
                </Box>
            </CardActions>

        </Card>
            <EditStayDialog
                open={editStayDialogOpen}
                onClose={() => setEditStayDialogOpen(false)}
                stay={stay}
                onEdit={onEdit}
            />
            <DeleteStayDialog
                open={deleteStayDialogOpen}
                onClose={() => setDeleteStayDialogOpen(false)}
                stay={stay}
                onDelete={onDelete}
            />

        </>
    );
};

export default StayCard;
