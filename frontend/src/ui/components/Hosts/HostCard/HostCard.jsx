import React, {useState} from 'react';
import {Card, CardContent, Typography, CardActions, Button, Box} from '@mui/material';
import {useNavigate} from "react-router";
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import EditHostDialog from "../EditHostDialog/EditHostDialog.jsx";
// import AddStayDialog from "../AddHostDialog/AddHostDialog.jsx";
import DeleteHostDialog from "../DeleteHostDialog/DeleteHostDialog.jsx";

const HostCard = ({ host, onEdit, onDelete }) => {
    const navigate = useNavigate();
    const [editHostDialogOpen, setEditHostDialogOpen] = useState(false);
    const [deleteHostDialogOpen, setDeleteHostDialogOpen] = useState(false);

    return (
        <>
            <Card sx={{ maxWidth: 345, margin: '1rem' }}>
                <CardContent>
                    <Typography variant="h6" component="div">
                        {host.name}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        {host.surname || 'No description available.'}
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
                            onClick={() => setEditHostDialogOpen(true)}
                        >
                            Edit
                        </Button>
                        <Button
                            size="small"
                            color="error"
                            startIcon={<DeleteIcon/>}
                            onClick={() => setDeleteHostDialogOpen(true)}
                        >
                            Delete
                        </Button>
                    </Box>
                </CardActions>

            </Card>
            <EditHostDialog
                open={editHostDialogOpen}
                onClose={() => setEditHostDialogOpen(false)}
                host={host}
                onEdit={onEdit}
            />
            <DeleteHostDialog
                open={deleteHostDialogOpen}
                onClose={() => setDeleteHostDialogOpen(false)}
                host={host}
                onDelete={onDelete}
            />

        </>
    );
};

export default HostCard;
