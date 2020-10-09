import React, { Component } from "react";
import API from "../api";

export default class CompanyForm extends Component {
  state = {
    loading: false,
    form: {
      name: "",
      nit: "",
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

  handleSubmit = async (e) => {
    e.preventDefault();

    this.setState({ loading: true, error: null });

    try {
      const company = await API.company.POST(this.state.form);
      this.setState({ loading: false });
      this.props.history.push(`/department/${company.data.id}`);
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
          <label htmlFor="product_name_label">Nombre de la compañia:</label>
          <input
            type="text"
            className="form-control"
            id="name_input"
            placeholder="Compañia"
            name="name"
            onChange={this.handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="price_label">NIT:</label>
          <input
            type="number"
            step="any"
            className="form-control"
            id="nit_input"
            placeholder="0"
            name="nit"
            onChange={this.handleChange}
          />
        </div>
        <div className=" d-flex justify-content-end">
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
