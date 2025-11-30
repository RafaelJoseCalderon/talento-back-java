import { useLoaderData, useSubmit } from "react-router";
import { Container } from "react-bootstrap";

import ProductFormAdmin from "../components/product_form_admin";

const ProductAdmin = ({ mode, title }) => {
  const { product, categories } = useLoaderData();
  const submit = useSubmit();

  const handleSubmit = (data) => {
    let payload = { ...data, id: product?.id || 0 };
    let method = "";

    if (mode === "create") method = "post";
    if (mode === "update") method = "put";

    return submit(payload, { method });
  };

  return (
    <Container className="my-5 position-relative">
      <h3 className="mb-3">{title} Producto</h3>

      <ProductFormAdmin
        mode={mode}
        values={product}
        valuesOptions={categories}
        handleSubmit={handleSubmit}
      />
    </Container>
  );
};

export default ProductAdmin;