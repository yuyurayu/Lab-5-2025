package functions;

import functions.meta.*;

// Вспомогательный класс со статическими методами для создания комбинаций функций
// Конструктор приватный, чтобы нельзя было создать экземпляр класса
public class Functions {

    // Приватный конструктор предотвращает создание экземпляров
    private Functions() {
        throw new UnsupportedOperationException("Нельзя создать экземпляр класса Functions");
    }

    // Метод для создания сдвинутой функции
    public static Function shift(Function f, double shiftX, double shiftY) {
        return new Shift(f, shiftX, shiftY);
    }

    // Метод для создания масштабированной функции
    public static Function scale(Function f, double scaleX, double scaleY) {
        return new Scale(f, scaleX, scaleY);
    }

    // Метод для создания функции в степени
    public static Function power(Function f, double power) {
        return new Power(f, power);
    }

    // Метод для создания суммы двух функций
    public static Function sum(Function f1, Function f2) {
        return new Sum(f1, f2);
    }

    // Метод для создания произведения двух функций
    public static Function mult(Function f1, Function f2) {
        return new Mult(f1, f2);
    }

    // Метод для создания композиции двух функций
    public static Function composition(Function f1, Function f2) {
        return new Composition(f1, f2);
    }
}