import { useEffect, useState } from "react";
import { Alert } from "react-bootstrap";

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
      <Alert
        variant={type}
        className="m-0"
        onClose={() => remove(id)}
        dismissible
      >
        {message}
      </Alert>
    </div>
  );
};

export default Notification;