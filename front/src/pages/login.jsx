import { useAuth } from "../hooks/use_auth";
import { useForm } from "../hooks/use_form";
import { useAsyncSubmit } from "../hooks/use_async_submit";

import { Container, Form, Button, Card } from "react-bootstrap";

const Login = () => {
  const { signIn } = useAuth();
  const { submit } = useAsyncSubmit();

  const form = useForm({
    initialValues: {
      username: "",
      password: "",
    },
    rules: {
      username: (value) => !value.trim(),
      password: (value) => !value.trim(),
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
      submit(
        { ...form.values },
        { method: "put", encType: "application/json" }
      ).then(r => { signIn(r) });
    }
  };

  return (
    <Container className="login">
      <Card>
        <div className="icon"><i className="bi bi-person"></i></div>
        <h2 className="mb-4 text-center">Iniciar sesión</h2>

        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formName" className="mb-3">
            <Form.Label>Nombre</Form.Label>
            <Form.Control
              type="text"
              name="username"
              value={form.values?.username}
              isInvalid={form.errors?.username}
              onChange={handleChange}
              onBlur={handleBlur}
            />
            <Form.Control.Feedback type="invalid">
              Su nombre es obligatorio
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group controlId="formEmail" className="mb-3">
            <Form.Label>Contraseña</Form.Label>
            <Form.Control
              type="password"
              name="password"
              value={form.values?.password}
              isInvalid={form.errors?.password}
              onChange={handleChange}
              onBlur={handleBlur}
            />
            <Form.Control.Feedback type="invalid">
              La contraseña es obligatorio
            </Form.Control.Feedback>
          </Form.Group>

          <div className="text-center">
            <Button variant="primary" type="submit">Entrar</Button>
          </div>
        </Form>
      </Card>
    </Container>
  );
};

export default Login;