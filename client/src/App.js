import React from 'react';
import './App.css';
import Dashboard from "./components/Dashboard";
import Header from "./components/Layout/Header";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import AddProject from "./components/Project/AddProject";
import {Provider} from "react-redux";
import store from "./store";

class App extends React.Component {
    render() {
        return (
            <React.Fragment>
                <Provider store={store}>
                    <Router>
                        <div className="App">
                            <Header/>
                            <Switch>

                                <Route exact path={"/dashboard"} component={Dashboard}/>
                                <Route exact path={"/addProject"} component={AddProject}/>
                            </Switch>
                        </div>
                    </Router>
                </Provider>
            </React.Fragment>
        );
    }
}

export default App;
