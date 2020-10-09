import React, { Component } from "react";
import API from "../api";
import SubDepartmentForm from "../components/SubDepartmentForm";

class SubDepartment extends Component {
  state = {
    loading: true,
    createMode: false,
    data: [],
  };

  fetchData = async () => {
    this.setState({ loading: true, error: null });

    try {
      const data = await API.subDepartment.GET.getByDepartment(this.props.match.params.departmentId);

      this.setState({ loading: false, data: data.data });
    } catch (error) {
      this.setState({ loading: false, error });
    }
  };

  removeSubDepartment = async (subDepartmentId) => {
    this.setState({ loading: true, error: null });

    try {
      let data = await API.subDepartment.DELETE(subDepartmentId);

      data = this.state.data.filter(element => element.id !== data.id)

      this.setState({ loading: false, data});
    } catch (error) {
      this.setState({ loading: false, error });
    }
  };

  handleSubDeparmentForm = () => {
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
          <SubDepartmentForm
            history={this.props.history}
            match = {this.props.match}
            handleSubDeparmentForm={this.handleSubDeparmentForm}
            fetchData = {this.fetchData}
          />
        </div>
      );
    }

    return (
      <div className=" container">
        <h2 className="mt-4">Sub departamentos</h2>
        <hr/>
        <div className="d-flex justify-content-end">
          <button
            className=" btn btn-primary m-2"
            onClick={this.handleSubDeparmentForm}
          >
            Crear sub departamento
          </button>
        </div>
        <table className="table table-bordered ">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nombre</th>
              <th scope="col">Acciones</th>
            </tr>
          </thead>
          <tbody>
            {this.state.data.map((subDepartment, index) => {
              return (
                <tr key={subDepartment.id}>
                  <th className="align-middle" scope="row">
                    {(index += 1)}
                  </th>
                  <td className="align-middle">{subDepartment.subDepartmentName}</td>
                  <td className=" d-flex justify-content-center align-middle">
                    <button className="btn btn-danger mx-1" onClick={() => this.removeSubDepartment(subDepartment.id)}>Eliminar</button>
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

export default SubDepartment;
