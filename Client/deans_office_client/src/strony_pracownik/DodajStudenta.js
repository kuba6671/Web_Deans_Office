import React, { Component } from 'react'
import './DodajStudenta.css'
import axios from 'axios'

export class DodajStudenta extends Component {
  constructor(props) {
    super(props)

    this.state = {
      indexNumber: '',
      surname: '',
      group: '',
      fieldOfStudy: ''
    }

    this.jwt = {
        jwt: 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbGVrQHdwLnBsIiwiZXhwIjoxNjU2MTIxNjg3LCJpYXQiOjE2NTYxMDM2ODd9.ykELWYzEa4HgpVY47IglUJXxVkgJZmUNOaeanPbpWxiY-vhrWjDPtjqwpDF8VDb_3K7jtoxkRJwZRvRoiDZAEw'
    }
  }



    changeHandler = (e) => {
      this.setState({[e.target.name]: e.target.value})
    }

    
    submitStudentHandler = (e) => {
      e.preventDefault()
      console.log(this.state)
      axios.post('students', this.state,       
      {headers: {
        'Authorization': `Bearer ${this.jwt}`
    }})
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    }
  render() {
    const { indexNumber, imie, surname, group, fieldOfStudy} = this.state
    return (
      <div className='dodajocene_p'>
      <form onSubmit={this.submitStudentHandler} className='dodaj_p'>
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
          <input type='text' name='group' value={group} placeholder='12B' onChange={this.changeHandler} />
        <br />
          <input className='marksubmit_p' type='submit' />
          </div>
      </form>
  </div>
    )
  }
}

export default DodajStudenta