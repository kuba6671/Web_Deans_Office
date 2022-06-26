import React, {useEffect, useState} from "react";
import {useLocalState} from "../util/useLocalStorage";
import axios from "axios";
import SubjectService from "../Services/SubjectService";
import Navbar from "./compnents/Navbar";

export default function Dashboard() {
    const [jwt, setJwt] = useLocalState("","jwt");
    const[subjects, getSubjects] = useState('');
    const [token, setToken] = useLocalState("");
    const [name, setName] = useLocalState("", "name");

    useEffect(() => {
        getAllSubjects();
    }, []);

    const getAllSubjects = () => {
        axios.get('/subjects', {
            headers: {
                'Authorization': `Bearer ${jwt}`
            }
        })
            .then((response) => {
                const allSubjects = response.data;
                getSubjects(allSubjects);
                console.log(jwt);
                console.log("Token:" + token)
            })
            .catch(error => console.error(`Error:  ${error}`));
    }

    return(
        <>
        <SubjectService subjects={subjects}/>
        <Navbar />
        </>
    )
}
