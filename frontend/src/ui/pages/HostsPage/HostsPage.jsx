import React, {useState} from 'react';
import { Box, CircularProgress, Typography, Grid, Button } from '@mui/material';
import HostCard from '../../../ui/components/Hosts/HostCard/HostCard.jsx';
import AddHostDialog from "../../components/Hosts/AddHostDialog/AddHostDialog.jsx";
import useHosts from "../../../hooks/useHosts.js";
const HostsPage = () => {
    const { hosts, loading,onAdd, error, onDelete, onEdit } = useHosts();
    const [addHostDialogOpen, setAddHostDialogOpen] = useState(false);



    if (loading) return <CircularProgress sx={{ mt: 5 }} />;
    if (error)
        return (
            <Typography color="error" variant="h6" sx={{ mt: 5 }}>
                Error loading stays: {error.message}
            </Typography>
        );

    if (!hosts.length)
        return (
            <Typography variant="h6" sx={{ mt: 5 }}>
                No hosts found.
            </Typography>
        );

    return (
        <>


            <Box sx={{ p: 3 }}>
                <Typography variant="h4" gutterBottom>
                    Available Stays
                </Typography>

                <Grid container spacing={2}>
                    {hosts.map((host) => (
                        <Grid item xs={12} sm={6} md={4} key={host.id}>
                            <HostCard host={host} onDelete={onDelete} onEdit={onEdit} />
                        </Grid>
                    ))}
                </Grid>

                {/* Button to open AddStayDialog */}
                <Button
                    variant="contained"
                    sx={{ mt: 3 }}
                    onClick={() => setAddHostDialogOpen(true)}
                >
                    Add Host
                </Button>

            </Box>

            <AddHostDialog
                open={addHostDialogOpen}
                onClose={() => setAddHostDialogOpen(false)}
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

export default HostsPage;
