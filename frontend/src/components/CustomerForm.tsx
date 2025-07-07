import { useState, useEffect } from "react";
import { Link } from 'react-router-dom';



const CustomerForm = ({ initialData = null, onSubmit }) =>  {
  const [form, setForm] = useState({
    name: "",
    address: "",
    dob: "",
  });

  useEffect(() => {
    if (initialData) {
      setForm({
        name: initialData.name || "",
        address: initialData.address || "",
        dob: initialData.dob || "",
      });
    }
  }, [initialData]);
  
  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(form); // delegate to parent
  };

  return (
    <div className="flex justify-center items-center h-screen bg-gray-100">
      <form className="bg-white p-8 rounded shadow-md w-full max-w-xl" onSubmit={handleSubmit}>
        <h2 className="text-lg font-semibold mb-6">Form</h2>

        {/* Name */}
        <div className="flex items-center mb-4">
          <label className="w-40">Name</label>
          <input
            type="text"
            className="flex-1 border rounded px-4 py-2"
            placeholder="Please Enter Your Name"
            value={form.name}
            onChange={handleChange}
          />
        </div>
        {/* Address */}
        <div className="flex items-center mb-4">
          <label className="w-40">Address</label>
          <input
            type="text"
            className="flex-1 border rounded px-4 py-2"
            placeholder="Please Enter Your Current Address"
            value={form.address}
            onChange={handleChange}
          />
        </div>

        {/* Date Picker */}
        <div className="flex items-center mb-4">
          <label className="w-40">Birth Date</label>
          <input
            type="date"
            className="flex-1 border rounded px-4 py-2"
            value={form.dob}
            onChange={handleChange}
          />
        </div>

        {/* Enum Dropdown */}
        <div className="flex items-center mb-8">
          <label className="w-40">Stages</label>
          <select className="flex-1 border rounded px-4 py-2">
            <option value="">Select...</option>
            <option value="enum1">Seed</option>
            <option value="enum2">Nurture</option>
            <option value="enum2">Lead</option>
            <option value="enum2">Opportunity</option>
            <option value="enum2">Active</option>
            <option value="enum2">Loyal</option>
          </select>
        </div>

        {/* Buttons */}
        <div className="flex justify-center gap-8">
          <button
            type="submit"
            className="w-24 h-24 rounded-full bg-blue-500 text-white font-bold"
          >{initialData ? "Update" : "Create"}
          </button>
          <Link to={"/"}>
            <button
                type="button"
                className="w-24 h-24 rounded-full bg-gray-300 text-black font-bold"
            >
                Cancel
            </button>
          </Link>
        </div>
      </form>
    </div>
  );
}

export default CustomerForm;