
public class Places {
    boolean hasCarrier;
    boolean hasBattleship;
    boolean hasCruiser;
    boolean hasCruiser2;
    boolean hasDestroyer;
    boolean missedShot;
    boolean madeShot;
    boolean empty;
    boolean hasBeenSunk;
    boolean hasBeenHit;

    Places(boolean hasCarrier, boolean hasBattleship, boolean hasCruiser, boolean hasCruiser2, boolean hasDestroyer, boolean missedShot, boolean madeShot, boolean empty, boolean hasBeenSunk, boolean hasBeenHit) {
        this.hasCarrier = hasCarrier;
        this.hasBattleship = hasBattleship;
        this.hasCruiser = hasCruiser;
        this.hasCruiser2 = hasCruiser2;
        this.hasDestroyer = hasDestroyer;
        this.missedShot = missedShot;
        this.madeShot = madeShot;
        this.empty = empty;
        this.hasBeenSunk = hasBeenSunk;
        this.hasBeenHit = hasBeenHit;
    }
    @Override
    public String toString() {
        String toReturn = "?";

        if (this.hasCarrier) {
            toReturn = "s";
        }
        if (this.hasBattleship) {
            toReturn = "s";
        }
        if (this.hasCruiser) {
            toReturn = "s";
        }
        if (this.hasCruiser2) {
            toReturn = "s";
        }
        if (this.hasDestroyer) {
            toReturn = "s";
        }
        if (this.madeShot) {
            toReturn =  "x";
        }
        if (this.empty) {
            toReturn = "~";
        }
        if (this.missedShot) {
            toReturn = "o";
        }

        if (this.hasBeenSunk) {
            toReturn = "X";
        }
        return toReturn;
    }
}
