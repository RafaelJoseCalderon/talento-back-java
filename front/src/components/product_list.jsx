import { useNavigate } from "react-router";
import { useAddToCart } from "../hooks/use_add_to_cart";

import { Col, Card, Row } from "react-bootstrap";
import ProductActions from "./product_actions";
import SafeImage from "./safe_image";
import NotItems from "./not_items";

const ProductsList = ({ products }) => {
  const { addItem } = useAddToCart();
  const navigate = useNavigate();

  const moreDetails = (product) => {
    navigate(`/product/${product.id}`);
  };

  return (<>
    {(!products || products?.length === 0)
      ? <NotItems />
      : <Row className="product_list g-3 mt-2">
        {products.map(product => (
          <Col key={product.id} xs={12} md={6} lg={4}>
            <Card className="product-card">
              <Card.Img as={SafeImage} variant="top" image={product?.image} />
              <Card.Body>
                <Card.Title>{product.title.length > 45
                  ? `${product.title.substring(0, 45)}...`
                  : product.title
                }</Card.Title>

                <Card.Text>
                  <strong>Precio:</strong> ${product.price} <br />
                  <strong>Stock:</strong> ${product.stock}
                </Card.Text>

                <ProductActions product={product} moreDetails={moreDetails} addToCart={addItem} />
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    }
  </>);
};

export default ProductsList;