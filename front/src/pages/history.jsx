import { Link, useLoaderData } from "react-router";
import { Container, Row, Col, Card, Button } from "react-bootstrap";

const History = () => {
  const orders = useLoaderData();

  const mapDate = (stringDate) => {
    const fecha = new Date(stringDate);
    return fecha.toLocaleString("es-AR");
  }

  return (
    <Container className="my-5">
      <h2 className="mb-4">Historial de Compras</h2>

      <Row className="mt-2">
        <Col>
          {(!orders || orders?.length === 0) ? <NotItems /> :
            orders.map(order =>
              <Card key={order.id} className="history-item">
                <Col className="id">{order.id}</Col>
                <Col className="date">{mapDate(order.creationDate)}</Col>
                <Col className="total">{order.total} $</Col>
                <Col className="details">
                  <Link className="btn btn-info" to={`../details/${order.id}`}>
                    <i className="bi bi-info-circle"></i>
                  </Link>
                </Col>
              </Card>
            )
          }
        </Col>
      </Row>

    </Container>
  );
}

export default History;