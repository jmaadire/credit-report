import React, { Component } from 'react';
import { Form, FormControl, Button } from 'react-bootstrap';
import './css/Main.css';
import EmployeeList from './EmployeeList';
import { CreateNew } from './CreateNew';
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css';





class ManageCustomers extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            contacts: [],
            customerName: '',
            phoneNumber: '',
            bodyText: 'This text can be updated in modal 1'
        }
        this.handleChange = this.handleChange.bind(this);
    }
    handleChange(e) {
        const { name, value } = e.target;
        this.setState({ [name]: value });
    }


    componentDidMount() {
        fetch('http://localhost:8080/customers')
            .then(res => res.json())
            .then((data) => {
                this.setState({ contacts: data })
            })
            .catch(console.log)
    }

    render() {
        const { bodyText } = this.state;
        return (
            <div class="p-3 mb-2 bg-info text-black-50 container-fluid" >
                <div className="container-fluid">

                    <div className="row">
                        <div className="col-md-10">
                            <Form inline>
                                <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                                <Button variant="primary" className="mr-2" >Search</Button>
                            </Form>
                        </div>
                        <div className="col-md-2 align-right">
                            <button type="button" className="add-customer btn btn-dark align-right" onClick={CreateNew.open('create-customer')}><i className="fas fa-user-plus mr1"></i>Add Customer</button>
                        </div>
                    </div>
                </div>
                <CreateNew id="create-customer">
                    <h1>Create Order</h1>
                    <p>
                        Home page text: <input type="text" name="bodyText" value={bodyText} onChange={this.handleChange} />
                    </p>
                    <button onClick={CreateNew.close('create-customer')}>Close</button>
                </CreateNew>
                <EmployeeList contacts={this.state.contacts} className="customer-space" />
                {/*<BasicTableComponent contacts={this.state.contacts} />*/}
            </div>
        )
    }
}

export default ManageCustomers;