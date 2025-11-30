import { useState } from "react";
import { useForm } from "../hooks/use_form";
import { useNotification } from "../hooks/use_notification";

import { Container, Row, Col, Form, Button } from "react-bootstrap";
import Dialog from "../utils/dialog";

const Contact = () => {
  const [show, setShow] = useState(false);
  const { success } = useNotification();

  const form = useForm({
    initialValues: {
      name: "",
      email: "",
      subject: "",
      message: ""
    },
    rules: {
      name: (value) => !value.trim(),
      email: (value) => !value.trim(),
      subject: (value) => !value.trim(),
      message: (value) => !value.trim() || value.length < 10,
    }
  });

  const handleChange = ({ target: { name, value } }) => {
    form.handleChange({ name, value });
  };

  const handleBlur = ({ target: { name, value } }) => {
    form.handleBlur({ name, value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (form.isValid()) {
      setShow(true);
    }
  };

  const closeModal = () => {
    setShow(false);
    form.reset();
    success("¡Mensaje enviado con éxito!");
  };

  return (
    <Container className="my-5">
      <Row className="justify-content-md-center">
        <Col>
          <h2 className="mb-4 text-center">Contáctanos</h2>
          <Form onSubmit={handleSubmit} noValidate>
            <Form.Group className="mb-3">
              <Form.Label>Nombre</Form.Label>
              <Form.Control
                type="text"
                name="name"
                value={form.values?.name}
                isInvalid={form.errors?.name}
                onChange={handleChange}
                onBlur={handleBlur}
              />
              <Form.Control.Feedback type="invalid">
                Su nombre es obligatorio
              </Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Email</Form.Label>
              <Form.Control
                type="email"
                name="email"
                value={form.values?.email}
                isInvalid={form.errors?.email}
                onChange={handleChange}
                onBlur={handleBlur}
              />
              <Form.Control.Feedback type="invalid">
                Su correo electrónico es obligatorio
              </Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Asunto</Form.Label>
              <Form.Control
                type="text"
                name="subject"
                value={form.values?.subject}
                isInvalid={form.errors?.subject}
                onChange={handleChange}
                onBlur={handleBlur}
              />
              <Form.Control.Feedback type="invalid">
                El asunto es obligatorio
              </Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Mensaje</Form.Label>
              <Form.Control
                as="textarea"
                name="message"
                rows={4}
                value={form.values?.message}
                isInvalid={form.errors?.message}
                onChange={handleChange}
                onBlur={handleBlur}
              />
              <Form.Control.Feedback type="invalid">
                El mensaje debe tener al menos 10 caracteres
              </Form.Control.Feedback>
            </Form.Group>

            <div className="text-center">
              <Button variant="primary" type="submit">
                Enviar mensaje
              </Button>
            </div>
          </Form>
        </Col>
      </Row>

      <Dialog.ModalBase show={show} close={closeModal}>
        <Dialog.Title>Formulario enviado</Dialog.Title>
        <Dialog.Body>
          <p>Nombre: {form.values.name}</p>
          <p>Email: {form.values.email}</p>
          <p>Asunto: {form.values.subject}</p>
          <p>Mensaje: {form.values.message}</p>
        </Dialog.Body>
        <Dialog.CloseBase close={closeModal}>Cerrar</Dialog.CloseBase>
      </Dialog.ModalBase>

    </Container>
  );
};

export default Contact;