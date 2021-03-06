package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

import static racingcar.view.InputMessages.*;

public class GameController {
    private final Input input;
    private final Output output;

    public GameController(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        List<String> carNames = getCarNames();
        int rounds = getRounds();
        RacingGame game = new RacingGame(carNames, rounds);
        play(game);
    }

    private List<String> getCarNames() {
        output.println(ENTER_CAR_NAMES);
        return input.getCarNames();
    }

    private int getRounds() {
        output.println(ENTER_ROUNDS);
        int rounds = 0;
        boolean isCorrectInput = false;
        while (!isCorrectInput) {
            try {
                rounds = input.getRounds();
                isCorrectInput = true;
            } catch (NumberFormatException exception) {
                output.println(ROUNDS_MUST_BE_NUMERIC);
            }
        }
        return rounds;
    }

    private void play(final RacingGame game) {
        output.startPrintingGameResult();
        while (!game.ends()) {
            game.playOneRound();
            output.printThisRound(game.getCars());
        }
        output.printWinners(game.getWinners());
    }
}
