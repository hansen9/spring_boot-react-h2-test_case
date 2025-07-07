import TopBar from '../components/TopBar'
import CustomerDashboard from '../components/CustomerDashboard';

export default function LoginForm() {
  return (
    <div className="max-w-sm mx-auto mt-10 p-6 bg-white shadow-md rounded">
      <TopBar/>
      <CustomerDashboard />
    </div>
  );
}