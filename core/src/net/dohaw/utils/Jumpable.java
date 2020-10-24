package net.dohaw.utils;

public interface Jumpable {

    /**
     *
     * @return jump force
     */
    float getJumpForce();

    /**
     *
     * @param force force of jump
     */
    void setJumpForce(float force);

    /**
     *
     * @return whether the object is jumping or not
     */
    boolean isJumping();

    /**
     *
     * @param isJumping if the object is jumping
     *
     */
    void setIsJumping(boolean isJumping);

    /**
     *
     * @return whether the object can double jump
     */
    boolean canDoubleJump();

}
