import { useState, useEffect } from "react";

export const usePersistentState = (key, defaultValue) => {
  const [state, setState] = useState(() => {
    try {
      const storedValue = localStorage.getItem(key);
      return storedValue ? JSON.parse(storedValue) : defaultValue;
    } catch (error) {
      console.error("Error reading from localStorage:", error);
      return defaultValue;
    }
  });

  useEffect(() => {
    const isNonEmptyArray = Array.isArray(state) && state.length > 0;
    const isNonEmptyObject = !Array.isArray(state) && Object.keys(state).length > 0;

    if (state && (isNonEmptyArray || isNonEmptyObject)) {
      localStorage.setItem(key, JSON.stringify(state));
    } else {
      localStorage.removeItem(key);
    }
  }, [state, key]);

  return [state, setState];
};