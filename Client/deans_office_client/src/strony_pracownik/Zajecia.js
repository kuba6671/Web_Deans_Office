import React, { Component } from 'react'
import axios from 'axios'
import './Zajecia.css'

export class Zajecia extends Component {
    constructor(props){
        super(props)

        this.state = {
            teacher: '',
            room: '',
            subject: '',
            group: '',
            date: ''
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitClassesHandler = (e) => {
        e.preventDefault()
        console.log(this.state)
        axios.post('', this.state)
        .then (response =>{
            console.log(response)
        })
        .catch (error =>{
            console.log(error)
        })
    }

  render() {
    const { teacher, room, subject, group, date } = this.state
    return (
      <div className='Zajecia-full'>
        <form className='form-outside' onSubmit={this.submitClassesHandler}>
            <div className='form-inside'>
            <div className='form-header'>
            <h2>Ustal Termin Zajec</h2>
            </div>
            <div className='form-text'>
                <label>Wykładowca:</label>
                <br />
                <input type='number' name='teacher' value={teacher} onChange={this.changeHandler}/>
                <br />
                <label>Sala:</label>
                <br />
                <input type='text' name='room' value={room} onChange={this.changeHandler} />
                <br />
                <label>Przedmiot:</label>
                <br />
                <input type='text' name='subject' value={subject} onChange={this.changeHandler} />
                <br />
                <label>Grupa:</label>
                <br />
                <input type='text' name='group' value={group} onChange={this.changeHandler} />
                <br />
                <label>Data odbywania sie zajeć:</label>
                <br />
                <input type='date' name='date' value={date} onChange={this.changeHandler} />
                <br />
                <input type='submit' />
            </div>
            </div>
        </form>
        
      </div>
    )
  }
}

export default Zajecia