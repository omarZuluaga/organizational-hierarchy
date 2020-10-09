import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "../pages/Home";
import Company from "../pages/Company";
import Department from "../pages/Department";
import Layout from "./Layout";
import SubDepartment from "../pages/SubDepartment";

function App() {
  return (
    <BrowserRouter>
      <Layout>
        <Switch>
          <Route exact path="/" component={Home} />
          <Route exact path="/company" component={Company} />
          <Route exact path="/department/:companyId" component={Department} />
          <Route exact path="/subDepartment/:departmentId" component={SubDepartment} />
          {/* <Route exact path="/product/add" component={AddProduct} />
            <Route component={NotFound} /> */}
        </Switch>
      </Layout>
    </BrowserRouter>
  );
}

export default App;
