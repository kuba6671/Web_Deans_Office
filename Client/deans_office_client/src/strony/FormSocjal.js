import React, { Component, useState } from 'react'
import {useLocalState} from "../util/useLocalStorage";
import axios from 'axios'
import './FormSocjal.css'


const FormSocjal = () => {
  const [income, setIncome] = useState("");
  const [indexNumber, setIndexNumber] = useState("");
  const [jwt, setJwt] = useLocalState("", "jwt");

  function saveFellowShipProposal() {
    const reqBody = {
      "proposalName" : 'Stypendium naukowe',
      "proposalDate" : Date.UTC,
      "income" : income,
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
    <label>Dochód:</label>
    <br />
    <input 
      type='text'
      name='income'
      value={income} 
      onChange={(e) => setIncome(e.target.value)} />
    <br />
    <input type='submit'/>
    </div>
</form>
</div>
    )
}

export default FormSocjal