export interface UserInputReader {
  askUserToRollDice(): Promise<void>
  finish(): void
}
