import React, { useEffect, useState } from 'react'
import { useLocalState } from '../util/useLocalStorage';
import axios from 'axios';
import './Wnioski.css'
function Wnioski() {
  
  const [jwt, setJwt] = useLocalState('', 'jwt')
  const [socials, getSocials] = useState('')
  const [fellows, getFellows] = useState('')

  useEffect(() => {
    getAllSocials();
  }, []);

  const getAllSocials = () => {
    axios.get('/SocialGramtForm', {
        headers: {
            'Authorization': `Bearer ${jwt}`
        }
    })
        .then((response) => {
            const allSocial = response.data;
            getSocials(allSocial);
            console.log(jwt);
        })
        .catch(error => console.error(`Error:  ${error}`));
}
  

useEffect(() => {
  getAllFellows();
}, []);

const getAllFellows = () => {
  axios.get('/FellowShipForm', {
      headers: {
          'Authorization': `Bearer ${jwt}`
      }
  })
      .then((response) => {
          const allFellows = response.data;
          getFellows(allFellows);
          console.log(jwt);
      })
      .catch(error => console.error(`Error:  ${error}`));
}
  return (
<>
</>
  )
}

export default Wnioski