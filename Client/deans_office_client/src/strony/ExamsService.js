import React from 'react';
import './Exam.css'

export default function ExamService(props){

    const displayExams = (props) => {
        const {menu, exams} = props;
        console.log(props);

        if(exams.length > 0){
                    return(
                        <div className='getExam'>
                            <form className='getExamform'>
                            <div className='getExamin'>
                            <h1>Egzaminki!</h1>
                            <table>
                                <thead>
                                <tr>
                                    <th>Przedmiot</th>
                                    <th>Wykładowca</th>
                                    <th>Data</th>
                                </tr>
                                </thead>
                                <tbody>
                                {
                                    exams.map(
                                        exam =>
                                    <tr key={exam.examID}>
                                        <td>{exam.subject.name}</td>
                                        <td>{exam.teacher.mail}</td>
                                        <td>{exam.examDate}</td>
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
                <div className='getExam'>
                <form className='getExamform'>
                <div className='getExamin'>
            <h3>Brak Egzaminów</h3>
                </div>
                </form>
                </div>
            )
        }
    }
    return(
        <>
            {displayExams(props)}
        </>
    )
}