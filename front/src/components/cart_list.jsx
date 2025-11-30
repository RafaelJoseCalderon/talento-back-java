import { Card, Button } from "react-bootstrap";
import SafeImage from "./safe_image";

const CartList = ({ items, remove }) => {
  return (<>
    {items.map(item =>
      <Card key={item.product.id} className="cart">
        <Card.Img as={SafeImage} variant="left" image={item.product.image} />

        <Card.Body>
          <Card.Text>{item.product.title}</Card.Text>
          <Card.Text>${(item.product.price * item.quantity).toFixed(2)}</Card.Text>
        </Card.Body>

        <Button variant="danger" onClick={() => remove(item.product.id)}>
          <i className="bi bi-trash"></i>
        </Button>
      </Card>
    )}
  </>);
};

export default CartList;