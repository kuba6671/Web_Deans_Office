import React, { useState, useEffect } from 'react'
import { useLocalState } from '../util/useLocalStorage';
import axios from 'axios';
import ExamService from './ExamsService';

function Exam() {

  const [jwt, setJwt] = useLocalState('', 'jwt')
  const [exams, getExams] = useState('')

  useEffect(() => {
    getAllExams();
  }, []);

  const getAllExams = () => {
    axios.get('/exams', {
        headers: {
            'Authorization': `Bearer ${jwt}`
        }
    })
        .then((response) => {
            const allExams = response.data;
            getExams(allExams);
            console.log(jwt);
        })
        .catch(error => console.error(`Error:  ${error}`));
}
  return (
    <>
    <ExamService exams={exams}/>
    </>
  )
}

export default Exam