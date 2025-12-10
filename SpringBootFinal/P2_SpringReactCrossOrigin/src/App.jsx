import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import AddProduct from "./components/AddProduct";
import Categories from "./components/Categories";
import Products from "./components/Products";
import "./App.css";

function App() {
  return (
    <Router>
      <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container">
          <Link className="navbar-brand" to="/">Product App</Link>

          <div className="collapse navbar-collapse">
            <ul className="navbar-nav ms-auto">
              <li className="nav-item">
                <Link className="nav-link" to="/categories">Categories</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/products">Products</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/addproduct">Add Product</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<h3>Welcome to Product Management System</h3>} />
          <Route path="/categories" element={<Categories />} />
          <Route path="/products" element={<Products />} />
          <Route path="/addproduct" element={<AddProduct />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
