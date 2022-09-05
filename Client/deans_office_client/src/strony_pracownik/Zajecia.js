import React, { Component, useState } from 'react'
import axios from 'axios'
import './Zajecia.css'
import {useLocalState} from "../util/useLocalStorage";

const Zajecia = () => {
    const [lessonTime, setLessonTime] = useState("");
    const [weekday, setWeekday] = useState("");
    const [subject, setSubject] = useState("");
    const [teacher, setTeacher] = useState("");
    const [jwt, setJwt] = useLocalState("", "jwt");

    function saveLessonRequest() {
        const reqBody = {
            "lessontime": lessonTime,
            "weekday": {
                "weekdayId" : weekday
            },
            "subject": {
                "subjectID": subject
            },
            "teacher": {
                "teacherID": teacher
            }
        }
        fetch("/lessons", {
            headers: {
              'Authorization': `Bearer ${jwt}`,
              "Content-type": "application/json",
          },
          method: "post",
          body: JSON.stringify(reqBody)
          })
    }

    return (
      <div className='Zajecia-full'>
        <form className='form-outside' onSubmit={saveLessonRequest}>
            <div className='form-inside'>
            <div className='form-header'>
            <h2>Ustal Termin Zajec</h2>
            </div>
            <div className='form-text'>
                <label>Wykładowca:</label>
                <br />
                    <input 
                    type='number' 
                    name='teacher'
                    value={teacher} 
                    onChange={(e) => setTeacher(e.target.value)}/>
                <br />
                <label>Dzień tygodania:</label>
                <br />
                    <input 
                    type='text' 
                    name='weekday' 
                    value={weekday} 
                    onChange={(e) => setWeekday(e.target.value)} />
                <br />
                <label>Przedmiot:</label>
                <br />
                    <input 
                    type='text' 
                    name='subject' 
                    value={subject} 
                    onChange={(e) => setSubject(e.target.value)} />
                <br />
                <label>Godzina:</label>
                <br />
                    <input 
                    type='time' 
                    name='lessonTime' 
                    value={lessonTime} 
                    onChange={(e) => setLessonTime(e.target.value)} />
                <br />
                <input type='submit' />
            </div>
            </div>
        </form>
      </div>
    )
};

export default Zajecia