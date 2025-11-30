import { Form, InputGroup, Button } from "react-bootstrap";

function QuantitySelector({value, onChange}) {
  const handleDecrement = () => {
    onChange(prevQuantity => Math.max(1, prevQuantity - 1));
  };

  const handleIncrement = () => {
    onChange(prevQuantity => prevQuantity + 1);
  };

  const handleChange = (event) => {
    const value = parseInt(event.target.value, 10);

    if (!isNaN(value) && value >= 1) {
      onChange(value);
    }
  };

  return (
    <InputGroup className="my-2 mx-auto">
      <Button
        variant="outline-secondary"
        onClick={handleDecrement}
        disabled={value <= 1}
      >
        -
      </Button>

      <Form.Control
        type="number"
        value={value}
        onChange={handleChange}
        min="1"
        style={{ textAlign: 'center' }}
      />

      <Button
        variant="outline-secondary"
        onClick={handleIncrement}
      >
        +
      </Button>
    </InputGroup>
  );
}

export default QuantitySelector;