import { Dice } from "./Dice";
import { Game } from "./Game";
import { Token } from "./Token";

describe('Game', () => {
    it('should be in the position 5 when the dice roll 4', () => {
      const dice = new Dice();
      const token = new Token();
      const game = new Game(token, dice);

      const rollSpy = jest.spyOn(dice, 'roll');

      rollSpy.mockReturnValue(4);
      game.play();
      expect(token.getPosition()).toBe(5);

    })
})