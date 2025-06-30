import { Outlet } from 'react-router-dom';
import Header from '../Header/Header.jsx';
// import Footer from '../Footer/Footer.jsx';

const Layout = () => {
    return (
        <>
            <Header />
            <main style={{ padding: '2rem' }}>
                <Outlet />
            </main>
            {/*<Footer />*/}
        </>
    );
};

export default Layout;
