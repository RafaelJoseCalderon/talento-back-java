import { useEffect, useRef } from "react";
import { useActionData, useSubmit } from "react-router";

export const useAsyncSubmit = () => {
  const submit_h = useSubmit();
  const data = useActionData();
  const resolveRef = useRef(null);

  useEffect(() => {
    if (data && resolveRef.current) {
      resolveRef.current(data);
      resolveRef.current = null;
    }
  }, [data]);

  async function submit_f(data, options) {
    return new Promise((resolve) => {
      resolveRef.current = resolve;
      submit_h(data, options);
    });
  }

  return { submit: submit_f, data };

};