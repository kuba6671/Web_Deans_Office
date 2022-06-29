import React from 'react';
import './subject.css'

export default function SubjectService(props){

    const displaySubjects = (props) => {
        const {menu, subjects} = props;
        console.log(props);

        if(subjects.length > 0){
                    return(
                        <div>
                            <h1>Subjects list!</h1>
                            <table>
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                </tr>
                                </thead>
                                <tbody>
                                {
                                    subjects.map(
                                        subject =>
                                    <tr key={subject.subjectID}>
                                        <td>{subject.subjectID}</td>
                                        <td>{subject.name}</td>
                                    </tr>
                                    )
                                }
                                </tbody>
                            </table>
                        </div>
                    )
        }
        else{
            return (<h3>Brak Przedmiotów</h3>)
        }
    }
    return(
        <>
            {displaySubjects(props)}
        </>
    )
}