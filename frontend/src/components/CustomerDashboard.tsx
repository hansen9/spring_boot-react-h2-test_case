// App.js
import { useState, useEffect } from "react";
import { Link, useNavigate } from 'react-router-dom';
import './CustomerDashboard.css'
import axios from "axios";

// const customers = [
//   { id: 1, name: "Jim 1", address: "abc street", birthDate: "2000-02-26", stage: "Nurture"},
//   { id: 2, name: "Jim 2", address: "def street", birthDate: "2000-03-26", stage: "Nurture"},
// ];

function CustomerDashboard() {
  const [customers, setCustomers] = useState([]);
  const [error, setError] = useState('');
  const [search, setSearch] = useState("");
  const [filter, setFilter] = useState("all");
  const navigate = useNavigate();

  useEffect(() => {
    axios.get("http://localhost:8080/api/customers")
      .then(response => {
        setCustomers(response.data);
      })
      .catch(error => {
        const msg = error.response?.data?.message || "Failed to load customers.";
        setError(msg);
      });
  }, []);

  const handleAdd = () => {
    console.log("Add Element Clicked");
  };

  const handleUpdate = (customer: any) => {
    navigate(`/update/${customer.id}`, { state: customer });
  };

  const filteredData = customers.filter((customer: any) =>
    customer.name.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="p-6 max-w-4xl mx-auto">
      <div className="flex items-center justify-between mb-6 content-card">
        <div>
          <h2 className="text-xl font-semibold mb-2">Customers</h2>
          <div className="max-w-4rem">
            <input
              type="text"
              placeholder="search box"
              className="border rounded px-3 py-1"
              value={search}
              onChange={(e) => setSearch(e.target.value)}
            />
            <select
              className="border rounded px-3 py-1"
              value={filter}
              onChange={(e) => setFilter(e.target.value)}
            >
              <option value="">All</option>
              <option value="enum1">Seed</option>
              <option value="enum2">Nurture</option>
              <option value="enum2">Lead</option>
              <option value="enum2">Opportunity</option>
              <option value="enum2">Active</option>
              <option value="enum2">Loyal</option>
            </select>
            <Link to={"/customer"}>
                <button
                onClick={handleAdd}
                className="rounded-full w-24 h-24 border text-center text-sm hover:bg-gray-100"
                >
                add element
                </button>
            </Link>
          </div>
        </div>
      </div>

      <div className="space-y-4">
        <table>
          <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Birth Date</th>
            <th>Stage</th>
            <th>Action</th>
          </tr>
        {filteredData.map((customer) => (
            <tr
              key={customer.id}
              className="border rounded p-4 flex justify-between items-center"
            >
              <td>{customer.name}</td>
              <td>{customer.address}</td>
              <td>{customer.birthDate}</td>
              <td>{customer.stage}</td>
              <td>
                <button
                  onClick={() => handleUpdate(customer)}
                  className="rounded-full w-24 h-24 border text-sm hover:bg-gray-100"
                >
                  update button
                </button>
              </td>
            </tr>
          
        ))}
        </table>
      </div>
    </div>
  );
}

export default CustomerDashboard
