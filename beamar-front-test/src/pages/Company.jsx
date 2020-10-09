import React, { Component } from "react";
import CompanyForm from "../components/CompanyForm";

export default class Company extends Component {
  render() {
    return (
      <div className=" container">
        <CompanyForm history={this.props.history} />
      </div>
    );
  }
}
