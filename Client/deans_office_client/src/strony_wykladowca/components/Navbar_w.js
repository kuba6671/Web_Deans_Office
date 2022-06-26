import React, {useState} from 'react'
import * as AiIcons from "react-icons/ai";
import * as FaIcons from "react-icons/fa";
import { Link } from 'react-router-dom';
import { SidebarData_w } from './SidebarData_w';
import './Navbar_w.css';
import { IconContext } from "react-icons"
import { useLocalState } from '../../util/useLocalStorage';

function Navbar_w() {
    const [isLoading, setIsLoading] = useState(false)
    const [token, setToken] = useLocalState('', 'token')
    const buttonHandler = () => {
      setIsLoading(current => !current)
      console.log(isLoading)
    }

    const LogOut = () => {
        setToken('NieZalogowany')
    }

  return (
    <>
    <IconContext.Provider value={{ color: 'fff' }}>
    <div className='navbar_w'>
        <Link to="#" className='menu-bars'>
            <button onClick={buttonHandler}><FaIcons.FaBars /></button>
        </Link>
    </div>
     <nav className={isLoading ? 'nav-menu_w active' : 'nav-menu_w'}>
        <ul className='nav-menu-items_w' onClick={buttonHandler}>
            <li className='navbar-toggle_w'>
                <Link to="#" className='menu-bars_w'>
                    <button onClick={buttonHandler}><AiIcons.AiOutlineClose/></button>
                </Link>
            </li>
            {SidebarData_w.map((item, index) => {
                return (
                    <li key={index} className={item.cName}>
                        <Link to={item.path}>
                            {item.icon}
                            <span>{item.title}</span>
                        </Link>
                    </li>
                )
            }
            )}
            <li>
               <a href='http://localhost:3000'><button onClick={LogOut}>Wyloguj</button></a>
            </li>
        </ul>
     </nav>
     </IconContext.Provider>
    </>
  )
}

export default Navbar_w