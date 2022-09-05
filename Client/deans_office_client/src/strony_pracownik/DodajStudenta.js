import React, { Component, useState} from 'react'
import {useLocalState} from "../util/useLocalStorage";
import './DodajStudenta.css'
import axios from 'axios'
import RestMethodsService from '../Services/RestMethods.service'
import http from "../http-common"

const DodajStudenta = () => {
  const [indexNumber, setindexNumber] = useState("");
  const [password, setPassword] = useState("");
  const [name, setImie] = useState("");
  const [surname, setSurName] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [fieldOfStudy, setFieldOfStudy] = useState("");
  const [groupID, setGroupID] = useState("");
  const [age, setAge] = useState("");
  const [mail, setMail] = useState("");
  const [jwt, setJwt] = useLocalState("", "jwt");

  function saveStudentRequest() {
    const reqBody = {
      "indexNumber": indexNumber,
      "password": password,
      "name": name,
      "surname": surname,
      "phoneNumber": phoneNumber,
      "fieldOfStudy": fieldOfStudy,
      "group" : {
        "groupID": 12345
      },
      "fieldOfStudy": fieldOfStudy,
      "mail": mail,
      "age": age,
    }
    fetch("/students", {
      headers: {
        'Authorization': `Bearer ${jwt}`,
        "Content-type": "application/json",
    },
    method: "post",
    body: JSON.stringify(reqBody)
    })
  }

  return (
          <div className='dodajocene_p'>
          <form onSubmit={saveStudentRequest} className='dodaj_p'>
              <div className='form-in_p'>
                <div className='add-student-header'><h2>Dodaj Studenta</h2></div>
              <label>Index Studenta: </label>
            <br />
              <input 
              type='number' 
              name='indexNumber' 
              value={indexNumber} 
              onChange={(e) => setindexNumber(e.target.value)}/>
            <br />
              <label>Imie: </label>
            <br />
              <input 
              type='text' 
              name='name' 
              value={name}
              onChange={(e) => setImie(e.target.value)}/>
            <br />
              <label>Nazwisko: </label>
            <br />
              <input 
              type='text' 
              name='surname' 
              value={surname}
              onChange={(e) => setSurName(e.target.value)}
              />
            <br />
              <label>Kierunek:</label>
            <br />
              <input 
              type='text' 
              name='fieldOfStudy' 
              value={fieldOfStudy}
              onChange={(e) => setFieldOfStudy(e.target.value)}/>
            <br />
            <label>Grupa:</label>
            <br />
              <input
               type='text' 
               name='groupID' 
               value={groupID}
               onChange={(e) => setGroupID(e.target.value)}
               />
            <br />
            <label>Wiek:</label>
            <br />
              <input
               type='text' 
               name='age' 
               value={age}
               onChange={(e) => setAge(e.target.value)}
               />
            <br />
            <label>Numer telefonu:</label>
            <br />
              <input
               type='text' 
               name='phoneNumber' 
               value={phoneNumber}
               onChange={(e) => setPhoneNumber(e.target.value)}
               />
            <br />
            <label>Hasło:</label>
            <br />
              <input
               type='text' 
               name='password' 
               value={password}
               onChange={(e) => setPassword(e.target.value)}
               />
            <br/>
            <label>Mail:</label>
            <br/>
              <input
               type='text' 
               name='mail' 
               value={mail}
               onChange={(e) => setMail(e.target.value)}
               />
            <br/>
            <button id="submit" type="button" onClick={() => saveStudentRequest()} >
                    SUBMIT
                </button>
              </div>
          </form>
      </div>
  )
};

export default DodajStudenta;