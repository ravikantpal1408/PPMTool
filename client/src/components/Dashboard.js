import React, {Component} from "react";
// noinspection NpmUsedModulesInstalled
import PropTypes from "prop-types";
import ProjectItems from "./Project/ProjectItems";
import {connect} from "react-redux";
import CreateProjectButton from "./Project/CreateProjectButton";
import {getProjects} from "../actions/projectActions";


class Dashboard extends Component {
    componentDidMount() {
        this.props.getProjects();
    }

    render() {
        const {projects} = this.props.project;
        // console.table(projects.length);
        return (
            <div className="projects">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text-center">Projects</h1>
                            <br/>
                            <CreateProjectButton/>
                            <br/>
                            <hr/>
                            {projects.length > 0 ? projects.map((project, i) => <ProjectItems key={i}
                                                                                              project={project}/>) : null}
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
    {getProjects}
)(Dashboard);