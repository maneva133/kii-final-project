import React, {useState} from 'react';
import {Card, CardContent, Typography, CardActions, Button, Box} from '@mui/material';
import {useNavigate} from "react-router";
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import EditCountryDialog from "../EditCountryDialog/EditCountryDialog.jsx";
import DeleteCountryDialog from "../DeleteCountryDialog/DeleteCountryDialog.jsx";

const CountryCard = ({ country, onEdit, onDelete }) => {
    const navigate = useNavigate();
    const [editCountryDialogOpen, setEditCountryDialogOpen] = useState(false);
    const [deleteCountryDialogOpen, setDeleteCountryDialogOpen] = useState(false);

    return (
        <>
            <Card sx={{ maxWidth: 345, margin: '1rem' }}>
                <CardContent>
                    <Typography variant="h6" component="div">
                        {country.name}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        {country.continent || 'No description available.'}
                    </Typography>
                    {/* Add more stay fields here as needed */}
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
                            onClick={() => setEditCountryDialogOpen(true)}
                        >
                            Edit
                        </Button>
                        <Button
                            size="small"
                            color="error"
                            startIcon={<DeleteIcon/>}
                            onClick={() => setDeleteCountryDialogOpen(true)}
                        >
                            Delete
                        </Button>
                    </Box>
                </CardActions>

            </Card>
            <EditCountryDialog
                open={editCountryDialogOpen}
                onClose={() => setEditCountryDialogOpen(false)}
                country={country}
                onEdit={onEdit}
            />
            <DeleteCountryDialog
                open={deleteCountryDialogOpen}
                onClose={() => setDeleteCountryDialogOpen(false)}
                country={country}
                onDelete={onDelete}
            />

        </>
    );
};

export default CountryCard;
