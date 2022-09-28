import Home from './pages/Home';
import About from './pages/About';
import Partners from './pages/Partners';
import Signin from './pages/Signin';
import Signup from './pages/Signup';
import Navbar from './components/Navbar';
import Dashboard from './pages/customerPages/Dashboard';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Footer from './components/Footer';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import AddReview from './pages/customerPages/Dashboard/addReview';
import AdminSignin from './pages/AdminPages/Signin';
import VendorSignin from './pages/VendorPages/Signin';
import AddVendor from './pages/AdminPages/AddVendor';
import AdminDashboard from './pages/AdminPages/Dashboard';
import VendorDashboard from './pages/VendorPages/Dashboard';
import EditProfile from './pages/customerPages/EditProfile';
import AddService from './pages/customerPages/AddService';
import EditVendorProfile from './pages/VendorPages/EditProfile';
import MyVehicle from './pages/customerPages/MyVehicle';
import AddVehicle from './pages/customerPages/AddVehicle';

const AuthorizeUser = () => {
  const loginStatus = sessionStorage['loginStatus']
  return loginStatus === '1' ? <Home /> : <Signin />
}


function App() {
  return (
    <div className="app">
          <BrowserRouter>
          <Navbar />
      <Routes>
        <Route path="/" element= {<AuthorizeUser/>} />
        <Route path="/home" element={<Home/>} />
        <Route path="/about" element={<About/>} />
        <Route path="/partners" element={<Partners/>} />
        <Route path="/signin" element={<Signin/>} />
        <Route path="/signup" element={<Signup/>} />
        <Route path="/dashboard" element={<Dashboard/>} />
        <Route path="/addReview" element={<AddReview/>} />
        <Route path="/customer/addService" element={<AddService/>} />
        <Route path="/customer/myVehicle" element={<MyVehicle/>} />
        <Route path="/customer/addVehicle" element={<AddVehicle/>} />
        <Route path="/customer/editCustomer" element={<EditProfile/>} />
        <Route path="/admin/signin" element={<AdminSignin/>} />
        <Route path="/adminDashboard" element={<AdminDashboard/>} />
        <Route path="/admin/vendor/signup" element={<AddVendor/>} />
        <Route path="/vendor/signin" element={<VendorSignin/>} />
        <Route path="/vendorDashboard" element={<VendorDashboard/>} />
        <Route path="/admin/editVendor" element={<EditVendorProfile/>} />
     </Routes>
          <Footer/>
        </BrowserRouter>
        <ToastContainer theme="colored" />
        </div>
  )
}

export default App;
 