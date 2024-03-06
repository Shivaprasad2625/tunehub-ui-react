import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Index from "./Pages/Index";
import Registration from "./Pages/Registration";
import Login from "./Pages/Login";
import CustomerHome from "./Pages/CustomerHome";
import AdminHome from "./Pages/AdminHome";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Index />} />
        <Route path="/registration" element={<Registration />} />
        <Route path="/login" element={<Login />} />
        <Route path="/adminhome" element={<AdminHome />} />
        <Route path="/customerhome" element={<CustomerHome />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
