import { useLocation } from "react-router-dom";
import CustomerForm from "../components/CustomerForm";

const UpdatePage = () => {
  const { state: customerData } = useLocation();

  const handleUpdate = (updatedData) => {
    // PUT to API
    console.log("Updating:", updatedData);
  };

  return <CustomerForm initialData={customerData} onSubmit={handleUpdate} />;
};

export default UpdatePage;