import React from 'react'
import * as AiIcons from "react-icons/ai";
/*import * as FaIcons from "react-icons/fa";
import * as IoIcons from "react-icons/io";
*/
export const SidebarData = [
    {
        title: 'Home',
        path: '/home',
        icon: <AiIcons.AiFillHome/>,
        cName: 'nav-text'
    },
    {
        title: 'Oceny',
        path: '/Dashboard',
        icon: <AiIcons.AiFillBook/>,
        cName: 'nav-text'
    },
    {
        title: 'Stypędium Socjalne',
        path: '/FormSocjal',
        icon: <AiIcons.AiFillCreditCard />,
        cName: 'nav-text'
    },
    {
        title: 'Stypędium Naukowe',
        path: '/FormNauk',
        icon: <AiIcons.AiFillCreditCard />,
        cName: 'nav-text'
    },
    {
        title: 'Terminy Zaliczeń',
        path: '/Exam',
        icon: <AiIcons.AiFillCarryOut />,
        cName: 'nav-text'
    },
    {
        title: 'Płatnści',
        path: '/Platnosci',
        icon: <AiIcons.AiTwotoneWallet />,
        cName: 'nav-text'
    }
]