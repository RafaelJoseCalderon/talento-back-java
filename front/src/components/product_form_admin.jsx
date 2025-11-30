import { useForm } from "../hooks/use_form";
import { useNavigate } from "react-router";

import { Container, Row, Col, Form, Button, Card } from "react-bootstrap";

import SafeImage from "./safe_image";
import ControlSelect from "./control_select";

const ProductFormAdmin = ({ mode, values, valuesOptions, handleSubmit }) => {
  const navigate = useNavigate();

  const form = useForm({
    initialValues: {
      title: values?.title || "",
      price: values?.price || 0.0,
      stock: values?.stock || 0,
      description: values?.description || "",
      category: values?.category?.id || 0,
      image: values?.image || "",
    },
    rules: {
      title: (value) => !value.trim(),
      price: (value) => !value || isNaN(Number(value)) || Number(value) <= 0,
      description: (value) => !value.trim() || value?.length < 10,
      stock: (value) => !value || isNaN(Number(value)) || Number(value) <= 0,
      category: (value) => !value || isNaN(Number(value)) || Number(value) <= 0,
    }
  });

  const handleChange = ({ target: { name, value } }) => {
    form.handleChange({ name, value });
  };

  const handleBlur = ({ target: { name, value } }) => {
    form.handleBlur({ name, value });
  };

  const onSubmit = (event) => {
    event.preventDefault();

    if (form.isValid()) {
      handleSubmit(form.values);
      form.reset();
    };
  };

  return (
    <Container className="my-1">
      <Row className="justify-content-md-center">
        <Col md={4} className="pt-3">
          <Card className="my-3">
            <Card.Img as={SafeImage} variant="top" image={`${values?.image}`} />
          </Card>
        </Col>

        <Col md={8}>
          <Form onSubmit={onSubmit} noValidate>
            <fieldset disabled={mode === "view"}>
              <Form.Group className="mb-3">
                <Form.Label>Título</Form.Label>
                <Form.Control
                  type="text"
                  name="title"
                  value={form.values?.title}
                  isInvalid={form.errors?.title}
                  onChange={handleChange}
                  onBlur={handleBlur}
                />
                <Form.Control.Feedback type="invalid">
                  El nombre del producto es obligatorio
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Precio</Form.Label>
                <Form.Control
                  type="number"
                  name="price"
                  value={form.values?.price}
                  isInvalid={form.errors?.price}
                  onChange={handleChange}
                  onBlur={handleBlur}
                  step="1.00"
                  min="0"
                />
                <Form.Control.Feedback type="invalid">
                  El precio debe ser un numero valido mayor a cero
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Stock</Form.Label>
                <Form.Control
                  type="number"
                  name="stock"
                  value={form.values?.stock}
                  isInvalid={form.errors?.stock}
                  onChange={handleChange}
                  onBlur={handleBlur}
                  step="1"
                  min="0"
                />
                <Form.Control.Feedback type="invalid">
                  El precio debe ser un numero valido mayor a cero
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Descripción</Form.Label>
                <Form.Control
                  as="textarea"
                  rows={3}
                  name="description"
                  value={form.values?.description}
                  isInvalid={form.errors?.description}
                  onChange={handleChange}
                  onBlur={handleBlur}
                />
                <Form.Control.Feedback type="invalid">
                  La descripcion debe tener al menos 10 caracteres
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Categoría</Form.Label>
                <ControlSelect
                  name="category"
                  options={valuesOptions}
                  value={form.values?.category}
                  defaultValue="0"
                  isInvalid={form.errors?.category}
                  onChange={handleChange}
                  onBlur={handleBlur}
                />
                <Form.Control.Feedback type="invalid">
                  La categoria del producto es obligatoria
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Url de Imagen</Form.Label>
                <Form.Control
                  type="text"
                  name="image"
                  value={form.values?.image}
                  isInvalid={form.errors?.image}
                  onChange={handleChange}
                  onBlur={handleBlur}
                />
                <Form.Control.Feedback type="invalid">
                  La imagen debe ser 'jpeg' o 'png' y menor a 500KB
                </Form.Control.Feedback>
              </Form.Group>
            </fieldset>

            <div className="d-flex justify-content-center justify-content-md-end gap-2">
              <Button
                variant="secondary"
                className="w-25"
                onClick={() => navigate(-1)}
              >
                Atras
              </Button>

              <Button
                variant="success"
                className="w-25"
                type="submit"
                disabled={mode === "view"}
              >
                Guardar
              </Button>

            </div>
          </Form>
        </Col>

      </Row>
    </Container>
  );
};

export default ProductFormAdmin;