import React, { useState, useEffect} from 'react'
import { useLocalState } from '../util/useLocalStorage';
import axios from 'axios';
import MarksService from './MarksService'

function Oceny() {
  const [jwt, setJwt] = useLocalState('', 'jwt')
  const [marks, getMarks] = useState('')

  useEffect(() => {
    getAllMarks();
  }, []);

  const getAllMarks = () => {
    axios.get('/marks', {
        headers: {
            'Authorization': `Bearer ${jwt}`
        }
    })
        .then((response) => {
            const allMarks = response.data;
            getMarks(allMarks);
            console.log(jwt);
        })
        .catch(error => console.error(`Error:  ${error}`));
}
  return (
    <>
    <MarksService marks={marks}/>
    </>
  )
}

export default Oceny