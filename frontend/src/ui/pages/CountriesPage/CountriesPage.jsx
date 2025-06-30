import React from 'react';
import { Box, CircularProgress, Typography, Grid, Button } from '@mui/material';
import useCountries from '../../../hooks/useCountries.js';
import CountryCard from '../../../ui/components/Countries/CountryCard/CountryCard.jsx';

const CountriesPage = () => {
    const { countries, loading, error, onDelete, onEdit } = useCountries();

    if (loading) return <CircularProgress sx={{ mt: 5 }} />;
    if (error)
        return (
            <Typography color="error" variant="h6" sx={{ mt: 5 }}>
                Error loading stays: {error.message}
            </Typography>
        );

    if (!countries.length)
        return (
            <Typography variant="h6" sx={{ mt: 5 }}>
                No countries found.
            </Typography>
        );

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" gutterBottom>
                Available Countries
            </Typography>
            <Grid container spacing={2}>
                {countries.map((country) => (
                    <Grid item xs={12} sm={6} md={4} key={country.id}>
                        <CountryCard country={country} onDelete={onDelete} onEdit={onEdit} />
                    </Grid>
                ))}
            </Grid>
            {/* Add button for adding new stays if you want */}
            {/* <Button variant="contained" sx={{ mt: 3 }}>Add Stay</Button> */}
        </Box>
    );
};

export default CountriesPage;
