import React, { Component } from "react";
import API from "../api";
export default class DepartmentForm extends Component {
  state = {
    loading: false,
    form: {
      departmentName: "",
      managerName: "",
      managerPhone: "",
      managerDateBirth: "",
      managerDateEntry: "",
      company: {id: +this.props.match.params.companyId}
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
    this.props.handleDeparmentForm();
  };

  hadleSubmit = async (e) => {
    e.preventDefault();

    this.setState({ loading: true, error: null });

    try {
      await API.department.POST(this.state.form);
      this.setState({ loading: false });
      this.props.handleDeparmentForm();
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
      <form onSubmit={this.hadleSubmit}>
        <div className="form-group">
          <label htmlFor="product_name_label">Nombre del departamento:</label>
          <input
            type="text"
            className="form-control"
            id="name_input"
            placeholder="Department"
            name="departmentName"
            onChange={this.handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="product_name_label">Nombre del gerente:</label>
          <input
            type="text"
            className="form-control"
            id="name_manager_input"
            placeholder="gerente"
            name="managerName"
            onChange={this.handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="product_name_label">Telefono del gerente:</label>
          <input
            type="text"
            className="form-control"
            id="phone_manager_input"
            placeholder="0"
            name="managerPhone"
            onChange={this.handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="product_name_label">
            Fecha de nacimiento del Gerente:
          </label>
          <input
            type="date"
            className="form-control"
            id="birth_date_manager_input"
            placeholder="0000-00-00"
            name="managerDateBirth"
            onChange={this.handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="product_name_label">
            Fecha de ingreso del gerente a la empresa:
          </label>
          <input
            type="date"
            className="form-control"
            id="date_entry_input"
            placeholder="0000-00-00"
            name="managerDateEntry"
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
