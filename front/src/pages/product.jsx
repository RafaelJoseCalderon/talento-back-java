import { useState } from "react";
import { useLoaderData } from "react-router";
import { useAsyncSubmit } from "../hooks/use_async_submit";
import { useCart } from "../hooks/use_cart";

import { Container, Row, Col, Button, Badge } from "react-bootstrap";
import SafeImage from "../components/safe_image";
import QuantitySelector from "../components/quantity_selector";

const Product = () => {
  const [quantity, setQuantity] = useState(1);
  const product = useLoaderData();
  const { submit } = useAsyncSubmit();
  const { setCart } = useCart();

  const add = () => {
    if (quantity < product.stock) {
      submit(
        { productId: product.id, quantity, action: "add" },
        { method: 'post', encType: 'application/json' }
      ).then(r => setCart(r));
      setQuantity(1);
    } else {
      info("No hay stock suficiente");
    }
  }

  return (
    <Container className="product">
      {product &&
        <Row>
          <Col md={4} className="text-center">
            <SafeImage image={`${product?.image}`} />
          </Col>

          <Col md={8} className="d-flex flex-column justify-content-between">
            <div>
              <h2>{product.title}</h2>
              <h4 className="text-success mb-3">${product.price.toFixed(2)}</h4>
              <Badge bg="secondary" className="mb-2">{product.category.name}</Badge>
              <p className="mt-3">{product.description}</p>
              <p><strong>Rating:</strong> {product.rating.rate.toFixed(2)} ⭐ ({product.rating.count} opiniones)</p>
            </div>

            <div>
              <QuantitySelector value={quantity} onChange={setQuantity} />
              <Button className="w-100" onClick={add} variant="primary" size="lg">
                Agregar al carrito
              </Button>
            </div>
          </Col>
        </Row>
      }
    </Container>
  );
};

export default Product;