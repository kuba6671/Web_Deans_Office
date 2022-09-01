import React, { Component } from 'react'
import './Platnosci.css'

export class Platnosci extends Component {
  render() {
    return (
      <div className='platnosci'>
        <h2>Wykonaj płatność</h2>
        <a href='link do płatnosci'><button onClick={alert('Wszytko zostało opłacone')}>Wykonaj płatność</button></a>
      </div>
    )
  }
}

export default Platnosci