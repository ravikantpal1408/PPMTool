import axios from 'axios';
import {GET_ERRORS} from "./types";
import {GET_PROJECTS} from "./types";


const baseURL = "http://localhost:8080/api";


export const createProject = (project, history) => async dispatch => {

    await axios.post(baseURL + "/project", project)
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
    await axios.get("http://localhost:8080/api/project/all").then(res => {
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