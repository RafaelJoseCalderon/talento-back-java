import { Card, Button } from "react-bootstrap";
import SafeImage from "./safe_image";

const CartList = ({ items, remove }) => {
  return (<>
    {items.map(item =>
      <Card key={item.id} className="cart">
        <Card.Img as={SafeImage} variant="left" image={item.image} />

        <Card.Body>
          <Card.Text>{item.title}</Card.Text>
          <Card.Text>${((item.price / 100) * item.quantity).toFixed(2)}</Card.Text>
        </Card.Body>

        <Button variant="danger" onClick={() => remove(item.id)}>
          <i className="bi bi-trash"></i>
        </Button>
      </Card>
    )}
  </>);
};

export default CartList;