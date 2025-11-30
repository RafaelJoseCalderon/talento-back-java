import { Container, Row, Col, ListGroup } from "react-bootstrap";

const About = () => {
  return (
    <Container className="my-5">
      <Row>
        <Col>
          <h1>Acerca de Nosotros</h1>
          <p className="lead">
            En <strong>Tienda Ferpecta</strong>, creemos que comprar en línea debe ser simple, seguro y hasta divertido.
          </p>

          <h2>Nuestra Historia</h2>
          <p>
            Tienda Ferpecta nació en 2025 con una misión clara: ofrecer productos de calidad con un servicio excepcional. Desde entonces,
            hemos crecido gracias a la confianza de miles de clientes que buscan lo mejor sin pagar de más.
          </p>

          <h2>Lo Que Nos Hace Diferentes</h2>
          <ListGroup variant="flush">
            <ListGroup.Item>✔️ Calidad garantizada en cada producto</ListGroup.Item>
            <ListGroup.Item>✔️ Atención personalizada y cercana</ListGroup.Item>
            <ListGroup.Item>✔️ Precios justos y competitivos</ListGroup.Item>
            <ListGroup.Item>✔️ Envíos rápidos y seguimiento en tiempo real</ListGroup.Item>
          </ListGroup>

          <h2 className="mt-4">Comprometidos Contigo</h2>
          <p>
            En Tienda Ferpecta, no solo vendemos productos, construimos relaciones. Gracias por ser parte de nuestra comunidad.
            ¡Vamos por más!
          </p>
        </Col>
      </Row>
    </Container>
  );
};

export default About;