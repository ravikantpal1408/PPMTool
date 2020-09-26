import axios from 'axios';
import {GET_ERRORS, GET_PROJECTS, GET_PROJECT, DELETE_PROJECT} from "./types";



const baseURL = "http://localhost:8080/api";


export const createProject = (project, history) => async dispatch => {

    await axios.post("/project", project)
        .then(res => {
            console.table(res);
            history.push("/dashboard");
        }).catch(error => {
            dispatch({
                type: GET_ERRORS,
                payload: error.response.data
            })
        });

}


export const getProjects = () => async dispatch => {
    await axios.get("/project/all").then(res => {
        // console.log(res.data)
        dispatch({
            type: GET_PROJECTS,
            payload: res.data
        });
    }).catch(error => {
        dispatch({
            type: GET_ERRORS,
            payload: error.response.data
        })
    })

};


export const getProject = (id, history) => async dispatch => {
    await axios.get(`/project/${id}`).then(res=>{
        dispatch({
            type: GET_PROJECT,
            payload: res.data
        });
    }).catch(error=>{
        dispatch({
            type: GET_PROJECT,
            payload: error.response.data
        });
    });

};

export const deleteProject = id => async dispatch => {
    if(window.confirm("Are you sure you want to delete the project ?")){
        await axios.delete(`/project/${id}`);
        dispatch({
            type: DELETE_PROJECT,
            payload: id
        });
    }

};
