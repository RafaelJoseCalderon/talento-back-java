package org.talento.java.bootstrap;

import org.springframework.stereotype.Component;
import org.talento.java.models.Category;
import org.talento.java.models.Product;
import org.talento.java.repositories.ProductRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component(value = "InitProduct.beanName")
public class InitProduct extends BootstrapBase {
    private final ProductRepo productRepo;

    public InitProduct(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public String entityMessage() {
        return "products";
    }

    @Override
    public void load() {
        List<Category> categories = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Category category;
        Product product;

        // #############################################################################################################
        // 0 ###########################################################################################################
        category = new Category();
        category.setName("Ropa de hombre");
        categories.add(category);

        // 1 ###########################################################################################################
        category = new Category();
        category.setName("Joyería");
        categories.add(category);

        // 2 ###########################################################################################################
        category = new Category();
        category.setName("Electrónica");
        categories.add(category);

        // 3 ###########################################################################################################
        category = new Category();
        category.setName("Ropa de mujer");
        categories.add(category);

        // #############################################################################################################
        // 00 ##########################################################################################################
        product = new Product();
        product.setTitle("Fjallraven - Mochila Foldsack n.° 1, con capacidad para 15 portátiles");
        product.setPrice(BigDecimal.valueOf(109.95));
        product.setStock(100);
        product.setDescription(
            "Tu mochila perfecta para el día a día y tus paseos por el bosque. Guarda tu portátil (de hasta 15 " +
            "pulgadas) en la funda acolchada."
        );
        product.setCategory(categories.get(0));
        product.setImage("http://localhost:8080/media/public/81fPKd-2AYL._AC_SL1500_t.png");
        product.setRatingRate(3.9);
        product.setRatingCount(120);
        products.add(product);

        // 01 ##########################################################################################################
        product = new Product();
        product.setTitle("Camisetas informales premium de corte entallado para hombre");
        product.setPrice(BigDecimal.valueOf(22.3));
        product.setStock(100);
        product.setDescription(
            "Estilo entallado, manga larga raglán en contraste, tapeta henley de tres botones, tejido ligero y suave " +
            "para una mayor transpirabilidad y comodidad. Camisas con costuras sólidas y cuello redondo, resistentes " +
            "y con un ajuste perfecto para la moda casual y los fanáticos del béisbol.  El cuello redondo estilo " +
            "henley incluye una tapeta de tres botones."
        );
        product.setCategory(categories.get(0));
        product.setImage("http://localhost:8080/media/public/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png");
        product.setRatingRate(4.1);
        product.setRatingCount(259);
        products.add(product);

        // 02 ##########################################################################################################
        product = new Product();
        product.setTitle("Chaqueta de algodón para hombre");
        product.setPrice(BigDecimal.valueOf(55.99));
        product.setStock(100);
        product.setDescription(
            "Chaquetas de abrigo ideales para primavera, otoño e invierno,  ideales para diversas ocasiones, como " +
            "trabajar, hacer senderismo, acampar, escalar montañas, ciclismo, viajar o disfrutar de actividades " +
            "al aire libre. Una excelente opción de regalo para ti o un familiar. Un abrazo a papá, esposo o hijo en " +
            "este Día de Acción de Gracias o Navidad."
        );
        product.setCategory(categories.get(0));
        product.setImage("http://localhost:8080/media/public/71li-ujtlUL._AC_UX679_t.png");
        product.setRatingRate(4.7);
        product.setRatingCount(500);
        products.add(product);

        // 03 ##########################################################################################################
        product = new Product();
        product.setTitle("Corte ajustado informal para hombre");
        product.setPrice(BigDecimal.valueOf(15.99));
        product.setStock(100);
        product.setDescription(
            "El color puede variar ligeramente entre la imagen y la realidad. Tenga en cuenta que la complexión " +
            "física varía según la persona, por lo que se recomienda consultar la información detallada sobre la " +
            "talla en la descripción del producto."
        );
        product.setCategory(categories.get(0));
        product.setImage("http://localhost:8080/media/public/71YXzeOuslL._AC_UY879_t.png");
        product.setRatingRate(2.1);
        product.setRatingCount(430);
        products.add(product);

        // 04 ##########################################################################################################
        product = new Product();
        product.setTitle("Pulsera de cadena con dragón Naga de John Hardy Legends para mujer, de oro y plata");
        product.setPrice(BigDecimal.valueOf(695));
        product.setStock(100);
        product.setDescription(
            "De nuestra colección Legends, la Naga se inspiró en el mítico dragón de agua que protege la perla del " +
            "océano. Úsela hacia adentro para recibir amor y abundancia, o hacia afuera para protección."
        );
        product.setCategory(categories.get(1));
        product.setImage("http://localhost:8080/media/public/71pWzhdJNwL._AC_UL640_QL65_ML3_t.png");
        product.setRatingRate(4.6);
        product.setRatingCount(400);
        products.add(product);

        // 05 ##########################################################################################################
        product = new Product();
        product.setTitle("Micropavé Petite de Oro Sólido");
        product.setPrice(BigDecimal.valueOf(168));
        product.setStock(100);
        product.setDescription(
            "Satisfacción garantizada. Devolución o cambio de cualquier pedido en un plazo de 30 días. Diseñado y " +
            "vendido por Hafeez Center en Estados Unidos. Satisfacción garantizada. Devolución o cambio de cualquier " +
            "pedido en un plazo de 30 días."
        );
        product.setCategory(categories.get(1));
        product.setImage("http://localhost:8080/media/public/61sbMiUnoGL._AC_UL640_QL65_ML3_t.png");
        product.setRatingRate(3.9);
        product.setRatingCount(70);
        products.add(product);

        // 06 ##########################################################################################################
        product = new Product();
        product.setTitle("Princesa bañada en oro blanco");
        product.setPrice(BigDecimal.valueOf(9.99));
        product.setStock(100);
        product.setDescription(
            "Anillo de compromiso clásico con solitario de diamantes para ella. Regalos para consentir a tu pareja " +
            "en su compromiso, boda, aniversario, San Valentín..."
        );
        product.setCategory(categories.get(1));
        product.setImage("http://localhost:8080/media/public/71YAIFU48IL._AC_UL640_QL65_ML3_t.png");
        product.setRatingRate(3);
        product.setRatingCount(400);
        products.add(product);

        // 07 ##########################################################################################################
        product = new Product();
        product.setTitle("Búho perforado de acero inoxidable bañado en oro rosa doble");
        product.setPrice(BigDecimal.valueOf(10.99));
        product.setStock(100);
        product.setDescription(
            "Aretes de dilatación doble acampanados bañados en oro rosa. Fabricados en acero inoxidable 316L."
        );
        product.setCategory(categories.get(1));
        product.setImage("http://localhost:8080/media/public/51UDEzMJVpL._AC_UL640_QL65_ML3_t.png");
        product.setRatingRate(1.9);
        product.setRatingCount(100);
        products.add(product);

        // 08 ##########################################################################################################
        product = new Product();
        product.setTitle("Disco duro externo portátil WD Elements de 2 TB - USB 3.0");
        product.setPrice(BigDecimal.valueOf(64));
        product.setStock(100);
        product.setDescription(
            "Compatibilidad con USB 3.0 y USB 2.0. Transferencias de datos rápidas. Mejora el rendimiento del PC. " +
            "Alta capacidad. Compatible con NTFS formateado para Windows 10, Windows 8.1 y Windows 7. Puede ser " +
            "necesario reformatear para otros sistemas operativos. La compatibilidad puede variar según la " +
            "configuración de hardware y el sistema operativo del usuario."
        );
        product.setCategory(categories.get(2));
        product.setImage("http://localhost:8080/media/public/61IBBVJvSDL._AC_SY879_t.png");
        product.setRatingRate(3.3);
        product.setRatingCount(203);
        products.add(product);

        // 09 ##########################################################################################################
        product = new Product();
        product.setTitle("SSD interno SanDisk SSD PLUS de 1 TB - SATA III 6 Gb/s");
        product.setPrice(BigDecimal.valueOf(109));
        product.setStock(100);
        product.setDescription(
            "Fácil actualización para un arranque, apagado, carga de aplicaciones y respuesta más rápidos (en " +
            "comparación con un disco duro SATA de 2,5\" a 5400 RPM; basado en especificaciones publicadas y pruebas " +
            "de referencia internas con puntuaciones PCMark Vantage). Aumenta el rendimiento de escritura en ráfaga, " +
            "lo que lo hace ideal para cargas de trabajo típicas de PC. Equilibrio perfecto entre rendimiento y " +
            "fiabilidad. Velocidades de lectura/escritura de hasta 535 MB/s/450 MB/s (basado en pruebas internas; el " +
            "rendimiento puede variar según la capacidad del disco, el dispositivo host, el sistema operativo y la " +
            "aplicación)."
        );
        product.setCategory(categories.get(2));
        product.setImage("http://localhost:8080/media/public/61U7T1koQqL._AC_SX679_t.png");
        product.setRatingRate(2.9);
        product.setRatingCount(470);
        products.add(product);

        // 10 ##########################################################################################################
        product = new Product();
        product.setTitle("SSD Silicon Power de 256 GB con caché SLC 3D NAND A55 y mejora del rendimiento SATA III 2.5");
        product.setPrice(BigDecimal.valueOf(109));
        product.setStock(100);
        product.setDescription(
            "La memoria flash 3D NAND ofrece altas velocidades de transferencia que permiten un arranque más rápido " +
            "y un mejor rendimiento general del sistema. La avanzada tecnología de caché SLC optimiza el rendimiento " +
            "y prolonga la vida útil. Su diseño delgado de 7 mm es ideal para ultrabooks y portátiles ultradelgados. " +
            "Admite comandos TRIM, tecnología de recolección de elementos no utilizados, RAID y ECC (comprobación y " +
            "corrección de errores) para optimizar el rendimiento y mejorar la fiabilidad."
        );
        product.setCategory(categories.get(2));
        product.setImage("http://localhost:8080/media/public/71kWymZ+c+L._AC_SX679_t.png");
        product.setRatingRate(4.8);
        product.setRatingCount(319);
        products.add(product);

        // 11 ##########################################################################################################
        product = new Product();
        product.setTitle("Disco duro externo portátil WD Gaming de 4 TB compatible con PlayStation 4.");
        product.setPrice(BigDecimal.valueOf(114));
        product.setStock(100);
        product.setDescription(
            "Amplía tu experiencia de juego de PS4. Juega en cualquier lugar. Configuración rápida y sencilla. " +
            "Diseño elegante con gran capacidad. Garantía limitada del fabricante de 3 años."
        );
        product.setCategory(categories.get(2));
        product.setImage("http://localhost:8080/media/public/61mtL65D4cL._AC_SX679_t.png");
        product.setRatingRate(4.8);
        product.setRatingCount(400);
        products.add(product);

        // 12 ##########################################################################################################
        product = new Product();
        product.setTitle("Acer SB220Q bi 21.5 pulgadas Full HD (1920 x 1080) IPS Ultrafino.");
        product.setPrice(BigDecimal.valueOf(599));
        product.setStock(100);
        product.setDescription(
            "Pantalla IPS panorámica Full HD (1920 x 1080) de 21.5 pulgadas. Tecnología Radeon FreeSync. No " +
            "compatible con montaje VESA. Frecuencia de actualización: 75 Hz. Mediante puerto HDMI. Diseño sin marco " +
            "| Ultrafino | Tiempo de respuesta de 4 ms | Panel IPS. Relación de aspecto: 16:9. Color compatible: " +
            "16,7 millones de colores. Brillo: 250 nits. Ángulo de inclinación: de 5 a 15 grados. Ángulo de visión " +
            "horizontal: 178 grados. Ángulo de visión vertical: 178 grados, 75 Hz"
        );
        product.setCategory(categories.get(2));
        product.setImage("http://localhost:8080/media/public/81QpkIctqPL._AC_SX679_t.png");
        product.setRatingRate(2.9);
        product.setRatingCount(250);
        products.add(product);

        // 13 ##########################################################################################################
        product = new Product();
        product.setTitle("Monitor curvo para juegos Samsung CHG90 de 49 pulgadas y 144 Hz (LC49HG90DMNXZA)");
        product.setPrice(BigDecimal.valueOf(999.99));
        product.setStock(100);
        product.setDescription(
            "Monitor curvo para juegos de 49 pulgadas, súper ultraancho, 32:9, con pantalla dual de 27 pulgadas, una " +
            "al lado de la otra. Tecnología Quantum Dot (QLED), compatibilidad con HDR y calibración de fábrica " +
            "que proporciona un color y un contraste increíblemente realistas y precisos. Alta frecuencia de " +
            "actualización de 144 Hz y un tiempo de respuesta ultrarrápido de 1 ms que elimina el desenfoque de " +
            "movimiento, las imágenes fantasma y reduce el retraso de entrada."
        );
        product.setCategory(categories.get(2));
        product.setImage("http://localhost:8080/media/public/81Zt42ioCgL._AC_SX679_t.png");
        product.setRatingRate(2.2);
        product.setRatingCount(140);
        products.add(product);

        // 14 ##########################################################################################################
        product = new Product();
        product.setTitle("Chaqueta de snowboard 3 en 1 BIYLACLESEN para mujer.");
        product.setPrice(BigDecimal.valueOf(56.99));
        product.setStock(100);
        product.setDescription(
            "Nota: La talla de la chaqueta es estándar en EE. UU. Elige tu talla habitual. Material: 100 % " +
            "poliéster. Forro extraíble: forro polar cálido. Forro funcional desmontable: suave con la piel, ligero " +
            "y cálido. Chaqueta con cuello alto que te mantiene abrigada en climas fríos. Bolsillos con cremallera: " +
            "2 bolsillos laterales con cremallera, 2 bolsillos en el pecho con cremallera (suficientes para guardar " +
            "tarjetas o llaves) y 1 bolsillo interior oculto. Los bolsillos laterales con cremallera y el bolsillo " +
            "oculto mantienen tus pertenencias seguras. Diseño humanizado: Capucha ajustable y desmontable, puños " +
            "ajustables para protegerte del viento y el agua, para un ajuste cómodo. El diseño desmontable 3 en 1 " +
            "ofrece mayor comodidad: puedes separar el abrigo y la prenda interior según lo necesites o usarlos " +
            "juntos. Es adecuado para diferentes estaciones y te ayuda a adaptarte a diferentes climas."
        );
        product.setCategory(categories.get(3));
        product.setImage("http://localhost:8080/media/public/51Y5NI-I5jL._AC_UX679_t.png");
        product.setRatingRate(2.6);
        product.setRatingCount(235);
        products.add(product);

        // 15 ##########################################################################################################
        product = new Product();
        product.setTitle("Chaqueta de motociclista Lock and Love de piel sintética con capucha extraíble para mujer");
        product.setPrice(BigDecimal.valueOf(29.95));
        product.setStock(100);
        product.setDescription(
            "100 % POLIURETANO (exterior), 100 % POLIÉSTER (forro), 75 % POLIÉSTER, 25 % ALGODÓN (suéter). Material " +
            "de piel sintética para mayor estilo y comodidad. Dos bolsillos delanteros. Chaqueta de piel sintética " +
            "estilo vaquero con capucha, dos por uno. Detalle de botones en la cintura. Costuras laterales. Lavar " +
            "solo a mano. No usar lejía. Secar al aire libre. No planchar."
        );
        product.setCategory(categories.get(3));
        product.setImage("http://localhost:8080/media/public/81XH0e8fefL._AC_UY879_t.png");
        product.setRatingRate(2.9);
        product.setRatingCount(340);
        products.add(product);

        // 16 ##########################################################################################################
        product = new Product();
        product.setTitle("Chaqueta impermeable a rayas para mujer.");
        product.setPrice(BigDecimal.valueOf(39.99));
        product.setStock(100);
        product.setDescription(
            "Ligera, ideal para viajes o para uso casual. Manga larga con capucha y cintura con cordón ajustable. " +
            "Cierre frontal con botones y cremallera. Forro completo a rayas. Tiene dos bolsillos laterales de buen " +
            "tamaño para guardar todo tipo de cosas. Cubre las caderas. La capucha es amplia pero no excesiva. La " +
             "capucha forrada de algodón con cordones ajustables le da un aspecto elegante."
        );
        product.setCategory(categories.get(3));
        product.setImage("http://localhost:8080/media/public/71HblAHs5xL._AC_UY879_-2t.png");
        product.setRatingRate(3.8);
        product.setRatingCount(679);
        products.add(product);

        // 17 ##########################################################################################################
        product = new Product();
        product.setTitle("Camiseta MBJ de manga corta lisa con cuello barco en V para mujer");
        product.setPrice(BigDecimal.valueOf(9.85));
        product.setStock(100);
        product.setDescription(
            "95 % rayón, 5 % elastano, fabricada en EE. UU. o importada, no usar lejía, tejido ligero con gran " +
            "elasticidad para mayor comodidad, ribete acanalado en mangas y escote / doble costura en el dobladillo " +
            "inferior."
        );
        product.setCategory(categories.get(3));
        product.setImage("http://localhost:8080/media/public/71z3kpMAYsL._AC_UY879_t.png");
        product.setRatingRate(4.7);
        product.setRatingCount(130);
        products.add(product);

        // 18 ##########################################################################################################
        product = new Product();
        product.setTitle("Camiseta Opna de manga corta para mujer");
        product.setPrice(BigDecimal.valueOf(7.95));
        product.setStock(100);
        product.setDescription(
            "100 % poliéster, lavable a máquina, 100 % poliéster interlock catiónico, lavable a máquina y " +
            "preencogido para un ajuste perfecto. Ligera, holgada y muy transpirable, con tejido que absorbe la " +
            "humedad y la mantiene alejada. Tejido suave y ligero con cómodo cuello en V y un corte entallado que " +
            "ofrece una silueta elegante y femenina, además de mayor comodidad."
        );
        product.setCategory(categories.get(3));
        product.setImage("http://localhost:8080/media/public/51eg55uWmdL._AC_UX679_t.png");
        product.setRatingRate(4.5);
        product.setRatingCount(146);
        products.add(product);

        // 19 ##########################################################################################################
        product = new Product();
        product.setTitle("Camiseta DANVOUY de algodón para mujer");
        product.setPrice(BigDecimal.valueOf(12.99));
        product.setStock(100);
        product.setDescription(
            "95 % algodón, 5 % elastano, características: informal, manga corta, estampado de letras, cuello en V, " +
            "camisetas de moda. Tejido suave y elástico. Ocasión: informal, oficina, playa, escuela, casa, calle. " +
            "Temporada: Primavera, Verano, Otoño, Invierno."
        );
        product.setCategory(categories.get(3));
        product.setImage("http://localhost:8080/media/public/61pHAEJ4NML._AC_UX679_t.png");
        product.setRatingRate(3.6);
        product.setRatingCount(145);
        products.add(product);

        this.productRepo.saveAll(products);
    }
}
