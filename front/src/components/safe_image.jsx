import { useState } from "react";
import Image from "react-bootstrap/Image";

const SafeImage = ({ image, ...props }) => {
  const [imgSrc, setImgSrc] = useState(
    image || "/not_found_img.svg"
  );

  return (
    <Image
      {...props}
      src={imgSrc}
      onError={() => { setImgSrc("/not_found_img.svg"); }}
      alt={image || 'Imagen alternativa'}
    />
  );
};

export default SafeImage;