import { Spinner } from "react-bootstrap";

const Overlay = ({ message }) => {
  return (
    <div className="overlay__">
      <Spinner className="spinner__" animation="border" role="status" />
      <span>{message}</span>
    </div>
  );
};

export default Overlay;