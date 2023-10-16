import { CanRoll } from './CanRoll'
import { FakeDice } from './FakeDice'
import { Game } from './Game'
import { Token } from './Token'

class IncrementalDiceResult implements CanRoll {
  private currentResult: number = 1

  constructor(startAt: number = 1) {
    this.currentResult = startAt
  }

  public roll(): number {
    const result = this.currentResult;
    this.currentResult++;
    return result;
  }
}

class DecrementalDiceResult implements CanRoll {
  private currentResult: number = 6

  constructor(startAt: number = 6) {
    this.currentResult = startAt
  }

  public roll(): number {
    const result = this.currentResult;
    this.currentResult--;
    return result;
  }
}

class CustomDiceResult implements CanRoll {
  private readonly customResult: (numOfRoll) => CanRoll
  private callCount: number = 0

  constructor(customResult: (numOfRoll) => CanRoll) {
    this.customResult = customResult
  }

  public roll(): number {
    return this.customResult(++this.callCount).roll()
  }
}

describe("Game", () => {
  it("should not start when players get same result at game start", () => {
    const token1 = new Token(1)
    const token2 = new Token(1)
    const game = new Game([token1, token2])
    const dice = new FakeDice(1)

    const board = game.determinePlayOrder(dice)

    expect(board).toBeUndefined()
  })


  it("should start with player 1 when gets the highest number at game start", () => {
    const token1 = new Token(1)
    const token2 = new Token(1)
    const game = new Game([token1, token2])
    const dice = new DecrementalDiceResult()

    const board = game.determinePlayOrder(dice)
    board.rollDice(new FakeDice(1))

    expect(token1.getPosition()).toBe(2)
    expect(token2.getPosition()).toBe(1)
  })

  it("should start with player 2 when gets the highest number at game start", () => {
    const token1 = new Token(1)
    const token2 = new Token(1)
    const game = new Game([token1, token2])
    const dice = new IncrementalDiceResult()

    const board = game.determinePlayOrder(dice)
    board.rollDice(new FakeDice(1))

    expect(token1.getPosition()).toBe(1)
    expect(token2.getPosition()).toBe(2)
  })

  it("should force to roll the dice again when there is a tie", () => {
    const token1 = new Token(1)
    const token2 = new Token(1)
    const token3 = new Token(1)
    const token4 = new Token(1)
    const game = new Game([token1, token2, token3, token4])
    const fakeDice = new FakeDice(1)
    const incrementDiceResult = new IncrementalDiceResult(2)
    const dice = new CustomDiceResult((numOfRoll) =>
      numOfRoll === 1 || numOfRoll === 2 ? fakeDice : incrementDiceResult
    )

    let board = game.determinePlayOrder(dice)
    expect(board).toBeUndefined()
    board = game.determinePlayOrder(incrementDiceResult)
    expect(board).toBeDefined()
  })
})