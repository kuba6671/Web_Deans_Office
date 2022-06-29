import React from 'react'
import * as AiIcons from "react-icons/ai";
import * as FaIcons from "react-icons/fa";
import * as IoIcons from "react-icons/io";
export const SidebarData_p = [
    {
        title: 'Home',
        path: '/home',
        icon: <AiIcons.AiFillHome/>,
        cName: 'nav-textp'
    },
    {
        title: 'Dodaj Studenta',
        path: '/DodajStudenta',
        icon: <FaIcons.FaAddressBook/>,
        cName: 'nav-textp'
    },
    {
        title: 'Wnioski',
        path: '/Wnioski',
        icon: <AiIcons.AiFillReconciliation/>,
        cName: 'nav-textp'
    },
    {
        title: 'Utwórz Zajecia',
        path: '/Zajecia',
        icon: <IoIcons.IoIosCreate />,
        cName: 'nav-textp'
    }
]