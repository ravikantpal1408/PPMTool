import axios from 'axios';
import {GET_ERRORS} from "./types";


const baseURL = "http://localhost:8080/api";


export const createProject = (project, history) => async dispatch => {
    try {
        axios.post(baseURL + "/project", project)
            .then(res => {
                // console.log(res)
                history.push("/dashboard");
            }).catch(error => {
            // console.log("fata ", error)
            // console.log(error.response.data)
            dispatch({
                type: GET_ERRORS,
                payload: error.response.data
            })
        });
    } catch (e) {
        dispatch({
            type: GET_ERRORS,
            payload: e.response.data
        })
    }
}