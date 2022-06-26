import React, { Component } from 'react'
import './Wnioski.css'
import axios from 'axios'

export class Wnioski extends Component {
  constructor(props) {
    super(props)

    this.state = {
      socjal: [],
      nauk: []
    }
  }

  componentDidMount(){
    axios.get('http://localhost:8080/SocialGrantForm')
    .then(response => {
      console.log(response)
      this.setState({socjal: response.data})
    })
    .catch(error => {
      console.log(error)
    })
    axios.get('http://localhost:8080/FellowShipForm')
    .then(response => {
      console.log(response)
      this.setState({nauk: response.data})
    })
    .catch(error => {
      console.log(error)
    })

  }
  render() {
    return (
      <div className='wnioski'>
        <div className='wnioski-container-out'>
          <div className='wnioski-container-in'>
            <div className='wnioski-header'>
              <h2>Wnioski</h2>
            </div>
            <div className='wnioski-content'>
              <p>Wnioski o stypędium socjalne:</p>
              <li></li>
              <p>Wnioski o stypędium naukowe:</p>
              <li></li>
           </div>
          </div>
        </div>
      </div>
    )
  }
}

export default Wnioski