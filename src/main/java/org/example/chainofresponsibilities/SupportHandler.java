package org.example.chainofresponsibilities;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public SupportHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void support(String problem);
}
