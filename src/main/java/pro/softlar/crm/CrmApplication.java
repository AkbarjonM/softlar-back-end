package pro.softlar.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка входа в приложение.
 *
 * @SpringBootApplication — это три аннотации в одной:
 *   1) @SpringBootConfiguration — класс является источником конфигурации;
 *   2) @EnableAutoConfiguration — Spring сам настроит то, что найдёт в classpath
 *      (например, увидел spring-boot-starter-web → поднял Tomcat на порту 8080);
 *   3) @ComponentScan — Spring просканирует пакет pro.softlar.crm и все вложенные,
 *      найдёт классы с @Component/@Service/@RestController и создаст их объекты.
 *
 * Важное правило: главный класс лежит в КОРНЕВОМ пакете (pro.softlar.crm).
 * Всё, что находится выше по дереву пакетов, Spring не увидит.
 */
@SpringBootApplication
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }
}
