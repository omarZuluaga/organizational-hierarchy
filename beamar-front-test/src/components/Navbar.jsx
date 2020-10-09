import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <Link className="navbar-brand" to="/">
        Navbar
      </Link>
      <div className="navbar-collapse">
        <div className="navbar-nav">
          <Link className="nav-item nav-link active" to="/">
            Home <span className="sr-only">(current)</span>
          </Link>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
