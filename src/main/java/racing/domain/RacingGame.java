package racing.domain;

import racing.util.Finder;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final int tryCount;


    public RacingGame(List<String> names, int tryCount) {
        this.cars = createCars(names);
        this.tryCount = tryCount;
    }

    private Cars createCars(List<String> names) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : names) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public void move() {
        cars.updateCarsState();
    }

    public String findWinners(){
        int winnerStep = Finder.findMaxStep(cars);
        return String.join(", ",cars.findWinner(winnerStep));
    }

    public Cars getCars() {
        return cars;
    }
    public int getTryCount() {
        return tryCount;
    }
}
