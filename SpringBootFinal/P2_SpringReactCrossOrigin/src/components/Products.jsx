import { useEffect, useState } from "react";

function Products() {

  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/product/all")
      .then(res => res.json())
      .then(data => setProducts(data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div className="card shadow">
      <div className="card-header bg-success text-white">
        <h4 className="m-0">Products</h4>
      </div>

      <div className="card-body p-0">
        <table className="table table-striped table-bordered m-0">
          <thead className="table-light">
            <tr>
              <th>PID</th>
              <th>Name</th>
              <th>Description</th>
              <th>Price</th>
              <th>Cat ID</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product, i) => (
              <tr key={i}>
                <td>{product.p_id}</td>
                <td>{product.p_name}</td>
                <td>{product.p_description}</td>
                <td>{product.p_price}</td>
                <td>{product.category?.c_id || "No Category"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
export default Products;
