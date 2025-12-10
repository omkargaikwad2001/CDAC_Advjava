import { useEffect, useState } from "react";

export default function AddProduct() {
  const [categories, setCategories] = useState([]);
  const [product, setProduct] = useState({
    p_name: "",
    p_description: "",
    p_price: "",
    cat_id: ""
  });

  useEffect(() => {
    fetch("http://localhost:8080/category/all")
      .then(res => res.json())
      .then(data => setCategories(data))
      .catch(err => console.error("Error fetching categories", err));
  }, []);

  const handleChange = (e) => {
    setProduct({ ...product, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch("http://localhost:8080/product/savewithmaster", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(product)
    })
      .then(res => res.json())
      .then(data => {
        console.log("Saved:", data);
        alert("Product Added Successfully!");
      })
      .catch(err => console.error("Save Error:", err));
  };

  return (
    <div className="container mt-4">
      <div className="card p-4 shadow">
        <h3 className="mb-3 text-primary">Add Product</h3>

        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Product Name</label>
            <input
              type="text"
              name="p_name"
              className="form-control"
              onChange={handleChange}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Description</label>
            <textarea
              name="p_description"
              className="form-control"
              onChange={handleChange}
              required
            ></textarea>
          </div>

          <div className="mb-3">
            <label className="form-label">Price</label>
            <input
              type="number"
              name="p_price"
              className="form-control"
              onChange={handleChange}
              required
            />
          </div>

          {/* Category Dropdown */}
          <div className="mb-3">
            <label className="form-label">Category</label>
            <select
              name="cat_id"
              className="form-select"
              onChange={handleChange}
              required
            >
              <option value="">Select Category</option>
              {categories.map(cat => (
                <option key={cat.c_id} value={cat.c_id}>
                  {cat.c_name}
                </option>
              ))}
            </select>
          </div>

          <button type="submit" className="btn btn-primary w-100">
            Save Product
          </button>
        </form>
      </div>
    </div>
  );
}
