package pro.softlar.crm.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Первый REST-контроллер.
 *
 * @RestController = @Controller + @ResponseBody:
 *   объект, который вернёт метод, Spring автоматически превратит в JSON.
 * @RequestMapping("/api") — общий префикс для всех путей внутри класса.
 */
@RestController
@RequestMapping("/api")
public class HealthController {

    // GET http://localhost:8080/api/health
    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of(
                "status", "UP",
                "service", "zon-crm",
                "time", LocalDateTime.now().toString()
        );
    }

    // GET http://localhost:8080/api/hello?name=Akbar
    // @RequestParam достаёт значение из query-строки.
    // defaultValue используется, если параметр не передан.
    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "мир") String name) {
        return "Привет, " + name + "!";
    }
}
