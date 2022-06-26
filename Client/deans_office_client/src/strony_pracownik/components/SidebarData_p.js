import React from 'react'
import * as AiIcons from "react-icons/ai";
import * as FaIcons from "react-icons/fa";
import * as IoIcons from "react-icons/io";
export const SidebarData_p = [
    {
        title: 'Home',
        path: '/home',
        icon: <AiIcons.AiFillHome/>,
        cName: 'nav-text'
    },
    {
        title: 'Dodaj Studenta',
        path: '/DodajStudenta',
        icon: <FaIcons.FaAddressBook/>,
        cName: 'nav-text'
    },
    {
        title: 'Wnioski',
        path: '/Wnioski',
        icon: <AiIcons.AiFillReconciliation/>,
        cName: 'nav-text'
    },
    {
        title: 'Utwórz Zajecia',
        path: '/Zajecia',
        icon: <IoIcons.IoIosCreate />,
        cName: 'nav-text'
    }
]