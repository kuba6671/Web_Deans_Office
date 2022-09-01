import React, { Component } from 'react'
import './FormNauk.css'
import axios from 'axios'


export class FormNauk extends Component {
 constructor(props) {
   super(props)
 
   this.state = {
      indexNumber: '',
      surname: '',
      income: '',
      markAVG: ''
   }
 }


 changeHandler = (e) => {
   this.setState({[e.target.name]: e.target.value})
 }

 submitNaukHandler = (e) => {
   e.preventDefault()
   console.log(this.state)
   axios.post('api/FellowShipForm', this.state)
   .then(response => {
     console.log(response)
   })
     .catch(error => {
       console.log(error)
     })
 }
  render() {
   const {imie, nazwisko, dochod, avg} = this.state
    return (
     <div className='formnauk'>
     <form onSubmit={this.submitNaukHandler} className='dodaje'>
   <div className='form-ine'>
   <label>Imie:</label>
   <br />
   <input type='text' name='imie' value={imie} onChange={this.changeHandler}/>
   <br />
   <label>Nazwisko:</label>
   <br />
   <input type='text' name='nazwisko' value={nazwisko} onChange={this.changeHandler} />
   <br />
   <label>Dochód z poprzedniego roku:</label >
   <br />
   <input type='number' name='dochod' value={dochod} onChange={this.changeHandler} />
   <br />
   <label>Średnia Ocen:</label>
   <br/>
     <input type='number' max={5} name='avg' value={avg} onChange={this.changeHandler} />
   <br />
   <input type='submit'/>
   </div>
</form>
</div>
    )
  }
}

export default FormNauk