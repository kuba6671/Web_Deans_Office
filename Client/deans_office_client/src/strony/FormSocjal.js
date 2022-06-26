import React, { Component } from 'react'
import axios from 'axios'
import './FormSocjal.css'


export class FormSocjal extends Component {
  constructor(props) {
    super(props)

    this.state = {
      imie: '',
      nazwisko: '',
      dochod: '',
      ocena: ''
    }
  }

    changeHandler = (e) => {
      this.setState({[e.target.name]: e.target.value})
    }

    submitSocjalHandler = (e) => {
      e.preventDefault()
      console.log(this.social)
      axios.post('https://my-json-server.typicode.com/typicode/demo/posts', this.state)
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    }
  render() {
    const { imie, nazwisko, dochod, ocena } = this.state 
    return (
      <div className='formsocjal'>
      <form className='dodaj' onSubmit={this.submitSocjalHandler}>
        <div className='form-in'>
        <label>Imie:</label>
        <br />
        <input type='text' name='imie' value={imie} onChange={this.changeHandler} />
        <br />
        <label>Nazwisko:</label>
        <br />
        <input type='text' name='nazwisko' value={nazwisko}  onChange={this.changeHandler}  />
        <br />
        <label>Średnia Ocen:</label>
        <br />
        <input type='number' name='dochod' value={dochod}  onChange={this.changeHandler}  />
        <br />
        <label>Ocena:</label>
        <br/>
        <input className='marksubmit' type='submit'/>
      </div>
    </form>
    </div>
    )
  }
}

export default FormSocjal