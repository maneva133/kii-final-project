import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Layout from './ui/components/layout/Layout/Layout.jsx';
import HomePage from './ui/pages/HomePage/HomePage.jsx';
import StaysPage from './ui/pages/StaysPage/StaysPage.jsx';

import HostsPage from './ui/pages/HostsPage/HostsPage.jsx';
import CountriesPage from './ui/pages/CountriesPage/CountriesPage.jsx';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route index element={<HomePage />} />
                    <Route path="stays" element={<StaysPage />} />
                    <Route path="hosts" element={<HostsPage />} />
                    <Route path="countries" element={<CountriesPage />} />
                </Route>
            </Routes>
        </Router>
    );
};

export default App;
