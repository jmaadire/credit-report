import React, { Component } from 'react';
import { JwModal } from '../_components';

class CreateCustomer extends Component {

    render() {
        return (
            <JwModal id="my-custom-modal">
                <h1>A Custom Modal!</h1>
                <button onClick={JwModal.close('my-custom-modal')}>Close</button>
            </JwModal>
        )
    }
}

export default CreateCustomer;