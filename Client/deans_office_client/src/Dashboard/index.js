import React, {useEffect, useState} from "react";
import {useLocalState} from "../util/useLocalStorage";
import axios from "axios";
import SubjectService from "../Services/SubjectService";


export default function Dashboard() {
    const [jwt, setJwt] = useLocalState("","jwt");
    const[subjects, getSubjects] = useState('');

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
            })
            .catch(error => console.error(`Error:  ${error}`));
    }

    return(
        <SubjectService subjects={subjects}/>
    )
}
