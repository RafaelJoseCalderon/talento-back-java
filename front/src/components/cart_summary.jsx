import { Card, Button } from "react-bootstrap";

const SummaryCart = ({ items, buy }) => {
  const summation = items.reduce((acc, item) => acc + item.product.price * item.quantity, 0);
  const total = summation.toFixed(2);

  return (
    <Card className="summary-cart">
      <Card.Body>
        <Card.Title>Resumen</Card.Title>
        <Card.Text>Total: <strong>${total}</strong></Card.Text>
        <Button variant="success" onClick={buy} disabled={items.length === 0}>
          Finalizar Compra
        </Button>
      </Card.Body>
    </Card>
  );
};

export default SummaryCart;