import React from 'react';

export default function SubjectService(props){

    const displaySubjects = (props) => {
        const {menu, subjects} = props;

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
            return (<h3>No subjects</h3>)
        }
    }
    return(
        <>
            {displaySubjects(props)}
        </>
    )
}