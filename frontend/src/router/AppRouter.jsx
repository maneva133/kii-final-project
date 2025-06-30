import { Routes, Route } from "react-router-dom";
import Layout from "../ui/components/layout/Layout/Layout.jsx";
import Home from "../ui/pages/HomePage/HomePage.jsx";
import Hosts from "../ui/pages/HostsPage/HostsPage.jsx";
import Countries from "../ui/pages/CountriesPage/CountriesPage.jsx";
import Stays from "../ui/pages/StaysPage/StaysPage.jsx";

const AppRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<Layout />}>
                <Route index element={<Home />} />
                <Route path="/stays" element={<Stays />} />
                <Route path="/hosts" element={<Hosts />} />
                <Route path="/countries" element={<Countries />} />
            </Route>
        </Routes>
    );
};

export default AppRouter;
