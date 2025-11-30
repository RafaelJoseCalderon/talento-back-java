import { useState } from "react";

export const useForm = ({ initialValues, rules }) => {
  const [values, setValues] = useState(initialValues);
  const [errors, setErrors] = useState({});

  const isValid = () => {
    const newErrors = validate();
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = ({ name, value }) => {
    setValues(prev => ({ ...prev, [name]: value }));
    setErrors(prev => ({ ...prev, [name]: false }));
  };

  const handleBlur = ({ name, value }) => {
    setErrors(prev => ({ ...prev, [name]: rules[name]?.(value) }));
  };

  const validate = () => {
    const newErrors = Object.entries(rules).reduce((acc, [key, validate]) => {
      const error = validate?.(values[key]);
      if (error) acc[key] = true;
      return acc;
    }, {});

    setErrors(newErrors);
    return newErrors;
  };

  const reset = () => {
    setValues(initialValues);
  };

  const annular = () => {
    setValues({});
  };

  return {
    values,
    errors,
    isValid,

    setValues,
    setErrors,

    handleChange,
    handleBlur,
    validate,
    reset,
    annular,
  };
};