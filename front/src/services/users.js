import { url_base } from "./config";
import { handleFetch } from "./tools";

const login = async ({ request }) => {
  const user = await request.json();

  const response = await handleFetch({
    url: `${url_base}/api/users/login`,
    options: {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(user)
    }
  });

  return { ...response, token: "fake-token" };
};

export { login };