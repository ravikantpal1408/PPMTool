import React, { Component } from "react";
// noinspection NpmUsedModulesInstalled
import PropTypes from "prop-types";
import ProjectItems from "./Project/ProjectItems";
import { connect } from "react-redux";
import CreateProjectButton from "./Project/CreateProjectButton";
import { getProjects } from "../actions/projectActions";



class Dashboard extends Component {
    componentDidMount() {
        this.props.getProjects().then(res=>{
            console.log(res)
        });

        console.log(this.props.getProjects());
    }

    render() {
        return (
            <div className="projects">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text-center">Projects</h1>
                            <br />
                            <CreateProjectButton />
                            <br />
                            <hr />
                            <ProjectItems />
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

Dashboard.propTypes = {
    project: PropTypes.object.isRequired,
    getProjects: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
    project: state.project
});

export default connect(
    mapStateToProps,
    { getProjects }
)(Dashboard);