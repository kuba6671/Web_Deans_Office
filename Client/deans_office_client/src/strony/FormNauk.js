import React, { Component, useState } from 'react'
import {useLocalState} from "../util/useLocalStorage";
import './FormNauk.css'
import axios from 'axios'


const FormNauk = () => {
  const [markAvg, setMarkAvg] = useState("");
  const [indexNumber, setIndexNumber] = useState("");
  const [jwt, setJwt] = useLocalState("", "jwt");

  function saveFellowShipProposal() {
    const reqBody = {
      "name" : 'Stypendium naukowe',
      "proposalDate" : Date.UTC,
      "markAvg" : markAvg,
      "student" : {
        "age": 20,
        "group": {
          "groupID": 12345
        },
        "indexNumber" : indexNumber
      }
    }
    fetch("/FellowShipForm", {
      headers: {
        'Authorization': `Bearer ${jwt}`,
        "Content-type": "application/json",
    },
    method: "post",
    body: JSON.stringify(reqBody)
    })
  }

  return (
    <div className='formnauk'>
    <form onSubmit={saveFellowShipProposal} className='dodaje'>
    <div className='form-ine'>
    <label>Index:</label>
    <br />
    <input 
      type='text' 
      name='indexNumber'
      value={indexNumber}
      onChange={(e) => setIndexNumber(e.target.value)}/>
    <br />
    <label>Średnia:</label>
    <br />
    <input 
      type='text'
      name='markAvg'
      value={markAvg} 
      onChange={(e) => setMarkAvg(e.target.value)} />
    <br />
    <input type='submit'/>
    </div>
</form>
</div>
    )
}

export default FormNauk