import "./NavBarCss.css";

export default function Navbar() {
    return (
        <nav class="navbar">
        <div class="logo">
            <img src="./CTU_logo.png" alt="Logo"/>
            <span>SCHOOL</span>
        </div>
        <ul class="nav-links">
            <li><a href="#">HOME</a></li>
            <li><a href="#">ABOUT US</a></li>
            <li><a href="#">COURSES</a></li>
            <li><a href="#">CONTACT</a></li>
            <li><a href="#">EXTERNAL</a></li>
        </ul>
    </nav>
    );
  }
  