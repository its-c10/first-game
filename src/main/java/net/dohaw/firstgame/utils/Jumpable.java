package net.dohaw.firstgame.utils;

public interface Jumpable {
    boolean isJumping();
    void setIsJumping(boolean isJumping);
    int getJumpingAmount();
    void jump();
}
