/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EduManager.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin extends User {
  public Admin(int userId, String password, String firstName, String lastName, String email, String phoneNumber) {
    super(userId, password, firstName, lastName, email, phoneNumber);
  }
}
