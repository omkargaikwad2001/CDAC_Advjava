import { useEffect, useState } from "react";

function Categories() {

  const [categories, setCategories] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/category/all")
      .then(res => res.json())
      .then(data => setCategories(data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div className="card shadow">
      <div className="card-header bg-primary text-white">
        <h4 className="m-0">Categories</h4>
      </div>

      <div className="card-body p-0">
        <table className="table table-striped table-bordered m-0">
          <thead className="table-light">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Description</th>
              <th># Products</th>
            </tr>
          </thead>
          <tbody>
            {categories.map((category, i) => (
              <tr key={i}>
                <td>{category.c_id}</td>
                <td>{category.c_name}</td>
                <td>{category.c_description}</td>
                <td>{category.products?.length || 0}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
export default Categories;
