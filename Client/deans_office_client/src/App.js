import {useLocalState} from "./util/useLocalStorage";
import {Route, Routes} from 'react-router-dom';
import Dashboard from "./Dashboard";
import Login from "./Login";
import PrivateRoute from "./PrivateRoute";

function App() {
    const [jwt, setJwt] = useLocalState("","jwt");

  return (
      <div className="App">
          <Routes>
          <Route
              path="/dashboard"
              element={
              <PrivateRoute>
              <Dashboard/>
              </PrivateRoute>
          } />

          <Route path="/" element={ <Login />} />
      </Routes>
      </div>
  );
}

export default App;
