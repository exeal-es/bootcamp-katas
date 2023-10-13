
export class Token {
    private position: number

    constructor(position: number = 1) {
        this.position = position
    }

    public getPosition(): number {
        return this.position
    }

    public move(spaces: number): void {
        if (!this.moveAllowed(spaces)) {
            return
        }
        this.position += spaces
    }

    public hasWon(): boolean {
        return this.position === 100
    }

    private moveAllowed(spaces: number): boolean {
        return this.position + spaces <= 100
    }
}
