import axios from 'axios'
import React, { Component } from 'react'
import './Exam.css'

export class Exam extends Component {
    constructor(props) {
        super(props)

        this.state = {
            egzaminy: []
        }
    }

    componentDidMount(){
        axios.get('')
        .then(response => {
            console.log(response)
            this.setState({egzaminy: response.data})
        })
        .catch(error => {
            console.error(error)
        })
    }
  render() {
    return (
      <div className='egzamin'>
        <div className='egzamin-header'>
        <h2>Terminy egzaminów</h2>
        </div>
      <div clssName='terminy'>

      </div>
      </div>
    )
  }
}

export default Exam