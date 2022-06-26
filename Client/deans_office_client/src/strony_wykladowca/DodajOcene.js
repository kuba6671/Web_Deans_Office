import React, { Component } from 'react'
import './Dodaj.css'
import axios from 'axios'

export class DodajOceny extends Component {
  constructor(props) {
    super(props)

    this.mark = {
      grupa: '',
      student: '',
      przedmiot: '',
      ocena: ''
    }
  }

    changeHandler = (e) => {
      this.setMark({[e.target.name]: e.target.value})
    }

    submitMarkHandler = (e) => {
      e.preventDefault()
      console.log(this.mark)
      axios.post('https://my-json-server.typicode.com/typicode/demo/posts', this.mark)
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    }
  render() {
    const { grupa, student, przedmiot, ocena} = this.mark
    return (
      <div className='dodajocene'>
      <form onSubmit={this.submitMarkHandler} className='dodaj'>
          <div className='form-in'>
          <label>Grupa:</label>
          <br />
          <select name='grupa' value={grupa} onChange={(ddl=>this.mark({grupa:ddl.target.value}))}>
              <option value='12B'>12B</option>
          </select>
          <br />
          <label >Student:</label>
          <br />
          <select name='student' value={student} onChange={this.changeHandler}>
            <option value='alek@student.tu.kielce.pl'>alek@student.tu.kielce.pl</option>
          </select>
          <br />
          <label>Przedmiot:</label>
          <br />
          <select name='przedmiot' value={przedmiot} onChange={this.changeHandler}>
          <option value='ISZ'>ISZ</option>
          </select>
          <br />
          <label>Ocena:</label>
          <br/>
          <select name='ocena' value={ocena} onChange={this.changeHandler}>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="3,5">3,5</option>
          <option value="4">4</option>
          <option value="4,5">4,5</option>
          <option value="5">5</option>
        </select>
        <br />
          <input className='marksubmit' type='submit' />
          </div>
      </form>
  </div>
    )
  }
}

export default DodajOceny