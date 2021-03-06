package racingcar.view;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class KeyboardInput implements Input {
    private final Scanner scanner;

    public KeyboardInput(InputStream source) {
        this.scanner = new Scanner(source);
    }

    @Override
    public List<String> getCarNames() {
        // TODO: 중복된 이름이 존재하는 경우에 대한 예외 처리
        String carNames = scanner.nextLine();
        return InputParser.parseCarNames(carNames);
    }

    @Override
    public int getRounds() {
        return Integer.parseInt(scanner.nextLine());
    }
}
