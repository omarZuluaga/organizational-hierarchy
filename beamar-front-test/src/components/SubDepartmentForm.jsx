import React, { Component } from "react";
import API from "../api";
export default class SubDepartmentForm extends Component {
  state = {
    loading: false,
    form: {
      subDepartmentName: "",
      department: {id: +this.props.match.params.departmentId}
    },
  };

  handleChange = (e) => {
    this.setState({
      form: {
        ...this.state.form,
        [e.target.name]: e.target.value,
      },
    });
  };

  handleCancel = () => {
    this.props.handleSubDeparmentForm();
  };

  handleSubmit = async (e) => {
    e.preventDefault();

    this.setState({ loading: true, error: null });

    try {
      await API.subDepartment.POST(this.state.form);
      this.setState({ loading: false });
      this.props.handleSubDeparmentForm();
      this.props.fetchData();
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

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

    return (
      <form onSubmit={this.handleSubmit}>
        <div className="form-group">
          <label htmlFor="product_name_label">Nombre del sub departamento:</label>
          <input
            type="text"
            className="form-control"
            id="name_input"
            placeholder="subDepartmentName"
            name="subDepartmentName"
            onChange={this.handleChange}
          />
        </div>
        <div className=" d-flex justify-content-end">
          <button
            type="button"
            className=" btn btn btn-light"
            onClick={this.handleCancel}
          >
            Cancelar
          </button>
          <button
            className="btn btn-primary mx-2"
            type="submit"
            disabled={this.state.loading}
          >
            {this.state.loading && (
              <span
                className="spinner-border spinner-border-sm"
                role="status"
                aria-hidden="true"
              ></span>
            )}
            Crear
          </button>
        </div>
      </form>
    );
  }
}
