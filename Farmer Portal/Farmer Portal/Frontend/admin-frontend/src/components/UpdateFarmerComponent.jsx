import React, { Component } from 'react'
import FarmerService from '../services/FarmerService';

class UpdateFarmerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            farmerName: '',
            phone: '',
            emailId: '',
            address: ''
        }
        this.changeFarmerNameHandler = this.changeFarmerNameHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.updateFarmer = this.updateFarmer.bind(this);
    }

    componentDidMount(){
        FarmerService.getFarmerById(this.state.id).then( (res) =>{
            let farmer = res.data;
            this.setState({farmerName: farmer.farmerName,
                phone: farmer.phone,
                emailId : farmer.emailId,
                address: farmer.address
            });
        });
    }

    updateFarmer = (e) => {
        e.preventDefault();
        let farmer = {farmerName: this.state.farmerName, phone: this.state.phone, emailId: this.state.emailId, address: this.state.address};
        console.log('farmer => ' + JSON.stringify(farmer));
        console.log('id => ' + JSON.stringify(this.state.id));
        FarmerService.updateFarmer(farmer, this.state.id).then( res => {
            this.props.history.push('/farmers');
        });
    }
    
    changeFarmerNameHandler= (event) => {
        this.setState({farmerName: event.target.value});
    }

    changePhoneHandler= (event) => {
        this.setState({phone: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({emailId: event.target.value});
    }

    changeAddressHandler= (event) => {
        this.setState({address: event.target.value});
    }

    cancel(){
        this.props.history.push('/farmers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Farmer</h3>
                                <div className = "card-body">
                                    <form>
                                    <div className = "form-group">
                                            <label> Name: </label>
                                            <input placeholder="Name" name="farmerName" className="form-control" 
                                                value={this.state.farmerName} onChange={this.changeFarmerNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Phone Number: </label>
                                            <input placeholder="Phone Number" name="phone" className="form-control" 
                                                value={this.state.phone} onChange={this.changePhoneHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Email Id: </label>
                                            <input placeholder="Email Address" name="email" className="form-control" 
                                                value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Address: </label>
                                            <input placeholder="Address" name="address" className="form-control" 
                                                value={this.state.address} onChange={this.changeAddressHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateFarmer}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateFarmerComponent
