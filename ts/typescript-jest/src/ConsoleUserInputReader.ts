import * as readline from 'readline'
import { UserInputReader } from './UserInputReader'

export class ConsoleUserInputReader implements UserInputReader {
  public reader: readline.Interface

  constructor(reader: readline.Interface) {
    this.reader = reader
  }

  public askUserToRollDice(): Promise<void> {
    this.reader.prompt()
    return new Promise((resolve) => {
      this.reader.on('line', () => {
        this.reader.removeAllListeners('line')
        resolve()
      })
    })
  }

  public finish(): void {
    this.reader.close()
  }
}
