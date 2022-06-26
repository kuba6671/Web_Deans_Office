import {useLocalState} from "./util/useLocalStorage";
import {Route, Routes} from 'react-router-dom';
import Dashboard from "./strony/Dashbord";
import Login from "./Login/Login";
import PrivateRoute from "./PrivateRoute";
import Navbar from "./strony/compnents/Navbar";
import { Else, If, Then } from "react-if";
import './App.css'
import Home from "./strony/Home";
import FormNauk from "./strony/FormNauk"
import Navbar_w from "./strony_wykladowca/components/Navbar_w";
import DodajOceny from "./strony_wykladowca/DodajOcene";
import Egzaminy from "./strony_wykladowca/Egzaminy";
import Navbar_p from "./strony_pracownik/components/Navbar_p";
import DodajStudenta from "./strony_pracownik/DodajStudenta";
import Zajecia from "./strony_pracownik/Zajecia";
import Wnioski from "./strony_pracownik/Wnioski";
import FormSocjal from "./strony/FormSocjal";
import Exam from "./strony/Exam";
import Platnosci from "./strony/Platnosci";

function App() {
    const [token, setToken] = useLocalState('', 'token');
    const [jwt, setJwt] = useLocalState("","jwt");
  return (
    <div className='Main'>
    {(token !== 'NieZalogowany') ? (
      <div className="App">
        <If condition={token === 'ROLE_STUDENT'}>
            <Then>
            <Navbar />
            <Routes>
            <Route
              path="/dashboard"
              element={
              <PrivateRoute>
              <Dashboard/>
              </PrivateRoute>
            } />
            <Route path='/home' element={<Home />} />
            <Route path='/FormNauk' element={<FormNauk />} />
            <Route path='FormSocjal' element={<FormSocjal />} />
            <Route path='Exam' element={<Exam />} />
            <Route path='Platnosci' element={<Platnosci />} />
            </Routes>
            </Then>
            <Else>
            <If condition={token === 'ROLE_TEACHER'}>
                <Then>
                <Navbar_w />
            <Routes>
            <Route path='/home' element={<Home />} />
            <Route path='/DodajOceny' element={<DodajOceny />} />
            <Route path='/Egzaminy' element={<Egzaminy />} />
            </Routes>
                </Then>
                <Else>
                <If condition={token === 'ROLE_OFFICEEMPLOYEE'}>
                    <Then>
                    <Navbar_p />
            <Routes>
            <Route
              path="/dashboard"
              element={
              <PrivateRoute>
              <Dashboard/>
              </PrivateRoute>
                        } />
                        <Route path='/home' element={<Home />} />
                        <Route path='/DodajStudenta' element={<DodajStudenta />} />
                        <Route path='/Zajecia' element={<Zajecia />} />
                        <Route path='/Wnioski' element={<Wnioski />} />
                        </Routes>
                    </Then>
                </If>
            </Else>
            </If>
            </Else>
        </If>
        </div>
  ) : (
    <div className='logowanie'>
        <Routes>
          <Route path="/" element={ <Login />} />
         </Routes>
      </div>
  )}
  </div>
  );
}

export default App;