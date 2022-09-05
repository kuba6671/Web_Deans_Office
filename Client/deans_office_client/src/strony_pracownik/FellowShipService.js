import React from 'react';
import './Wnioski.css'

export default function FellowShipService(props){

    const displayFellow = (props) => {
        const {menu, fellows} = props;
        console.log(props);

        if(fellows.length > 0){
                    return(
                        <div className='getExam'>
                            <form className='getExamform'>
                            <div className='getExamin'>
                            <h1>Egzaminki!</h1>
                            <table>
                                <thead>
                                <tr>
                                    <th>Numer Indexu</th>
                                    <th>Data wysłania wniosku</th>
                                    <th>Decyzja</th>
                                </tr>
                                </thead>
                                <tbody>
                                {
                                    fellows.map(
                                        fellow =>
                                    <tr key={fellow.proposalID}>
                                        <td>{fellow.indexNumber}</td>
                                        <td>{fellow.proposalDate}</td>
                                        <td>{fellow.decision}</td>
                                    </tr>
                                    )
                                }
                                </tbody>
                            </table>
                            </div>
                            </form>
                        </div>
                    )
        }
        else{
            return (
                <div className='getWnioski'>
                <form className='getWnioskiform'>
                <div className='getWnioskiin'>
            <h3>Nie ma żadnych wniosków</h3>
                </div>
                </form>
                </div>
            )
        }
    }
    return(
        <>
            {displayFellow(props)}
        </>
    )
}