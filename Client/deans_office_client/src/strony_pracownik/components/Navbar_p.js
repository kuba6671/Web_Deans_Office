import React, {useState} from 'react'
import * as AiIcons from "react-icons/ai";
import * as FaIcons from "react-icons/fa";
import { Link } from 'react-router-dom';
import { SidebarData_p } from './SidebarData_p';
import './Navbar_p.css';
import { IconContext } from "react-icons"
import { useLocalState } from '../../util/useLocalStorage';

function Navbar_p() {
    const [isLoading, setIsLoading] = useState(false)
    const [token, setToken] = useLocalState ('', 'token')

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
    <div className='navbar_p'>
        <Link to="#" className='menu-bars_p'>
            <button onClick={buttonHandler}><FaIcons.FaBars /></button>
        </Link>
    </div>
     <nav className={isLoading ? 'nav-menu_p active' : 'nav-menu_p'}>
        <ul className='nav-menu-items_p' onClick={buttonHandler}>
            <li className='navbar-toggle_p'>
                <Link to="#" className='menu-bars_p'>
                    <button onClick={buttonHandler}><AiIcons.AiOutlineClose/></button>
                </Link>
            </li>
            {SidebarData_p.map((item, index) => {
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

export default Navbar_p