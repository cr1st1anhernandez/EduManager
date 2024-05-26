/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EduManager.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class Utilities {

  public static String hashPassword(String password) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] hashedBytes = md.digest(password.getBytes());
      StringBuilder sb = new StringBuilder();
      for (byte b : hashedBytes) {
        sb.append(String.format("%02x", b));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void togglePasswordIcon(javax.swing.JPasswordField passwordField, javax.swing.JButton showPasswordButton) {
    if (passwordField.getEchoChar() == 0) {
      passwordField.setEchoChar('•');
      showPasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/eyeOpen.png")));
    } else {
      passwordField.setEchoChar((char) 0);
      showPasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/eyeClose.png")));
    }
  }
}
