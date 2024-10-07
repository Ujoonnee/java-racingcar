package race;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String[] names) {
        validateCount(names);

        List<Car> entry = new ArrayList<>();
        for (String name : names) {
            checkDuplicate(entry, name);
            entry.add(new Car(name));
        }

        this.cars = entry;
    }

    public Cars(Car... cars) {
        this.cars = List.of(cars);
    }

    private static void validateCount(String[] names) {
        if (names.length > 10) {
            throw new IllegalArgumentException("자동차 수는 1 ~ 10대 사이로 설정해야 합니다.");
        }
    }

    private void checkDuplicate(List<Car> entry, String name) {
        entry.stream()
                .filter(car -> name.equals(car.getName()))
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalStateException("동일한 자동차 이름을 사용할 수 없습니다. : "+ car.getName());
                });
    }

    public void move() {
        Random random = new Random();
        cars.forEach(car -> car.accelerate(random.nextInt(10)));
    }

    public Map<String, Integer> getPositions() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getPosition
                ));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
