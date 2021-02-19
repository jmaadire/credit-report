import React, { Component } from 'react';
import { Table, Button } from 'react-bootstrap';
import './css/Main.css';

class ManageOrders extends React.Component {
    render() {
        return (
            <div className="p-3 mb-2 bg-info text-black-50 container-fluid">
                <div className="container-fluid">
                    <br></br>
                    <div className="d-flex flex-row justify-content-start">
                        <div className="form-group form-inline">
                            <Button variant="primary" className="inline-space mr-2">Ceate Order</Button>
                        </div>
                        <div className="form-group form-inline">
                            <button type="button" className="inline-space btn btn-dark align-right"><i className="fas fa-user-plus mr1"></i>Edit Order</button>
                        </div>
                    </div>
                </div>
                <div className="row mb-4 text-black-50">
                    <div className="col-sm-12 grid-margin">
                        <div className="card h-100">
                            <h4 className="card-header">Report Details Table</h4>
                            <div className="card-body">
                                <Table striped bordered hover table >
                                    <thead class="thead-dark" >
                                        <tr>
                                            <th>SNo</th>
                                            <th>customerName</th>
                                            <th>PhoneNumber</th>
                                            <th>AlternatePhoneNumber</th>
                                            <th>EmailId</th>
                                            <th>DateOfBirth</th>
                                            <th>Address</th>
                                        </tr>
                                    </thead>
                                    {/* {contacts.map((contact) => ( */}
                                    <tbody >
                                        <tr>
                                            <td>sample1</td>
                                            <th>sample1</th>
                                            <th>sample1</th>
                                            <th>sample1</th>
                                            <th>sample1</th>
                                            <th>sample1</th>
                                            <th>sample1</th>
                                        </tr>
                                    </tbody>
                                    {/*  ))} */}
                                </Table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    };

};

export default ManageOrders;