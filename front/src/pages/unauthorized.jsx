import { Container, Row, Col, Button } from "react-bootstrap";
import { Link } from "react-router";

const Unauthorized = () => {
  return (
    <Container fluid className="vh-100 d-flex justify-content-center align-items-center bg-light">
      <Row>
        <Col className="text-center">
          <h1 className="display-1 text-danger">403</h1>
          <p className="fs-4 mb-4">Oops... No posee los permisos necesarios</p>
          <Button as={Link} to="/" variant="primary">
            Volver al inicio
          </Button>
        </Col>
      </Row>
    </Container>
  );
};

export default Unauthorized;