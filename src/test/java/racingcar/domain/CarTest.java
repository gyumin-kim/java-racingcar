package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final String NAME = "car";
    private static final int INITIAL_POSITION = 2;

    @DisplayName("Car 객체의 getName() 테스트")
    @Test
    public void getName() {
        // given
        Car car = new Car(NAME, INITIAL_POSITION);

        // when
        String name = car.getName();

        // then
        assertThat(name).isEqualTo(NAME);
    }

    @DisplayName("Car 객체의 getLocation() 테스트")
    @Test
    public void getLocation() {
        // given
        Car car = new Car(NAME, INITIAL_POSITION);

        // when
        int location = car.getLocation();

        // then
        assertThat(location).isEqualTo(INITIAL_POSITION);
    }

    @DisplayName("앞으로 전진하는 조건을 주입 받은 경우, moveOrStay 호출 시 위치값 증가")
    @Test
    public void playWithMove() {
        // given
        Car car = new Car(NAME, INITIAL_POSITION);
        MovementCondition movementCondition = new AllForwardMovementCondition();

        // when
        car.moveOrStay(movementCondition);

        // then
        int location = car.getLocation();
        assertThat(location).isEqualTo(INITIAL_POSITION + 1);
    }

    @DisplayName("제자리에 머무르는 조건을 주입 받은 경우, moveOrStay 호출 시 위치값 변화 없음")
    @Test
    public void playWithoutMove() {
        // given
        Car car = new Car(NAME, INITIAL_POSITION);
        MovementCondition movementCondition = new AllStayMovementCondition();

        // when
        car.moveOrStay(movementCondition);

        // then
        int location = car.getLocation();
        assertThat(location).isEqualTo(INITIAL_POSITION);
    }
}

