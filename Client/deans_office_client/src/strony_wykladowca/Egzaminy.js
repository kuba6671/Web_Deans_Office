import React from 'react'
import './Egzaminy.css'

function Egzaminy() {
  return (
    <div className="egzaminy">
        <form className='dodaj_egzamin' >
            <div className='form-in'>
            <label>Grupa:</label>
            <br />
            <select>
                <option value='12B'>12B</option>
            </select>
            <br />
            <label >Przedmiot:</label>
            <br />
            <select>
                <option value='ISZ'>ISZ</option>
            </select>
            <br />
            <label>Typ Zaliczenia:</label>
            <br />
            <select>
            <option value='Obrona Projektu'>Obrona Projektu</option>
            <option value='Egzamin'>Egzamin</option>
            <option value='Zaliczenie wykładu'>Zaliczenie wykładu</option>
            </select>
            <br />
            <label>Termin zaliczenia:</label>
            <br/>
            <input type='date' />
            <br />
            <input className='egzamsubmit' type='submit'/>
            </div>
        </form>
    </div>
  )
}

export default Egzaminy