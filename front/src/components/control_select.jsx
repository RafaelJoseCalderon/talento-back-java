import { useEffect, useState } from "react";

const ControlSelect = (props) => {
  const [style, setStyle] = useState("form-select");
  const { name, value, defaultValue, options } = props;
  const { isInvalid, onChange, onBlur } = props;

  useEffect(() => {
    setStyle(isInvalid ? "form-select is-invalid" : "form-select");
  }, [isInvalid]);

  return (
    <select name={name} className={style} value={value} onChange={onChange} onBlur={onBlur}>
      <option value={defaultValue}>Abrir este menú de selección</option>
      {options.map((option) => (
        <option key={option.id} value={option.id}>{option.name}</option>
      ))}
    </select>
  );
};

export default ControlSelect;