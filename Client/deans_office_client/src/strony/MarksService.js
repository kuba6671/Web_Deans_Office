import React from 'react';
import './Oceny.css'

export default function MarksService(props){

    const displayMarks = (props) => {
        const {menu, marks} = props;
        console.log(props);

        if(marks.length > 0){
                    return(
                        <div className='getMark'>
                            <form className='getMarkform'>
                            <div className='getMarkin'>
                            <h1>Oceny!</h1>
                            <table>
                                <thead>
                                <tr>
                                    <th>Przedmiot</th>
                                    <th>Ocena</th>
                                </tr>
                                </thead>
                                <tbody>
                                {
                                    marks.map(
                                        mark =>
                                    <tr key={mark.examID}>
                                        <td>{mark.subject.name}</td>
                                        <td>{mark.teacher.mail}</td>
                                        <td>{mark.examDate}</td>
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
                <div className='getMark'>
                <form className='getMarkform'>
                <div className='getMarkin'>
            <h3>Brak Ocen</h3>
                </div>
                </form>
                </div>
            )
        }
    }
    return(
        <>
            {displayMarks(props)}
        </>
    )
}