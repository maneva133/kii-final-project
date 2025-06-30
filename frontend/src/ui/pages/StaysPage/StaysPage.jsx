import React, {useState} from 'react';
import { Box, CircularProgress, Typography, Grid, Button } from '@mui/material';
import useStays from '../../../hooks/useStays.js'; // Adjust path as needed
import StayCard from '../../../ui/components/Stays/StayCard/StayCard.jsx';
import AddStayDialog from "../../components/Stays/AddStayDialog/AddStayDialog.jsx";
const StayPage = () => {
    const { stays, loading,onAdd, error, onDelete, onEdit } = useStays();
    const [addStayDialogOpen, setAddStayDialogOpen] = useState(false);



    if (loading) return <CircularProgress sx={{ mt: 5 }} />;
    if (error)
        return (
            <Typography color="error" variant="h6" sx={{ mt: 5 }}>
                Error loading stays: {error.message}
            </Typography>
        );

    if (!stays.length)
        return (
            <Typography variant="h6" sx={{ mt: 5 }}>
                No stays found.
            </Typography>
        );

    return (
        <>


            <Box sx={{ p: 3 }}>
                <Typography variant="h4" gutterBottom>
                    Available Stays
                </Typography>

                <Grid container spacing={2}>
                    {stays.map((stay) => (
                        <Grid item xs={12} sm={6} md={4} key={stay.id}>
                            <StayCard stay={stay} onDelete={onDelete} onEdit={onEdit} />
                        </Grid>
                    ))}
                </Grid>

                {/* Button to open AddStayDialog */}
                <Button
                    variant="contained"
                    sx={{ mt: 3 }}
                    onClick={() => setAddStayDialogOpen(true)}
                >
                    Add Stay
                </Button>

            </Box>

            <AddStayDialog
                open={addStayDialogOpen}
                onClose={() => setAddStayDialogOpen(false)}
                onAdd={onAdd}
            />

            {/*<AddStayDialog*/}
    {/*    open={addStayDialogOpen}*/}
    {/*    onClose={() => setAddStayDialogOpen(false)}*/}
    {/*    onAdd={onAdd}*/}
    {/*/>*/}
        </>


    );
};

export default StayPage;
