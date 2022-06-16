import React, {useState} from 'react';
import {useLocalState} from "../util/useLocalStorage";

const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const [jwt, setJwt] = useLocalState("", "jwt");
    function sendLoginRequest(){
            const reqBody = {
                "username": username,
                "password": password
            }

            fetch("api/auth/login", {
                headers: {
                    "Content-type": "application/json",
                },
                method: "post",
                body: JSON.stringify(reqBody),
            })
                .then((response) => {
                        if (response.status === 200)
                            return Promise.all([response.json(), response.headers]);
                        else
                            return Promise.reject("Invalid login attempt");
                })
                .then(([body, headers]) => {
                    setJwt(headers.get("authorization"));
                    window.location.href = "dashboard";
                })
                .catch((message) => {
                    alert(message);
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
                    onChange={(e) => setUsername(e.target.value)} />
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
                <button id="submit" type="button" onClick={() => sendLoginRequest()} >
                    Login
                </button>
            </div>
        </div>
        </form>
    )
};

export default Login;