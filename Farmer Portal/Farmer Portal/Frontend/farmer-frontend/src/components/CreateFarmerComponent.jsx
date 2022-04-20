import React, { Component } from 'react'
import FarmerService from '../services/FarmerService';

class CreateFarmerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            farmerName: '',
            phone: '',
            email: '',
            address: ''
        }
        this.changeFarmerNameHandler = this.changeFarmerNameHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.saveOrUpdateFarmer = this.saveOrUpdateFarmer.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            FarmerService.getFarmerById(this.state.id).then( (res) =>{
                let farmer = res.data;
                this.setState({farmerName: farmer.farmerName,
                    phone: farmer.phone,
                    email : farmer.email,
                    address : farmer.address
                });
            });
        }        
    }
    saveOrUpdateFarmer = (e) => {
        e.preventDefault();
        let farmer = {farmerName: this.state.farmerName, phone: this.state.phone, email: this.state.email, address: this.state.address};
        console.log('farmer => ' + JSON.stringify(farmer));

        // step 5
        if(this.state.id === '_add'){
            FarmerService.createFarmer(farmer).then(res =>{
                this.props.history.push('/farmers');
            });
        }else{
            FarmerService.updateFarmer(farmer, this.state.id).then( res => {
                this.props.history.push('/farmers');
            });
        }
    }
    
    changeFarmerNameHandler= (event) => {
        this.setState({farmerName: event.target.value});
    }

    changePhoneHandler= (event) => {
        this.setState({phone: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changeAddressHandler= (event) => {
        this.setState({address: event.target.value});
    }

    cancel(){
        this.props.history.push('/farmers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Farmer</h3>
        }else{
            return <h3 className="text-center">Update Farmer</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateFarmer}>Save</button>
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

export default CreateFarmerComponent
