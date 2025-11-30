const dispatchNotification = (type, message) => {
  window.dispatchEvent(new CustomEvent("notification", {
    detail: { type, message },
  }));
};

export const notification = {
  primary: (message) => dispatchNotification("primary", message),
  secondary: (message) => dispatchNotification("secondary", message),
  success: (message) => dispatchNotification("success", message),
  danger: (message) => dispatchNotification("danger", message),
  warning: (message) => dispatchNotification("warning", message),
  info: (message) => dispatchNotification("info", message),
  light: (message) => dispatchNotification("light", message),
  dark: (message) => dispatchNotification("dark", message),
};