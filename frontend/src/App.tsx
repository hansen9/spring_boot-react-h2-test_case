import './App.css'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import Customer from './pages/Customer';
import UpdatePage from './pages/UpdatePage';
import Log from './pages/Log'

function App() {

  return (
    <Router>
      <nav className="p-4 bg-gray-100 flex gap-4">
        <Link to="/">Home</Link>
        <Link to="/login">Login</Link>
        <Link to="/log">Logs</Link>
      </nav>
      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/customer" element={<Customer />} />
        <Route path="/log" element={<Log />} />
        <Route path="/update/:id" element={<UpdatePage />} />
      </Routes>
    </Router>
  )
}

export default App
