import React, {Component} from 'react';
import ProjectItems from "./Project/ProjectItems";
import CreateReactButton from "./Project/CreateProjectButton";


class Dashboard extends Component {
    render() {
        return (

            <div className="projects">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text-center">Projects</h1>
                            <br/>
                            <CreateReactButton/>
                            <br/>
                            <hr/>

                            <ProjectItems/>


                        </div>
                    </div>
                </div>
            </div>

        );
    }
}

export default Dashboard;