package it.unive.dais.po1.vehicles;

public class NegativeSpeedException extends ImpossibleAccelerationException {
    public NegativeSpeedException(double acceleration) {
        super("You passed a negative speed here. Its value was "+acceleration);
    }
}
