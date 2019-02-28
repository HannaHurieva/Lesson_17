package kitchen;

import java.util.HashMap;
import java.util.Map;

public class Kitchen {
    /* Паттерн Одиночка — это порождающий паттерн проектирования,
который гарантирует, что у класса есть только один экземпляр,
и предоставляет к нему глобальную точку доступа.
*/

    private static Kitchen instance;

    /* Cкрываем конструктор по умолчанию и создаем публичный статический метод,
 который и будет контролировать жизненный цикл объекта-одиночки.

    Одиночка (Singleton) определяет статический метод getInstance,
  который возвращает единственный экземпляр своего класса.
 */
    public static Kitchen getInstance() {
        return instance;
    }

    private Map<String, Day> days = new HashMap<>();

    public Kitchen(Map<String, Day> days) {
        if (instance != null) throw new RuntimeException("Алло! кухня одна!");
        this.days = days;
        instance = this;
    }

    public Map<String, Day> getDays() {
        return days;
    }

}
