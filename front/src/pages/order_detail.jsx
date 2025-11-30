import { Table, Card, Container } from "react-bootstrap";
import { useLoaderData } from "react-router";

const OrderDetail = () => {
  const order = useLoaderData();

  return (
    <Container className="my-5">
      <Card>
        <Card.Body>
          <Card.Title>Orden #{order.id}</Card.Title>

          <p>
            <strong>Fecha de creación:</strong>{" "}
            {new Date(order.creationDate).toLocaleString()}
          </p>
          <p>
            <strong>Total:</strong> ${order.total.toFixed(2)}
          </p>

          <h5 className="mt-4">Items de la orden</h5>

          {/* tabla completamente responsiva */}
          <div className="table-responsive mt-3">
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>Título</th>
                  <th>Precio</th>
                  <th>Cantidad</th>
                  <th>Subtotal</th>
                </tr>
              </thead>
              <tbody>
                {order.orderItems.map(item => (
                  <tr key={item.id}>
                    <td>{item.title}</td>
                    <td>${item.price}</td>
                    <td>{item.quantity}</td>
                    <td><strong>${item.total}</strong></td>
                  </tr>
                ))}
              </tbody>
            </Table>
          </div>

        </Card.Body>
      </Card>
    </Container>
  );
};

export default OrderDetail;