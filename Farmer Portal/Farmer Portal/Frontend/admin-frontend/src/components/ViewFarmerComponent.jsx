import React, { Component } from 'react'
import FarmerService from '../services/FarmerService'

class ViewFarmerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            farmer: {}
        }
    }

    componentDidMount(){
        FarmerService.getFarmerById(this.state.id).then( res => {
            this.setState({farmer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Farmer Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Farmer First Name: </label>
                            <div> { this.state.farmer.farmerName }</div>
                        </div>
                        <div className = "row">
                            <label> Farmer Phone: </label>
                            <div> { this.state.farmer.phone }</div>
                        </div>
                        <div className = "row">
                            <label> Farmer Email ID: </label>
                            <div> { this.state.farmer.email }</div>
                        </div>
                        <div className = "row">
                            <label> Farmer Address: </label>
                            <div> { this.state.farmer.address }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewFarmerComponent
