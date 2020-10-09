import React, { Component } from "react";
import API from "../api";
import DepartmentForm from "../components/DepartmentForm";
import { Link } from "react-router-dom";

export default class Department extends Component {
  state = {
    loading: true,
    createMode: false,
    data: [],
  };

  fetchData = async (companyId) => {
    this.setState({ loading: true, error: null });

    try {
      const data = await API.department.GET.getByCompany(this.props.match.params.companyId);

      this.setState({ loading: false, data: data.data });
    } catch (error) {
      this.setState({ loading: false, error });
    }
  };

  removeDepartment = async (departmentId) => {
    this.setState({ loading: true, error: null });

    try {
      let data = await API.department.DELETE(departmentId);

      data = this.state.data.filter(element => element.id !== data.id)

      this.setState({ loading: false, data});
    } catch (error) {
      this.setState({ loading: false, error });
    }
  };
  handleDeparmentForm = () => {
    this.setState({ createMode: !this.state.createMode });
  };

  componentDidMount() {
    this.fetchData();
  }

  render() {
    if (this.state.loading) {
      return (
        <div className="loading-item">
          <p>Cargando...</p>
        </div>
      );
    }

    if (this.state.error) {
      return (
        <div className="error-message">
          <p>{this.state.error.message}</p>
        </div>
      );
    }
    if (this.state.createMode) {
      return (
        <div className=" container">
          <DepartmentForm
            history={this.props.history}
            match = {this.props.match}
            handleDeparmentForm={this.handleDeparmentForm}
            fetchData = {this.fetchData}
          />
        </div>
      );
    }

    return (
      <div className=" container">
        <h2 className="mt-4">Departamentos</h2>
        <hr/>
        <div className="d-flex justify-content-end">
          <button
            className=" btn btn-primary m-2"
            onClick={this.handleDeparmentForm}
          >
            Crear departamento
          </button>
        </div>
        <table className="table table-bordered ">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nombre</th>
              <th scope="col">Gerente</th>
              <th scope="col">Acciones</th>
            </tr>
          </thead>
          <tbody>
            {this.state.data.map((department, index) => {
              return (
                <tr key={department.id}>
                  <th className="align-middle" scope="row">
                    {(index += 1)}
                  </th>
                  <td className="align-middle">{department.departmentName}</td>
                  <td className="align-middle">{department.managerName}</td>
                  <td className=" d-flex justify-content-center align-middle">
                    <Link className="btn btn-primary mx-1" to={`/subDepartment/${department.id}`}>Sub departamentos</Link>
                    <Link className="btn btn-danger mx-1" onClick={() => this.removeDepartment(department.id)}>Eliminar</Link>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    );
  }
}
