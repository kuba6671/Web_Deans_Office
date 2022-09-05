import React, {useState} from 'react';
import {useLocalState} from "../util/useLocalStorage";
import './Login.css'

const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [token, setToken] = useLocalState('', 'token')
    const [jwt, setJwt] = useLocalState("", "jwt");

    function sendLoginRequest() {
        const reqBody = {
            "username": username,
            "password": password,
        }

        fetch("api/auth/login", {
            headers: {
                "Content-type": "application/json",
            },
            method: "post",
            body: JSON.stringify(reqBody)
        })
            .then((response) => {
                if (response.status === 200)
                    return Promise.all([response.json(), response.headers, response.body]);
                else
                    return Promise.reject("Invalid login attempt");
            })
            .then(([body, headers]) => {
                setJwt(headers.get("authorization"));
                const role = body.authorities[0].authority
                setToken(role)
                console.log(jwt);
                console.log(token)
                window.location.reload();
            })
            .catch((message) => {
                alert(message);
            });
    }

    function loginByFacebook() {
        fetch("/login")
            .then((response) => response.json())
            .then((data) => {
                const facebookUserStatus = data.facebookUserStatus;
                if(facebookUserStatus !== "Users exist")
                    alert("User added to database");
                alert(facebookUserStatus);
            });

    }


    return (
        <form onSubmit={sendLoginRequest}>
            <div className="form-inner">
                <div className="form-group">
                    <label htmlFor="username"> Username</label>
                    <input
                        type="email"
                        name="email"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}/>
                </div>
                <div className="form-group">
                    <label htmlFor="password"> Password</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}/>
                </div>
                <div>
                    <button id="submit" type="button" onClick={() => sendLoginRequest()}>
                        Login
                    </button>
                </div>
                <div>
                    <button id="facebookLogin" type="button" onClick={() => loginByFacebook()}>
                        Zaloguj się przez Facebooka
                    </button>
                </div>
            </div>
        </form>
    )
};

export default Login;