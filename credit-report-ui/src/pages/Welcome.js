import React, { Component } from 'react';
import { Tab, Tabs } from 'react-bootstrap';
import ManageCustomers from './ManageCustomers';
import ManageOrders from './ManageOrders';
import ManageReports from './ManageReports';
import './css/Main.css';

class Welcome extends React.Component {
    render() {
        return (
            <div className="p-3 mb-2 bg-secondary text-white container-fluid">
                <Tabs defaultActiveKey="profile" id="uncontrolled-tab-example">
                    <Tab eventKey="profile" title="ManageCustomers">
                        <p>
                            < ManageCustomers />
                        </p>
                    </Tab>
                    <Tab eventKey="home" title="ManageOrders">
                        <p>
                            < ManageOrders />
                        </p>
                    </Tab>
                    <Tab eventKey="contact" title="ManageReports">
                        <p>
                            < ManageReports />
                        </p>
                    </Tab>
                </Tabs>
            </div>
        );
    }
}

export default Welcome;
