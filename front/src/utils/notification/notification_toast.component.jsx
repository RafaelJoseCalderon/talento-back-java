import { useEffect, useState } from "react";
import { Toast } from "react-bootstrap";

const Notification = ({ id, type, message, duration = 2000, remove }) => {
  const [className, setClassName] = useState("notification");

  useEffect(() => {
    const enteringTimer = setTimeout(() => {
      setClassName("notification entering");
    }, 100);

    const exitingTimer = setTimeout(() => {
      setClassName("notification exiting");
      setTimeout(() => remove(id), 500);
    }, duration);

    return () => {
      clearTimeout(enteringTimer);
      clearTimeout(exitingTimer);
    };
  }, [duration]);

  return (
    <div className={className}>
      <Toast
        bg={type}
        onClose={() => remove(id)}
        dismissible="true"
      >
        <Toast.Header>
          <strong className="me-auto">TiendaFerpecta</strong>
        </Toast.Header>

        <Toast.Body>{message}</Toast.Body>
      </Toast>
    </div>
  );
};

export default Notification;