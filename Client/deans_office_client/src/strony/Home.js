import React from 'react'
import { useLocalState } from '../util/useLocalStorage'

function Home() {

    const [jwt, setJwt] = useLocalState('', 'jwt')
    const [token, setToken] = useLocalState('', 'token')
    console.log('jwt:' + jwt)
    console.log(token)
  return (
    <div>Home123</div>
    
  )
}

export default Home