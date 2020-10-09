import React from "react";
import API from "../api";
import { Link } from "react-router-dom";

class Home extends React.Component {
  state = {
    loading: true,
    data: [],
  };

  fetchData = async () => {
    this.setState({ loading: true, error: null });

    try {
      const data = await API.company.GET.getAll();

      console.log(data);

      this.setState({ loading: false, data: data.data });
    } catch (error) {
      this.setState({ loading: false, error });
    }
  };

  removeCompany = async (companyId) => {
    this.setState({ loading: true, error: null });

    try {
      let data = await API.company.DELETE(companyId);

      data = this.state.data.filter(element => element.id !== data.id)

      this.setState({ loading: false, data});
    } catch (error) {
      this.setState({ loading: false, error });
    }
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

    return (
      <div className="container">
        <h2 className="mt-4">Compañias</h2>
        <hr/>
        <div className="d-flex justify-content-end">
          <Link className=" btn btn-primary m-2" to="/company">
            Crear compañia
          </Link>
        </div>
        <table className="table table-bordered ">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nombre</th>
              <th scope="col">Nit</th>
              <th scope="col">Acciones</th>
            </tr>
          </thead>
          <tbody>
            {this.state.data.map((company, index) => {
              return (
                <tr key={company.id}>
                  <th className="align-middle" scope="row">
                    {(index += 1)}
                  </th>
                  <td className="align-middle">{company.name}</td>
                  <td className="align-middle">{company.nit}</td>
                  <td className=" d-flex justify-content-center align-middle">
                    <Link className="btn btn-primary mx-1" to={`/department/${company.id}`}>Ver departamentos</Link>
                    <button className="btn btn-danger mx-1" onClick={() => this.removeCompany(company.id)}>Borrar</button>
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

export default Home;
