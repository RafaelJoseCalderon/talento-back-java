import { Container, Row, Col, Button } from "react-bootstrap";
import { Link } from "react-router";

const NotFound = () => {
  return (
    <Container fluid className="vh-100 d-flex justify-content-center align-items-center bg-light">
      <Row>
        <Col className="text-center">
          <h1 className="display-1 text-danger">404</h1>
          <p className="fs-4 mb-4">Oops... Página no encontrada</p>
          <Button as={Link} to="/" variant="primary">
            Volver al inicio
          </Button>
        </Col>
      </Row>
    </Container>
  );
};

export default NotFound;