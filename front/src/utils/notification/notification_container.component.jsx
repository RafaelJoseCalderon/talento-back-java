import { useState, useEffect, useCallback } from "react";
import Notification from "./notification_alert.component";

const NotificationContainer = () => {
  const [messages, setMessages] = useState([]);

  const add = useCallback(({ detail: { type, message } }) => {
    setMessages((prev) => [...prev, {
      id: Date.now(), type, message,
    }]);
  }, []);

  const remove = useCallback((id) => {
    setMessages((prev) => prev.filter((msg) => msg.id !== id));
  }, []);

  useEffect(() => {
    window.addEventListener("notification", add);

    return () => {
      window.removeEventListener("notification", add);
    };
  }, []);

  return (
    <div className="w-100 z-3 p-1 px-4">
      {messages.map((msg) => (
        <Notification key={msg.id} {...msg} remove={remove} />
      ))}
    </div>
  );
};

export default NotificationContainer;