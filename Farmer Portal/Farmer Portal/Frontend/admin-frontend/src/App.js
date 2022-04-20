import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListProductComponent from './components/ListProductComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateProductComponent from './components/CreateProductComponent';
import ViewProductComponent from './components/ViewProductComponent';
import CreateFarmerComponent from './components/CreateFarmerComponent';
import ViewFarmerComponent from './components/ViewFarmerComponent';
import ListFarmerComponent from './components/ListFarmerComponent';
import UpdateFarmerComponent from './components/UpdateFarmerComponent';
import UpdateProductComponent from './components/UpdateProductComponent';


function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListFarmerComponent}></Route>
                          <Route path = "/farmers" component = {ListFarmerComponent}></Route>
                          <Route path = "/add-farmer/:id" component = {CreateFarmerComponent}></Route>
                          <Route path = "/view-farmer/:id" component = {ViewFarmerComponent}></Route>
                          <Route path = "/update-farmer/:id" component = {UpdateFarmerComponent}></Route> 
                    </Switch>

                    <Switch> 
                          <Route path = "/" exact component = {ListProductComponent}></Route>
                          <Route path = "/products" component = {ListProductComponent}></Route>
                          <Route path = "/add-product/:id" component = {CreateProductComponent}></Route>
                          <Route path = "/view-product/:id" component = {ViewProductComponent}></Route>
                          <Route path = "/update-product/:id" component = {UpdateProductComponent}></Route>
                    </Switch>
                </div>
              <FooterComponent />
        </Router>
    </div>
    
  );
}

export default App;
