import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import XemToanBoHocKy from './components/Admin/XemToanBoHocKy.jsx'
import HocPhanList from './components/HocPhanList.jsx'
import ThoiKhoaBieuSinhVien from './components/ThoiKhoaBieuSinhVien.jsx'
import DangKyHocPhan from './components/DangKyHocPhan.jsx'
import Navbar from './components/Page_Backbone/NavBar.jsx'
import FirstPart from './components/LandingPage/FirstPart.jsx'
import SecondPart from './components/LandingPage/SecondPart.jsx'


createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <HocPhanList/> */}
    {/* <XemToanBoHocKy /> */}
    {/* <ThoiKhoaBieuSinhVien/> */}
    {/* <DangKyHocPhan/> */}
    <Navbar/>
    <FirstPart/>
    <SecondPart/>
  </StrictMode>,
)
