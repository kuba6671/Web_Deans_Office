import React, { Component } from 'react'
import './DodajStudenta.css'
import axios from 'axios'
import RestMethodsService from '../Services/RestMethods.service'

export default class DodajStudenta extends Component {
  constructor(props) {
    super(props)

    this.state = {
      groupID: 12345,
      indexNumber: 10,
      mail: "string@ds.pl",
      name: "string",
      password: "string",
      phoneNumber: "string",
      surname: "string",
      username: "string"
    }

    this.jwt = {
        jwt: 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZGFtQG9wLnBsIiwiZXhwIjoxNjYyMzM4Nzk2LCJpYXQiOjE2NjIzMjA3OTZ9.ha5O0zIoTALd3ZaSzO8nWRKBZCTC_fPwflaX-4_79tBzrSEb5_duw8HPKIwo-AzJSx47MJP3xyIpYFtzARRA0Q'
    }
  }

  onChangeGroupId(e) {
    this.setState({
      
    })
  }

  saveStudent = (e) => {
    e.preventDefault()
      console.log(this.state)
    var data = {
      age : 1,
      groupID: 12345,
      indexNumber: 12345,
      mail: "sds@sds.pl",
      name: "tomek",
      password: "sds",
      phoneNumber: "123456",
      surname: "this.state.surname",
      username: "this.state.username",
      headers: {
        'Authorization': `Bearer ${this.jwt}`
    }
    };
    RestMethodsService.addStudent(data)
    .then(response => {
      this.setState({
        indexNumber: response.data.indexNumber,
        surname: response.data.surname
      });
      console.log(response.data);
    })
    .catch(e => {
      console.log(e);
    });
  }





    changeHandler = (e) => {
      this.setState({[e.target.name]: e.target.value})
    }

    
    // submitStudentHandler = (e) => {
    //   e.preventDefault()
    //   console.log(this.state)
    //   axios.post('students', this.state,       
    //   headers: {
    //     'Authorization': `Bearer ${this.jwt}`
    // })
    //     .then(response => {
    //       console.log(response)
    //     })
    //     .catch(error => {
    //       console.log(error)
    //     })
    // }


  render() {
    const { age, groupID, indexNumber, mail, imie, surname, group, fieldOfStudy} = this.state
    return (
      <div className='dodajocene_p'>
      <form onSubmit={this.saveStudent} className='dodaj_p'>
          <div className='form-in_p'>
            <div className='add-student-header'><h2>Dodaj Studenta</h2></div>
          <label>Index Studenta: </label>
        <br />
          <input type='number' name='indexNumber' value={indexNumber} placeholder='90289' onChange={this.changeHandler} />
        <br />
          <label>Imie: </label>
        <br />
          <input type='text' name='imie' value={imie} placeholder='Daniel' onChange={this.changeHandler} />
        <br />
          <label>Nazwisko: </label>
        <br />
          <input type='text' name='surname' value={surname} placeholder='Kozłowski' onChange={this.changeHandler} />
        <br />
          <label>Kierunek:</label>
        <br />
          <input type='text' name='fieldOfStudy' value={fieldOfStudy} placeholder='inforamtyka' onChange={this.changeHandler} />
        <br />
        <label>Grupa:</label>
        <br />
          <input type='number' name='groupID' value={group} placeholder='12B' onChange={this.changeHandler} />
        <br />
          <input className='marksubmit_p' type='submit' />
          </div>
      </form>
  </div>
    )
  }
}