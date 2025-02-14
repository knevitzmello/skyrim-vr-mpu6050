# skyrim-vr-mpu6050
An Arduino-based interface for accelerometer and gyroscope input, originally designed for Skyrim VR but adaptable for other applications.

This program enables mouse control using an MPU6050 sensor connected to an Arduino, replacing the gyroscope and accelerometer typically found in smartphones. It is designed to be mounted on a VR headset for enhanced motion tracking.

Additionally, a variation of this setup can be attached to the player's hands, allowing for immersive interactions such as simulating the drawing of a bowstring or charging a spell in the game.

A Java application processes the USB data received from the microcontroller and controls the mouse using the Robot library.
