
import './TopBar.css'
import { Link } from 'react-router-dom';

function TopBar() {

  return (
    <>
    <div className='topbar'>
      <h1>Hello, user</h1>
      <Link to={"/login"}>
        <button>
          Logout
        </button>
      </Link>
    </div>
    </>
  )
}

export default TopBar
