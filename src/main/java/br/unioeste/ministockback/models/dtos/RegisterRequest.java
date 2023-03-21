package br.unioeste.ministockback.models.dtos;

import br.unioeste.ministockback.models.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;

    private String password;

    private Role role;
}
