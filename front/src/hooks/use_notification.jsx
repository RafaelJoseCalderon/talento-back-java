import { notification } from "../utils/notification";

export const useNotification = () => {
  const primary = notification.primary;
  const secondary = notification.secondary;
  const success = notification.success;
  const danger = notification.danger;
  const warning = notification.warning;
  const info = notification.info;
  const light = notification.light;
  const dark = notification.dark;

  return {
    primary,
    secondary,
    success,
    danger,
    warning,
    info,
    light,
    dark,
  };
};