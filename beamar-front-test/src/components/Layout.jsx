import React from "react";
import Navbar from "./Navbar";
import Footer from "./Footer";
import "./styles/Layout.css";
//</React.Fragment> We avoid placing div simplifying the code when inspecting elements.
function Layout(props) {
  // <React.Fragment></React.Fragment> = <></>
  return (
    <div className="page-container">
      <Navbar />
      <main className="content-wrap">{props.children}</main>
      <Footer />
    </div>
  );
}

export default Layout;
